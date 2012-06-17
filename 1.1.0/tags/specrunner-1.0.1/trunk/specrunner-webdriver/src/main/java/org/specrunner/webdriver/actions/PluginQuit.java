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
package org.specrunner.webdriver.actions;

import org.openqa.selenium.WebDriver;
import org.specrunner.SpecRunnerServices;
import org.specrunner.context.IContext;
import org.specrunner.plugins.PluginException;
import org.specrunner.result.IResultSet;
import org.specrunner.result.Status;
import org.specrunner.reuse.IReusableManager;
import org.specrunner.webdriver.AbstractPluginUrlAware;

/**
 * Quits the driver.
 * 
 * @author Thiago Santos
 * 
 */
public class PluginQuit extends AbstractPluginUrlAware implements IAction {

    @Override
    protected void doEnd(IContext context, IResultSet result, WebDriver client) throws PluginException {
        // only not reusable browser can be quit.
        if (SpecRunnerServices.get(IReusableManager.class).get(getBrowserName()) == null) {
            client.quit();
        }
        result.addResult(Status.SUCCESS, context.peek());
    }

    @Override
    protected boolean isWait() {
        return false;
    }
}