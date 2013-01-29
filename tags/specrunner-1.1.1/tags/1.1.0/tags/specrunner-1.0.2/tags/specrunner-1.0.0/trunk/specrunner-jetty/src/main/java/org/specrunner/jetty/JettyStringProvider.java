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
package org.specrunner.jetty;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.specrunner.context.ContextException;
import org.specrunner.context.IContext;
import org.specrunner.util.string.IStringProvider;

public class JettyStringProvider implements IStringProvider {

    @Override
    public String newString(IContext context) throws ContextException {
        Server s = (Server) context.getByName(PluginStartJetty.JETTY_NAME);
        if (s == null) {
            throw new ContextException("Jetty server named '" + PluginStartJetty.JETTY_NAME + "' does not exists.");
        }
        final int defaultPort = 8080;
        int port = defaultPort;
        for (Connector c : s.getConnectors()) {
            if (c instanceof SelectChannelConnector) {
                port = c.getPort();
                break;
            }
        }
        return "http://localhost:" + port;
    }

}
