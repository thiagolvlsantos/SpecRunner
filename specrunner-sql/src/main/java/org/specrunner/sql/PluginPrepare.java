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
package org.specrunner.sql;

import org.specrunner.expressions.EMode;
import org.specrunner.plugins.ActionType;
import org.specrunner.plugins.type.Command;

/**
 * Prepare a database.
 * 
 * @author Thiago Santos
 * 
 */
public class PluginPrepare extends AbstractPluginDatabase {

    /**
     * Default constructor.
     */
    public PluginPrepare() {
        super(EMode.INPUT);
    }

    @Override
    public ActionType getActionType() {
        return Command.INSTANCE;
    }
}
