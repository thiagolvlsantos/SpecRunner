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
package org.specrunner.sql;

import java.sql.Connection;

import org.specrunner.context.IContext;
import org.specrunner.plugins.PluginException;
import org.specrunner.result.IResultSet;
import org.specrunner.sql.meta.Schema;
import org.specrunner.util.mapping.IResetable;
import org.specrunner.util.xom.TableAdapter;

/**
 * Abstraction for SQL executor.
 * 
 * @author Thiago Santos.
 * 
 */
public interface IDatabase extends IResetable {

    /**
     * Feature for null/empty handler.
     */
    String FEATURE_NULL_EMPTY_HANDLER = IDatabase.class.getName() + ".nullEmptyHandler";

    /**
     * Feature for sequence provider instance.
     */
    String FEATURE_SEQUENCE_PROVIDER = IDatabase.class.getName() + ".sequenceProvider";

    /**
     * Feature for database sql dumper.
     */
    String FEATURE_SQL_DUMPER = IDatabase.class.getName() + ".sqlDumper";

    /**
     * Feature for database column reader.
     */
    String FEATURE_COLUMN_READER = IDatabase.class.getName() + ".columnReader";

    /**
     * Set the null/empty handler implementation.
     * 
     * @param nullEmptyHandler
     *            A null/empty handler.
     */
    void setNullEmptyHandler(INullEmptyHandler nullEmptyHandler);

    /**
     * Set the sequence provider.
     * 
     * @param sequenceProvider
     *            A provider.
     */
    void setSequenceProvider(ISequenceProvider sequenceProvider);

    /**
     * Set the database SQL dumper.
     * 
     * @param sqlDumper
     *            A dumper.
     */
    void setSqlDumper(ISqlDumper sqlDumper);

    /**
     * Set a column reader.
     * 
     * @param columnReader
     *            A reader.
     */
    void setColumnReader(IColumnReader columnReader);

    /**
     * Perform some actions in a database.
     * 
     * @param context
     *            The test context.
     * @param result
     *            The result set.
     * @param table
     *            The specification table.
     * @param con
     *            The connection.
     * @param schema
     *            The database meta model.
     * @param mode
     *            The database mode (in - actions|out - asserts)
     * @throws PluginException
     *             On perform errors.
     */
    void perform(IContext context, IResultSet result, TableAdapter table, Connection con, Schema schema, EMode mode) throws PluginException;

    /**
     * Release database resources.
     * 
     * @throws PluginException
     *             On release errors.
     */
    void release() throws PluginException;
}
