/*
    SpecRunner - Acceptance Test Driven Development Tool
    Copyright (C) 2011-2015  Thiago Santos

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
package org.specrunner.source;

import nu.xom.Document;

/**
 * A document loader interface.
 * 
 * @author Thiago Santos
 * 
 */
public interface IDocumentLoader {

    /**
     * Load a document. The object which implements this interface must have all
     * information to load the document.
     * 
     * @return The document loaded.
     * @throws SourceException
     *             On loading problems.
     */
    Document load() throws SourceException;
}
