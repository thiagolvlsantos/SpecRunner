/*
    SpecRunner - Acceptance Test Driven Development Tool
    Copyright (C) 2011-2013  Thiago Santos

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>
 */
package org.specrunner.junit;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

import org.junit.runners.model.Statement;
import org.junit.runners.model.TestClass;
import org.specrunner.ISpecRunner;
import org.specrunner.SRServices;
import org.specrunner.configuration.IConfiguration;
import org.specrunner.configuration.IConfigurationFactory;
import org.specrunner.core.SpecRunnerPipelineUtils;
import org.specrunner.dumper.core.ConstantsDumperFile;
import org.specrunner.listeners.IListenerManager;
import org.specrunner.listeners.INodeListener;
import org.specrunner.listeners.ISpecRunnerListener;
import org.specrunner.plugins.core.elements.PluginHtml;
import org.specrunner.result.IResultSet;
import org.specrunner.util.UtilLog;

/**
 * Generic statement for SpecRunner Junit extensions.
 * 
 * @author Thiago Santos
 * 
 */
public class SpecRunnerStatement extends Statement {

    /**
     * The test class.
     */
    private TestClass test;
    /**
     * The test instance.
     */
    private Object instance;

    /**
     * The input file.
     */
    private File input;

    /**
     * The output file.
     */
    private File output;

    /**
     * Listener to activate.
     */
    private List<INodeListener> listeners;

    /**
     * The testing object.
     * 
     * @param test
     *            The test meta-data.
     * @param instance
     *            The test instance.
     * @param listeners
     *            The listeners to activate.
     */
    public SpecRunnerStatement(TestClass test, Object instance, List<INodeListener> listeners) {
        this.test = test;
        this.instance = instance;
        this.listeners = listeners;
        Class<?> clazz = test.getJavaClass();
        input = getInput(clazz);
        output = getOutput(clazz);
    }

    /**
     * Get input file name.
     * 
     * @param clazz
     *            The class.
     * @return The corresponding file name.
     */
    protected File getInput(Class<?> clazz) {
        return JUnitUtils.getFile(clazz);
    }

    /**
     * Get output file name.
     * 
     * @param clazz
     *            The class.
     * @return The corresponding file name.
     */
    protected File getOutput(Class<?> clazz) {
        return JUnitUtils.getOutput(clazz, input);
    }

    @Override
    public void evaluate() throws Throwable {
        IConfiguration cfg = SRServices.get(IConfigurationFactory.class).newConfiguration();
        IListenerManager lm = SRServices.get(IListenerManager.class);
        for (ISpecRunnerListener s : listeners) {
            lm.add(s);
        }
        IResultSet result;
        try {
            ISpecRunner srunner = SRServices.getSpecRunner();
            result = srunner.run(input.getPath(), configure(cfg));
        } finally {
            for (ISpecRunnerListener s : listeners) {
                lm.remove(s);
            }
        }
        if (result.getStatus().isError()) {
            throw new Exception("OUTPUT: " + output.getAbsoluteFile() + "\n" + result.asString());
        }
    }

    /**
     * Get expected messages if any.
     * 
     * @return The list of error messages.
     */
    protected ExpectedMessages getMessages() {
        Annotation[] ans = test.getAnnotations();
        for (Annotation an : ans) {
            if (an instanceof ExpectedMessages) {
                return (ExpectedMessages) an;
            }
        }
        return null;
    }

    /**
     * Set configuration.
     * 
     * @param cfg
     *            The configuration.
     * @return The configuration itself.
     * @throws Throwable
     *             On configuration errors.
     */
    protected IConfiguration configure(IConfiguration cfg) throws Throwable {
        Annotation[] ans = instance.getClass().getAnnotations();
        for (Annotation a : ans) {
            if (a instanceof SRRunnerOptions) {
                SRRunnerOptions options = (SRRunnerOptions) a;
                cfg.add(SpecRunnerPipelineUtils.PIPELINE_FILENAME, options.pipeline());
            }
        }
        cfg.add(PluginHtml.BEAN_NAME, instance);
        cfg.add(ConstantsDumperFile.FEATURE_OUTPUT_DIRECTORY, output.getParentFile());
        cfg.add(ConstantsDumperFile.FEATURE_OUTPUT_NAME, getOutputName(output.getName()));
        ExpectedMessages expected = getMessages();
        if (expected != null) {
            cfg.add(IResultSet.FEATURE_EXPECTED_MESSAGES, expected.value());
            cfg.add(IResultSet.FEATURE_EXPECTED_SORTED, expected.sorted());
        }
        Method[] ms = instance.getClass().getMethods();
        List<Method> candidates = new LinkedList<Method>();
        for (Method m : ms) {
            Configuration c = m.getAnnotation(Configuration.class);
            if (c != null) {
                candidates.add(m);
            }
        }
        for (Method m : candidates) {
            Class<?>[] types = m.getParameterTypes();
            if (types.length == 1 && types[0] == IConfiguration.class) {
                m.invoke(instance, new Object[] { cfg });
                if (UtilLog.LOG.isInfoEnabled()) {
                    UtilLog.LOG.info("Configuration method '" + m + "' invoked.");
                }
            } else {
                if (UtilLog.LOG.isInfoEnabled()) {
                    UtilLog.LOG.info("Invalid @Configuration method '" + m + "'");
                }
            }
        }
        return cfg;
    }

    /**
     * Get the output name adjusted.
     * 
     * @param name
     *            The original name.
     * @return The adjusted name. ie. Excel (.xls,.xlsx) test files are
     *         transformed to HTML (.html).
     */
    public static String getOutputName(String name) {
        return JUnitUtils.getOutputName(name);
    }
}