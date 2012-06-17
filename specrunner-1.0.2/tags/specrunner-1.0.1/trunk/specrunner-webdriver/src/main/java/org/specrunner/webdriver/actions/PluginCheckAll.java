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
import org.openqa.selenium.WebElement;
import org.specrunner.context.IContext;
import org.specrunner.plugins.PluginException;
import org.specrunner.result.IResultSet;
import org.specrunner.result.Status;
import org.specrunner.webdriver.AbstractPluginFind;
import org.specrunner.webdriver.util.WritablePage;

/**
 * Check itens not checked.
 * 
 * @author Thiago Santos
 * 
 */
public class PluginCheckAll extends AbstractPluginFind implements IAction {

    private Boolean status = true;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    protected void process(IContext context, IResultSet result, WebDriver client, WebElement[] elements) throws PluginException {
        boolean success = true;
        for (int i = 0; i < elements.length; i++) {
            WebElement e = elements[i];
            if (!isCheckbox(e)) {
                result.addResult(Status.FAILURE, context.peek(), new PluginException("Element " + e + " is not a checkbox."), new WritablePage(client));
                success = false;
                break;
            }
            if (!e.isSelected()) {
                e.click();
            }
        }
        if (success) {
            result.addResult(Status.SUCCESS, context.peek());
        }
    }

    private boolean isCheckbox(WebElement e) {
        return "input".equals(e.getTagName()) && "checkbox".equals(e.getAttribute("type"));
    }
}