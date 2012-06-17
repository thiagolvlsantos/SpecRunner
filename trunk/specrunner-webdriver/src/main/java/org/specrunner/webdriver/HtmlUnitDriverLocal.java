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
package org.specrunner.webdriver;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;

/**
 * Implementation for HtmlUnitDriver which enable recovering WebClient instance.
 * 
 * @author Thiago Santos
 * 
 */
public class HtmlUnitDriverLocal extends HtmlUnitDriver implements IHtmlUnitDriver {

    /**
     * Default constructor.
     */
    public HtmlUnitDriverLocal() {
    }

    /**
     * Creates the client with JS enabled or not.
     * 
     * @param enableJavascript
     *            true, to enable java script, false, otherwise.
     */
    public HtmlUnitDriverLocal(boolean enableJavascript) {
        super(enableJavascript);
    }

    /**
     * Creates a client with a given version.
     * 
     * @param version
     *            The browser version.
     */
    public HtmlUnitDriverLocal(BrowserVersion version) {
        super(version);
    }

    /**
     * Creates a driver with preset capabilities.
     * 
     * @param capabilities
     *            The capabilities.
     */
    public HtmlUnitDriverLocal(Capabilities capabilities) {
        super(capabilities);
    }

    @Override
    public WebClient getWebClient() {
        return super.getWebClient();
    }

    /**
     * Adds a header to the client.
     * 
     * @param name
     *            The header name.
     * @param value
     *            The header value.
     */
    public void setHeader(String name, String value) {
        WebClient wc = getWebClient();
        wc.addRequestHeader(name, value);
    }

}