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
package org.specrunner.runner.impl;

import java.util.List;

import nu.xom.Element;
import nu.xom.Node;

import org.specrunner.SpecRunnerException;
import org.specrunner.SpecRunnerServices;
import org.specrunner.context.IBlock;
import org.specrunner.context.IContext;
import org.specrunner.context.IModel;
import org.specrunner.listeners.IListenerManager;
import org.specrunner.listeners.IPluginListener;
import org.specrunner.listeners.ISourceListener;
import org.specrunner.plugins.ENext;
import org.specrunner.plugins.IPlugin;
import org.specrunner.plugins.IPluginFactory;
import org.specrunner.plugins.IPluginGroup;
import org.specrunner.plugins.ISleepPlugin;
import org.specrunner.plugins.ITestPlugin;
import org.specrunner.plugins.ITimedPlugin;
import org.specrunner.plugins.PluginException;
import org.specrunner.plugins.impl.UtilPlugin;
import org.specrunner.result.IResultSet;
import org.specrunner.result.Status;
import org.specrunner.runner.IRunner;
import org.specrunner.runner.RunnerException;
import org.specrunner.source.ISource;
import org.specrunner.source.SourceException;
import org.specrunner.util.UtilEvaluator;
import org.specrunner.util.UtilLog;

/**
 * Default runner implementation.
 * 
 * @author Thiago Santos
 * 
 */
public class RunnerImpl implements IRunner {

    @Override
    public void run(ISource source, IContext context, IResultSet result) throws RunnerException {
        List<ISourceListener> listeners = SpecRunnerServices.get(IListenerManager.class).filterByType(ISourceListener.class);
        // perform before listeners
        for (ISourceListener sl : listeners) {
            sl.onBefore(context, result);
        }
        try {
            // call recursive execution on document root node
            local(source.getDocument(), context, result, null);
        } catch (SourceException e) {
            if (UtilLog.LOG.isDebugEnabled()) {
                UtilLog.LOG.debug(e.getMessage(), e);
            }
            throw new RunnerException(e);
        } finally {
            // perform after listeners
            for (ISourceListener sl : listeners) {
                sl.onAfter(context, result);
            }
        }
    }

    @Override
    public void run(Node node, IContext context, IResultSet result) throws RunnerException {
        local(node, context, result, null);
    }

    @Override
    public void run(IPlugin plugin, IContext context, IResultSet result) throws RunnerException {
        if (plugin instanceof IPluginGroup) {
            IPluginGroup group = (IPluginGroup) plugin;
            for (IPlugin p : group.getChildren()) {
                run(p, context, result);
            }
        } else {
            local(null, context, result, plugin);
        }
    }

    protected void local(Node node, IContext context, IResultSet result, IPlugin previous) throws RunnerException {
        IPlugin plugin = null;
        IBlock block = null;
        try {
            if (previous == null) {
                // create a plugin based on node information
                plugin = SpecRunnerServices.get(IPluginFactory.class).newPlugin(node, context);
            } else {
                plugin = previous;
            }
            // new block for node
            block = context.newBlock(node, plugin);
            // queue block to the context
            context.push(block);

            // ----------- METAVARIABLES --------------
            // meta variable 'node'
            context.saveLocal(UtilEvaluator.asVariable("node"), node);
            // meta variable 'plugin'
            context.saveLocal(UtilEvaluator.asVariable("plugin"), plugin);
            // meta variable 'block'
            context.saveLocal(UtilEvaluator.asVariable("block"), block);

            List<IPluginListener> listeners = SpecRunnerServices.get(IListenerManager.class).filterByType(IPluginListener.class);
            // perform before initialization
            for (IPluginListener sl : listeners) {
                sl.onBeforeInit(context, result);
            }
            try {
                // initialize the plugin
                plugin.initialize(context);
            } finally {
                // perform after initialization
                for (IPluginListener sl : listeners) {
                    sl.onAfterInit(context, result);
                }
            }
            if (checkConditional(plugin, context)) {
                // perform before start
                for (IPluginListener sl : listeners) {
                    sl.onBeforeStart(context, result);
                }
                ENext next = null;
                try {
                    long time = System.currentTimeMillis();
                    // perform start
                    next = plugin.doStart(context, result);
                    // check step timeout
                    checkTimeout(context, result, plugin, time, "doStart()");
                } finally {
                    // perform after start
                    for (IPluginListener sl : listeners) {
                        sl.onAfterStart(context, result);
                    }
                }
                if (node != null) {
                    // if plugin indicates to go deeper in node and node has
                    // children.
                    if (next == ENext.DEEP && block.hasChildren()) {
                        Node deep = node;
                        // if doStart() has changed the block information, for
                        // example, exchange its node, the deeper must be over
                        // the current node.
                        if (block.isChanged()) {
                            deep = block.getNode();
                        }
                        // for each children.
                        for (int i = 0; i < deep.getChildCount(); i++) {
                            Node child = deep.getChild(i);
                            if (child instanceof Element) {
                                // if not ignored marked
                                if (!UtilPlugin.isIgnore(child)) {
                                    // recursive execution
                                    local(child, context, result, null);
                                }
                            } else {
                                // recursive execution
                                local(child, context, result, null);
                            }
                        }
                    }
                }
                // perform before end
                for (IPluginListener sl : listeners) {
                    sl.onBeforeEnd(context, result);
                }
                try {
                    final long time = System.currentTimeMillis();
                    // perform end
                    plugin.doEnd(context, result);
                    // check step timeout
                    checkTimeout(context, result, plugin, time, "doEnd()");
                } finally {
                    // perform after end
                    for (IPluginListener sl : listeners) {
                        sl.onAfterEnd(context, result);
                    }
                }
            } else {
                if (node != null) {
                    result.addResult(Status.INFO, context.newBlock(node, plugin), "Conditional '" + ((Element) node).getAttributeValue("condition") + "' prevented execution.");
                } else {
                    result.addResult(Status.INFO, context.newBlock(node, plugin), "Conditional prevented execution. " + plugin);
                }
            }
            // sleep if required
            checkSleep(plugin, context);
        } catch (Throwable e) {
            if (UtilLog.LOG.isDebugEnabled()) {
                UtilLog.LOG.debug(e.getMessage(), e);
            }
            // any failure back to specification
            result.addResult(Status.FAILURE, context.newBlock(node, plugin), e);
        } finally {
            if (block != null) {
                // remove block from context
                context.pop();
            }
        }
    }

    protected boolean checkConditional(IPlugin plugin, IContext context) throws SpecRunnerException {
        Boolean out = null;
        if (plugin instanceof ITestPlugin) {
            ITestPlugin testPlugin = (ITestPlugin) plugin;
            IModel<Object, Boolean> model = testPlugin.getConditionModel();
            if (model != null) {
                out = model.getObject(context);
            } else {
                out = testPlugin.getCondition();
            }
        }
        return out == null || out;
    }

    protected void checkTimeout(IContext context, IResultSet result, IPlugin plugin, long start, String method) throws SpecRunnerException {
        long total = System.currentTimeMillis() - start;
        if (plugin instanceof ITimedPlugin) {
            ITimedPlugin timedPlugin = (ITimedPlugin) plugin;
            IModel<Object, Long> model = timedPlugin.getTimeoutModel();
            Long timeout = null;
            if (model != null) {
                timeout = model.getObject(context);
            } else {
                timeout = timedPlugin.getTimeout();
            }
            if (timeout != null && total > timeout) {
                result.addResult(Status.FAILURE, context.peek(), new PluginException(method + " has run out of time. time(" + total + ") > timeout(" + timeout + ")"));
            }
        }
    }

    protected void checkSleep(IPlugin plugin, IContext context) throws SpecRunnerException {
        if (plugin instanceof ISleepPlugin) {
            ISleepPlugin sleepPlugin = (ISleepPlugin) plugin;
            IModel<Object, Long> model = sleepPlugin.getSleepModel();
            Long sleep = null;
            if (model != null) {
                sleep = model.getObject(context);
            } else {
                sleep = sleepPlugin.getSleep();
            }
            if (sleep != null) {
                try {
                    if (UtilLog.LOG.isInfoEnabled()) {
                        UtilLog.LOG.info("Sleep for " + sleep + "mls.");
                    }
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                    if (UtilLog.LOG.isDebugEnabled()) {
                        UtilLog.LOG.debug(e.getMessage(), e);
                    }
                }
            }
        }
    }
}