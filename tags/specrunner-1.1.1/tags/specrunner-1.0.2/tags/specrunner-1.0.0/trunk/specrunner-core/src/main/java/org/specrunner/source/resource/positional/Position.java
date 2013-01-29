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
package org.specrunner.source.resource.positional;

/**
 * Stand for a position in the document where something can be, i.e., added.
 * 
 * @author Thiago Santos
 * 
 */
public final class Position {

    public static final String HEAD = "//head";
    public static final String BODY = "//body";
    /**
     * On header start.
     */
    public static final Position HEAD_START = new Position(HEAD, EPlace.START);
    /**
     * On header end.
     */
    public static final Position HEAD_END = new Position(HEAD, EPlace.END);
    /**
     * On body start.
     */
    public static final Position BODY_START = new Position(BODY, EPlace.START);
    /**
     * On body end.
     */
    public static final Position BODY_END = new Position(BODY, EPlace.END);

    private String xpath;
    private EPlace place;

    private Position(String xpath, EPlace place) {
        this.xpath = xpath;
        this.place = place;
    }

    public String getXpath() {
        return xpath;
    }

    public EPlace getPlace() {
        return place;
    }

    /**
     * Creates a new position based on XPath information.
     * 
     * @param xpath
     *            The XPath target.
     * @param place
     *            The place relative to the XPath.
     * @return A position which reflects the XPath and position.
     */
    public static Position newPosition(String xpath, EPlace place) {
        return new Position(xpath, place);
    }

    @Override
    public String toString() {
        return "(" + xpath + " to " + place + ")";
    }
}