/*
    SpecRunner - Acceptance Test Driven Development Tool
    Copyright (C) 2011-2016  Thiago Santos

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
package org.specrunner.webdriver.result;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.specrunner.result.IWritable;
import org.specrunner.result.IWritableFactory;

/**
 * Writable factory for WebDriver.
 * 
 * @author Thiago Santos
 */
@SuppressWarnings("serial")
public class WritableFactoryWebDriver implements IWritableFactory<WebDriver> {

    @Override
    public void initialize() {
    }

    @Override
    public Class<WebDriver> getType() {
        return WebDriver.class;
    }

    @Override
    public IWritable newWritable(WebDriver driver) {
        return newWritable(null, driver);
    }

    @Override
    public IWritable newWritable(Map<String, Object> information, WebDriver driver) {
        return new WritableWebDriver(information, driver);
    }
}
