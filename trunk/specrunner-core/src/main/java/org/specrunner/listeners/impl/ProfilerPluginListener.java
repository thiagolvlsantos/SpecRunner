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
package org.specrunner.listeners.impl;

import java.util.Stack;

import org.specrunner.context.IContext;
import org.specrunner.listeners.IPluginListener;
import org.specrunner.plugins.IPlugin;
import org.specrunner.result.IResultSet;
import org.specrunner.util.UtilLog;

/**
 * Logging profiler implementation.
 * 
 * @author Thiago Santos.
 * 
 */
public class ProfilerPluginListener implements IPluginListener {

    /**
     * Threshold to appear in log.
     */
    private static final int TRESHOLD = 5;
    /**
     * Stack of initialization times.
     */
    private final Stack<Long> timeInit = new Stack<Long>();
    /**
     * Stack of start times.
     */
    private final Stack<Long> timeStart = new Stack<Long>();
    /**
     * Stack of end times.
     */
    private final Stack<Long> timeEnd = new Stack<Long>();

    @Override
    public String getName() {
        return "profilerPlugin";
    }

    @Override
    public void reset() {
        timeInit.clear();
        timeStart.clear();
        timeEnd.clear();
    }

    @Override
    public void onBeforeInit(IPlugin plugin, IContext context, IResultSet result) {
        timeInit.push(System.currentTimeMillis());
    }

    @Override
    public void onAfterInit(IPlugin plugin, IContext context, IResultSet result) {
        long time = (System.currentTimeMillis() - timeInit.pop());
        if (UtilLog.LOG.isDebugEnabled() && time > TRESHOLD) {
            UtilLog.LOG.debug("initialize(): " + time + "mls. On " + context.getPlugin());
        }
    }

    @Override
    public void onBeforeStart(IPlugin plugin, IContext context, IResultSet result) {
        timeStart.push(System.currentTimeMillis());
    }

    @Override
    public void onAfterStart(IPlugin plugin, IContext context, IResultSet result) {
        long time = (System.currentTimeMillis() - timeStart.pop());
        if (UtilLog.LOG.isDebugEnabled() && time > TRESHOLD) {
            UtilLog.LOG.debug("doStart(): " + time + "mls. On " + context.getPlugin());
        }
    }

    @Override
    public void onBeforeEnd(IPlugin plugin, IContext context, IResultSet result) {
        timeEnd.push(System.currentTimeMillis());
    }

    @Override
    public void onAfterEnd(IPlugin plugin, IContext context, IResultSet result) {
        long time = (System.currentTimeMillis() - timeEnd.pop());
        if (UtilLog.LOG.isDebugEnabled() && time > TRESHOLD) {
            UtilLog.LOG.debug("  doEnd(): " + time + "mls. On " + context.getPlugin());
        }
    }
}
