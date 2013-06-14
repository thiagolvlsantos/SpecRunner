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
package org.specrunner.plugins.impl.elements;

import org.specrunner.SpecRunnerServices;
import org.specrunner.context.IContext;
import org.specrunner.features.IFeatureManager;
import org.specrunner.plugins.ActionType;
import org.specrunner.plugins.ENext;
import org.specrunner.plugins.PluginException;
import org.specrunner.plugins.impl.AbstractPluginScoped;
import org.specrunner.plugins.type.Command;
import org.specrunner.result.IResultSet;
import org.specrunner.util.UtilEvaluator;

/**
 * Html tag scope.
 * 
 * @author Thiago Santos
 * 
 */
public class PluginHtml extends AbstractPluginScoped {

    /**
     * The bean name.
     */
    public static final String BEAN_NAME = "obj";

    @Override
    public ActionType getActionType() {
        return Command.INSTANCE;
    }

    @Override
    public ENext doStart(IContext context, IResultSet result) throws PluginException {
        Object obj = SpecRunnerServices.get(IFeatureManager.class).get(BEAN_NAME);
        context.saveLocal(UtilEvaluator.asVariable(BEAN_NAME), obj);
        return ENext.DEEP;
    }

    /**
     * Get the test object class.
     * 
     * @return The test instance.
     */
    public static Object getTestInstance() {
        return SpecRunnerServices.get(IFeatureManager.class).get(BEAN_NAME);
    }
}