/*
    SpecRunner - Acceptance Test Driven Development Tool
    Copyright (C) 2011-2013  Thiago Santos

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
import java.sql.SQLException;

import javax.sql.DataSource;

import org.specrunner.context.IContext;
import org.specrunner.plugins.ActionType;
import org.specrunner.plugins.ENext;
import org.specrunner.plugins.PluginException;
import org.specrunner.plugins.impl.AbstractPluginTable;
import org.specrunner.plugins.type.Command;
import org.specrunner.result.IResultSet;
import org.specrunner.sql.database.IDatabase;
import org.specrunner.sql.input.impl.TableXOM;
import org.specrunner.sql.meta.Schema;
import org.specrunner.util.UtilLog;
import org.specrunner.util.xom.TableAdapter;

/**
 * Given a data source, a schema and a table, perform operations.
 * 
 * @author Thiago Santos
 * 
 */
public class PluginPrepare extends AbstractPluginTable {

    /**
     * The data base name.
     */
    private String database;
    /**
     * The schema name.
     */
    private String schema;

    /**
     * Gets the database name.
     * 
     * @return The name.
     */
    public String getDatabase() {
        return database;
    }

    /**
     * Set the database name.
     * 
     * @param database
     *            A new database name.
     */
    public void setDatabase(String database) {
        this.database = database;
    }

    /**
     * Gets schema name.
     * 
     * @return The schema name.
     */
    public String getSchema() {
        return schema;
    }

    /**
     * Sets the schema name.
     * 
     * @param schema
     *            A new schema name.
     */
    public void setSchema(String schema) {
        this.schema = schema;
    }

    @Override
    public ActionType getActionType() {
        return Command.INSTANCE;
    }

    @Override
    public ENext doStart(IContext context, IResultSet result, TableAdapter tableAdapter) throws PluginException {
        IDataSourceProvider datasource = PluginConnection.getProvider(context, getName());
        IDatabase database = PluginDatabase.getDatabase(context, getDatabase());
        Schema schema = PluginSchema.getSchema(context, getSchema());
        if (UtilLog.LOG.isInfoEnabled()) {
            UtilLog.LOG.info("PluginPrepare datasource:" + datasource);
            UtilLog.LOG.info("PluginPrepare   database:" + database);
            UtilLog.LOG.info("PluginPrepare     schema:" + schema);
        }
        DataSource ds = datasource.getDataSource();
        Connection connection = null;
        try {
            connection = ds.getConnection();
            if (UtilLog.LOG.isInfoEnabled()) {
                UtilLog.LOG.info("PluginPrepare connection:" + connection);
            }
            database.perform(connection, schema, new TableXOM(tableAdapter.getElement()));
        } catch (SQLException e) {
            if (UtilLog.LOG.isDebugEnabled()) {
                UtilLog.LOG.debug(e.getMessage(), e);
            }
            throw new PluginException(e);
        } finally {
            try {
                if (connection != null) {
                    connection.commit();
                }
            } catch (SQLException e) {
                if (UtilLog.LOG.isDebugEnabled()) {
                    UtilLog.LOG.debug(e.getMessage(), e);
                }
                throw new PluginException(e);
            }
        }
        return ENext.DEEP;
    }
}