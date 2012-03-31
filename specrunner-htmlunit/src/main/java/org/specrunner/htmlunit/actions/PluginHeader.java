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
package org.specrunner.htmlunit.actions;

import org.specrunner.context.IContext;
import org.specrunner.htmlunit.AbstractPluginBrowserAware;
import org.specrunner.plugins.PluginException;
import org.specrunner.result.IResultSet;
import org.specrunner.result.Status;
import org.specrunner.util.UtilLog;

import com.gargoylesoftware.htmlunit.WebClient;

public class PluginHeader extends AbstractPluginBrowserAware implements IAction {

    private String header;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    @Override
    protected void doEnd(IContext context, IResultSet result, WebClient client) throws PluginException {
        UtilLog.LOG.info("    On: " + getClass().getSimpleName() + " with " + client);
        Object tmp = getValue(getValue() != null ? getValue() : context.getNode().getValue(), true, context);
        if (header == null || tmp == null) {
            throw new PluginException("To set request header both, header and value, must be provided.");
        }
        String value = String.valueOf(tmp);
        client.addRequestHeader(getHeader(), value);
        result.addResult(Status.SUCCESS, context.peek());
    }
}
