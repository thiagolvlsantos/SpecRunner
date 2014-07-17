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
package org.specrunner.webdriver.actions;

import org.openqa.selenium.WebElement;

/**
 * Select a given element, or a list of elements in &lt;ul&gt;.
 * 
 * @author Thiago Santos
 * 
 */
public class PluginSelect extends AbstractPluginSelect {

    @Override
    protected void doSomething(WebElement element, WebElement option) {
        if (!option.isSelected()) {
            option.click();
        }
    }
}