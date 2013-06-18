package org.specrunner.junit;

import java.io.File;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.runners.model.Statement;
import org.junit.runners.model.TestClass;
import org.specrunner.SpecRunnerServices;
import org.specrunner.configuration.IConfiguration;
import org.specrunner.configuration.IConfigurationFactory;
import org.specrunner.dumper.impl.AbstractSourceDumperFile;
import org.specrunner.plugins.impl.elements.PluginHtml;
import org.specrunner.result.IResult;
import org.specrunner.result.IResultSet;

/**
 * Generic statement for SpecRunner Junit extensions.
 * 
 * @author Thiago Santos
 * 
 */
public class SpecRunnerStatement extends Statement {
    /**
     * Allowed extensions of file.
     */
    public static final String EXTENSIONS = System.getProperty("sr.extensions", ".xhtml,.html,.htm");
    /**
     * Output path.
     */
    public static final String PATH = System.getProperty("sr.output", "target/output/");

    /**
     * The test class.
     */
    private TestClass test;
    /**
     * The test instance.
     */
    private Object instance;

    /**
     * The testing object.
     * 
     * @param test
     *            The test meta-data.
     * @param instance
     *            The test instance.
     */
    public SpecRunnerStatement(TestClass test, Object instance) {
        this.test = test;
        this.instance = instance;
    }

    @Override
    public void evaluate() throws Throwable {
        IConfiguration cfg = SpecRunnerServices.get(IConfigurationFactory.class).newConfiguration();
        cfg.add(PluginHtml.BEAN_NAME, instance);
        Class<?> clazz = test.getJavaClass();
        String[] messages = getMessages();
        File input = getFile(clazz);
        File output = getOutput(clazz, input);
        cfg.add(AbstractSourceDumperFile.FEATURE_OUTPUT_DIRECTORY, output.getParentFile());
        cfg.add(AbstractSourceDumperFile.FEATURE_OUTPUT_NAME, output.getName());
        IResultSet result = SpecRunnerServices.getSpecRunner().run(input.getPath(), cfg);
        if (messages == null) {
            if (result.getStatus().isError()) {
                throw new Exception(result.asString());
            }
        } else {
            List<String> received = new LinkedList<String>();
            for (IResult r : result) {
                if (r.getStatus().isError()) {
                    received.add(r.getMessage() != null ? r.getMessage() : r.getFailure().getMessage());
                }
            }
            for (int i = 0; i < messages.length; i++) {
                if (!messages[i].equals(received.get(i))) {
                    throw new Exception("Message '" + messages[i] + "' does not match '" + received.get(i) + "'");
                }
            }
        }
    }

    /**
     * Get expected messages if any.
     * 
     * @return The list of error messages.
     */
    protected String[] getMessages() {
        String[] messages = null;
        Annotation[] ans = test.getAnnotations();
        for (Annotation an : ans) {
            if (an instanceof ExpectedMessages) {
                messages = ((ExpectedMessages) an).messages();
                break;
            }
        }
        return messages;
    }

    /**
     * Get the HTML file corresponding to the Java.
     * 
     * @param clazz
     *            The test class.
     * 
     * @return The input HTML file.
     */
    protected File getFile(Class<?> clazz) {
        URL location = clazz.getProtectionDomain().getCodeSource().getLocation();
        String str = location.toString();
        str = str.replace("file:\\\\", "").replace("file:///", "").replace("file:\\", "").replace("file:/", "");
        String prefix = str + clazz.getPackage().getName().replace(".", File.separator) + File.separator + clazz.getSimpleName();
        String[] extensions = EXTENSIONS.split(",");
        for (String s : extensions) {
            File tmp = new File(prefix + s);
            if (tmp.exists()) {
                return tmp;
            }
        }
        throw new RuntimeException("File with one of extensions '" + Arrays.toString(extensions) + "' to " + prefix + " not found!");
    }

    /**
     * Get the output file.
     * 
     * @param clazz
     *            The test class.
     * @param input
     *            The input file.
     * @return The output file.
     */
    public File getOutput(Class<?> clazz, File input) {
        return new File(new File(PATH + clazz.getPackage().getName().replace('.', File.separatorChar)).getAbsoluteFile(), input.getName());
    }
}
