/*
    SpecRunner - Acceptance Test Driven Development Tool
    Copyright (C) 2011-2014  Thiago Santos

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
package org.specrunner.listeners.core;

import nu.xom.Attribute;
import nu.xom.Element;
import nu.xom.Node;

import org.specrunner.SRServices;
import org.specrunner.SpecRunnerException;
import org.specrunner.context.IContext;
import org.specrunner.listeners.INodeListener;
import org.specrunner.listeners.IScenarioListener;
import org.specrunner.plugins.ENext;
import org.specrunner.plugins.PluginException;
import org.specrunner.result.IResultSet;
import org.specrunner.util.UtilLog;
import org.specrunner.util.UtilString;
import org.specrunner.util.xom.INodeHolder;
import org.specrunner.util.xom.UtilNode;

/**
 * Monitor for scenarios frames.
 * 
 * @author Thiago Santos.
 * 
 */
public abstract class ScenarioFrameListener implements INodeListener {

    /**
     * Feature to show time for scenarios.
     */
    public static final String FEATURE_SHOW_TIME = ScenarioFrameListener.class.getName() + ".showTime";

    /**
     * Expected style for scenarios.
     */
    public static final String CSS_SCENARIO = "scenario";
    /**
     * Expected style for success scenarios.
     */
    public static final String CSS_SCENARIO_SUCCESS = "scenarioSuccess";
    /**
     * Expected style for failure scenarios.
     */
    public static final String CSS_SCENARIO_FAILURE = "scenarioFailure";
    /**
     * Expected style for pending scenarios.
     */
    public static final String CSS_SCENARIO_PENDING = "scenarioPending";
    /**
     * Expected style for scenario titles.
     */
    public static final String CSS_TITLE = "title";

    /**
     * The listener name.
     */
    protected String name;
    /**
     * Scenario listeners.
     */
    protected IScenarioListener[] listeners;
    /**
     * An auxiliary node holder.
     */
    protected INodeHolder holder;
    /**
     * The node which holds the scenario.
     */
    protected Node scenario;
    /**
     * The node which holds the title.
     */
    protected Node title;
    /**
     * Time scenario has started.
     */
    protected long startTime;
    /**
     * A checkpoint where in the general result the scenario starts.
     */
    protected int checkpoint;
    /**
     * Indicate if scenario is pending.
     */
    protected boolean pending = true;
    /**
     * The subset of general result for this scenario.
     */
    protected IResultSet subset;

    /**
     * Creates a names scenario listener. The scenario name must be the same of
     * the corresponding scenario it is expected to monitor.
     * 
     * @param name
     *            The scenario.
     * @param listeners
     *            List of scenario listeners.
     */
    public ScenarioFrameListener(String name, IScenarioListener... listeners) {
        this.name = name;
        this.listeners = listeners;
    }

    /**
     * The fixture instance.
     * 
     * @return The fixture object, if it exists, null, otherwise.
     */
    public abstract Object getInstance();

    @Override
    public void reset() {
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ENext onBefore(Node node, IContext context, IResultSet result) {
        long time = System.currentTimeMillis();
        ENext next = ENext.DEEP;
        if (holder == null) {
            holder = UtilNode.newNodeHolder(node);
        } else {
            holder.setNode(node);
        }
        if (CSS_SCENARIO.equals(holder.getQualifiedName()) || holder.attributeContains(UtilNode.ATT_CSS, CSS_SCENARIO)) {
            try {
                Node sub = UtilNode.getCssNodeOrElement(node, CSS_TITLE);
                String str = UtilString.camelCase(sub.getValue(), true);
                if (name.equals(str)) {
                    scenario = node;
                    title = sub;
                    startTime = time;
                    checkpoint = result.size();
                    pending = UtilNode.isPending(node);
                    if (pending) {
                        next = ENext.SKIP;
                    } else {
                        fireBefore(name, node, context, result, getInstance());
                    }
                }
            } catch (PluginException e) {
                throw new RuntimeException(e);
            } catch (SpecRunnerException e) {
                throw new RuntimeException(e);
            }
        }
        return next;
    }

    /**
     * Fire listeners before scenarios.
     * 
     * @param title
     *            The scenario title.
     * @param node
     *            The scenario node.
     * @param context
     *            The test context.
     * @param result
     *            The result set.
     * @param instance
     *            The fixture object, if it exists, null, otherwise.
     * @throws SpecRunnerException
     *             On event errors.
     */
    protected void fireBefore(String title, Node node, IContext context, IResultSet result, Object instance) throws SpecRunnerException {
        if (listeners != null) {
            for (int i = 0; i < listeners.length; i++) {
                listeners[i].beforeScenario(title, node, context, result, instance);
            }
        }
    }

    @Override
    public void onAfter(Node node, IContext context, IResultSet result) {
        if (this.scenario == node) {
            this.subset = result.subSet(checkpoint, result.size());
            if (UtilNode.isPending(node)) {
                if (UtilLog.LOG.isInfoEnabled()) {
                    UtilLog.LOG.info("Scenario PENDING:" + name);
                }
                UtilNode.appendCss(node, CSS_SCENARIO_PENDING);
            } else if (subset.getStatus().isError()) {
                if (UtilLog.LOG.isInfoEnabled()) {
                    UtilLog.LOG.info("Scenario FAILURE:" + name);
                }
                UtilNode.appendCss(node, CSS_SCENARIO_FAILURE);
            } else {
                if (UtilLog.LOG.isInfoEnabled()) {
                    UtilLog.LOG.info("Scenario SUCCESS:" + name);
                }
                UtilNode.appendCss(node, CSS_SCENARIO_SUCCESS);
            }
            try {
                fireAfter(name, node, context, result, getInstance());
            } catch (SpecRunnerException e) {
                throw new RuntimeException(e);
            }
            Boolean show = (Boolean) SRServices.getFeatureManager().get(FEATURE_SHOW_TIME, Boolean.TRUE);
            if (show) {
                Element span = new Element("span");
                span.addAttribute(new Attribute("class", "scenarioTime"));
                span.appendChild((System.currentTimeMillis() - startTime) + " ms");
                UtilNode.newNodeHolder(title).prepend(span);
            }
        }
    }

    /**
     * Fire listeners after scenarios.
     * 
     * @param title
     *            The scenario title.
     * @param node
     *            The scenario node.
     * @param context
     *            The test context.
     * @param test
     *            The test class wrapper.
     * @param result
     *            The result set.
     * @param instance
     *            The fixture object, if it exists, null, otherwise.
     * @throws SpecRunnerException
     *             On event errors.
     */
    protected void fireAfter(String title, Node node, IContext context, IResultSet result, Object instance) throws SpecRunnerException {
        if (listeners != null) {
            for (int i = listeners.length - 1; i >= 0; i--) {
                listeners[i].afterScenario(title, node, context, result, instance);
            }
        }
    }

    /**
     * Answer if the scenario is pending.
     * 
     * @return true, if pending, false, otherwise.
     */
    public boolean isPending() {
        return pending;
    }

    /**
     * Get the result subset specific to this scenario.
     * 
     * @return The result subset.
     */
    public IResultSet getResult() {
        return subset;
    }
}