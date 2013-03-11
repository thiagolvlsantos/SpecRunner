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
package org.specrunner.sql.meta.impl;

import java.io.IOException;
import java.io.InputStream;

import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Nodes;
import nu.xom.ParsingException;
import nu.xom.ValidityException;

import org.specrunner.sql.meta.Column;
import org.specrunner.sql.meta.IConverter;
import org.specrunner.sql.meta.ISchemaLoader;
import org.specrunner.sql.meta.Schema;
import org.specrunner.sql.meta.Table;

public class SchemaLoaderXOM implements ISchemaLoader {
    private Builder b = new Builder();

    @Override
    public Schema load(Object source) {
        Schema s = null;
        InputStream in = null;
        try {
            in = getClass().getResourceAsStream(String.valueOf(source));
            if (in == null) {
                throw new RuntimeException("Resource '" + source + "' not found.");
            }
            Document d = b.build(in);
            Element nSchema = d.getRootElement();
            s = new Schema().setName(nSchema.getAttributeValue("name")).setAlias(nSchema.getAttributeValue("alias"));
            Nodes nTables = nSchema.query("child::table");
            for (int i = 0; i < nTables.size(); i++) {
                Element nTable = (Element) nTables.get(i);
                Table t = new Table().setName(nTable.getAttributeValue("name")).setAlias(nTable.getAttributeValue("alias"));
                s.add(t);
                Nodes nColumns = nTable.query("child::column");
                for (int j = 0; j < nColumns.size(); j++) {
                    Element nColumn = (Element) nColumns.get(j);
                    Column c = new Column().setName(nColumn.getAttributeValue("name")).setAlias(nColumn.getAttributeValue("alias"));
                    t.add(c);
                    String key = nColumn.getAttributeValue("key");
                    c.setKey(key != null && Boolean.parseBoolean(key));
                    String converter = nColumn.getAttributeValue("converter");
                    c.setConverter(converter != null ? (IConverter) Class.forName(converter).newInstance() : null);
                    String defaultValue = nColumn.getAttributeValue("default");
                    c.setDefaultValue(defaultValue);
                }
            }
        } catch (ValidityException e) {
            throw new RuntimeException(e);
        } catch (ParsingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return s;
    }
}