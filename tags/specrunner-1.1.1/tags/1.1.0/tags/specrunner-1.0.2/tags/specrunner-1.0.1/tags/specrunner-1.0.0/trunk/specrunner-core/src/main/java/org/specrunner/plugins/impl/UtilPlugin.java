/*
    SpecRunner - Acceptance Test Driven Development Tool
    Copyright (C) 2011-2012  Thiago Santos

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
package org.specrunner.plugins.impl;

import nu.xom.Attribute;
import nu.xom.Element;
import nu.xom.Node;

import org.specrunner.SpecRunnerServices;
import org.specrunner.context.IBlockFactory;
import org.specrunner.context.IContext;
import org.specrunner.parameters.impl.UtilParametrized;
import org.specrunner.plugins.IPlugin;
import org.specrunner.plugins.PluginException;
import org.specrunner.result.IResultSet;
import org.specrunner.result.Status;
import org.specrunner.runner.IRunner;
import org.specrunner.runner.RunnerException;
import org.specrunner.util.UtilLog;
import org.specrunner.util.aligner.IStringAligner;
import org.specrunner.util.aligner.IStringAlignerFactory;
import org.specrunner.util.aligner.impl.DefaultAlignmentException;

/**
 * Plugins utility class.
 * 
 * @author Thiago Santos
 * 
 */
public final class UtilPlugin {

    private UtilPlugin() {
    }

    /**
     * Equivalent to <code>create(...,false)</code>.
     * 
     * @param context
     *            The reference context.
     * @param type
     *            The plugin type.
     * @param element
     *            The element to be used as reference for plugin creation.
     * @return The newly created plugin.
     * @throws PluginException
     *             On plugin creation errors.
     */
    public static <T extends IPlugin> T create(IContext context, Class<T> type, Element element) throws PluginException {
        return create(context, type, element, false);
    }

    /**
     * Creates a plugin based on its type. The attributes of 'element'will be
     * evaluated as expressions in the given context and used to set plugin
     * attributes with corresponding names.
     * 
     * @param context
     *            The reference context.
     * @param type
     *            The plugin type.
     * @param element
     *            The element to be used as reference for plugin creation.
     * @param true, if initialize() should be called, false, otherwise.
     * @return The newly created plugin.
     * @throws PluginException
     *             On plugin creation errors.
     */
    public static <T extends IPlugin> T create(IContext context, Class<T> type, Element element, boolean initialize) throws PluginException {
        try {
            T result = type.newInstance();
            if (UtilLog.LOG.isDebugEnabled()) {
                UtilLog.LOG.debug("result ->" + result);
            }
            UtilParametrized.setProperties(context, result, element);
            if (initialize) {
                result.initialize(context);
            }
            return result;
        } catch (Exception e) {
            if (UtilLog.LOG.isDebugEnabled()) {
                UtilLog.LOG.debug(e.getMessage(), e);
            }
            throw new PluginException("Could not create a plugin for " + type + "." + e.getMessage(), e);
        }
    }

    /**
     * Adds the information that a given node might be ignored by runners.
     * 
     * @param node
     *            The node to be ignored.
     */
    public static void setIgnore(Node node) {
        if (node instanceof Element) {
            ((Element) node).addAttribute(new Attribute(IRunner.IGNORE, "true"));
        }
    }

    /**
     * Check is a node is marked to be ignored.
     * 
     * @param node
     *            The node to be checked.
     * @return true, if node can be ignored, false, otherwise.
     */
    public static boolean isIgnore(Node node) {
        return node instanceof Element && ((Element) node).getAttribute(IRunner.IGNORE) != null;
    }

    /**
     * Executes the children of a given node.
     * 
     * @param node
     *            The parent node.
     * @param context
     *            The context.
     * @param result
     *            The result set.
     * @throws PluginException
     *             On execution errors.
     */
    public static void performChildren(Node node, IContext context, IResultSet result) throws PluginException {
        for (int i = 0; i < node.getChildCount(); i++) {
            Node t = node.getChild(i);
            try {
                context.getRunner().run(t, context, result);
            } catch (RunnerException e) {
                if (UtilLog.LOG.isDebugEnabled()) {
                    UtilLog.LOG.debug(e.getMessage(), e);
                }
                throw new PluginException(e);
            }
        }
    }

    /**
     * Perform a comparation and add the result to the given node.
     * 
     * @param node
     *            Node to be annotated.
     * @param result
     *            The result set.
     * @param expected
     *            The expected String.
     * @param received
     *            The received String
     * @throws PluginException
     *             On plugin errors.
     */
    public static void compare(Node node, IResultSet result, String expected, String received) throws PluginException {
        if (expected.equals(received)) {
            result.addResult(Status.SUCCESS, SpecRunnerServices.get(IBlockFactory.class).newBlock(node, null));
        } else {
            IStringAligner sa = SpecRunnerServices.get(IStringAlignerFactory.class).align(expected, received);
            result.addResult(Status.FAILURE, SpecRunnerServices.get(IBlockFactory.class).newBlock(node, null), new DefaultAlignmentException(sa));
        }
    }
}