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
package org.specrunner.source.resource.element.core;

import org.specrunner.source.ISource;
import org.specrunner.source.resource.EType;

import nu.xom.Element;

/**
 * A stylesheet resource.
 * 
 * @author Thiago Santos
 * 
 */
public class StylesheetResource extends AbstractResourceElementAtt {

    /**
     * Creates a stylesheet resource.
     * 
     * @param parent
     *            The source parent.
     * @param path
     *            The resource path.
     * @param classpath
     *            The classpath flag.
     * @param type
     *            The resource nature.
     * @param element
     *            The referred element.
     */
    public StylesheetResource(ISource parent, String path, boolean classpath, EType type, Element element) {
        super(parent, path, classpath, type, element, "href", "STYLESHEET");
    }
}
