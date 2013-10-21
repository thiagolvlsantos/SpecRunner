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
package org.specrunner.sql.meta;

import org.specrunner.SpecRunnerServices;
import org.specrunner.comparators.IComparator;
import org.specrunner.converters.IConverter;

/**
 * Column meta model.
 * 
 * @author Thiago Santos.
 * 
 */
public class Column implements IReplicable<Column> {

    /**
     * Column table.
     */
    private Table table;
    /**
     * Column alias.
     */
    private String alias;
    /**
     * Column name.
     */
    private String name;
    /**
     * Column key indicator.
     */
    private boolean key;
    /**
     * Column default converter.
     */
    private static final IConverter CONVERTER_DEFAULT = SpecRunnerServices.getConverterManager().getDefault();
    /**
     * Column converter.
     */
    private IConverter converter = CONVERTER_DEFAULT;
    /**
     * Column default comparator.
     */
    private static final IComparator COMPARATOR_DEFAULT = SpecRunnerServices.getComparatorManager().getDefault();
    /**
     * Column comparator.
     */
    private IComparator comparator = COMPARATOR_DEFAULT;
    /**
     * Column default value.
     */
    private Object defaultValue;

    /**
     * Column foreign indicator.
     */
    private boolean foreign;
    /**
     * Column reference indicator.
     */
    private boolean reference;
    /**
     * Virtual column indicator.
     */
    private boolean virtual;

    /**
     * Get the column table.
     * 
     * @return The table.
     */
    public Table getTable() {
        return table;
    }

    /**
     * Set the table.
     * 
     * @param table
     *            The table.
     * @return The column itself.
     */
    public Column setTable(Table table) {
        this.table = table;
        return this;
    }

    /**
     * Get the table alias.
     * 
     * @return The alias.
     */
    public String getAlias() {
        return alias;
    }

    /**
     * Set the table alias.
     * 
     * @param alias
     *            The alias.
     * @return The table itself.
     */
    public Column setAlias(String alias) {
        this.alias = alias;
        return this;
    }

    /**
     * Get the table name.
     * 
     * @return The table.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the table name.
     * 
     * @param name
     *            The name.
     * @return The column itself.
     */
    public Column setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the key information.
     * 
     * @return true, if the column is a key, false, otherwise.
     */
    public boolean isKey() {
        return key;
    }

    /**
     * Set the key flag.
     * 
     * @param key
     *            The value.
     * @return The column itself.
     */
    public Column setKey(boolean key) {
        this.key = key;
        return this;
    }

    /**
     * Get the column converter.
     * 
     * @return The converter.
     */
    public IConverter getConverter() {
        return converter;
    }

    /**
     * Set the column converter.
     * 
     * @param converter
     *            The converter.
     * @return The column itself.
     */
    public Column setConverter(IConverter converter) {
        if (converter != null) {
            this.converter = converter;
        }
        return this;
    }

    /**
     * Get the column comparator.
     * 
     * @return The comparator.
     */
    public IComparator getComparator() {
        return comparator;
    }

    /**
     * Set the column comparator.
     * 
     * @param comparator
     *            The comparator.
     * @return The column itself.
     */
    public Column setComparator(IComparator comparator) {
        if (comparator != null) {
            this.comparator = comparator;
        }
        return this;
    }

    /**
     * Get the column default value. Default values are expected to be non null.
     * 
     * @return The default value.
     */
    public Object getDefaultValue() {
        return defaultValue;
    }

    /**
     * Set the column default value.
     * 
     * @param defaultValue
     *            The value.
     * @return The column itself.
     */
    public Column setDefaultValue(Object defaultValue) {
        this.defaultValue = defaultValue;
        return this;
    }

    /**
     * Check if a given column is a foreign key.
     * 
     * @return true, if foreign, false, otherwise.
     */
    public boolean isForeign() {
        return foreign;
    }

    /**
     * Set foreign key mark.
     * 
     * @param foreign
     *            The flag.
     * @return The column itself.
     */
    public Column setForeign(boolean foreign) {
        this.foreign = foreign;
        return this;
    }

    /**
     * Check if a given column values can be used as a reference for foreign
     * references.
     * 
     * @return true, if reference column, false, otherwise.
     */
    public boolean isReference() {
        return reference;
    }

    /**
     * The reference flag.
     * 
     * @param reference
     *            The flag.
     * @return The column itself.
     */
    public Column setReference(boolean reference) {
        this.reference = reference;
        return this;
    }

    /**
     * Check if a given column must be resolved using virtual keys produced on
     * demand by <code>getGenerateKeys()</code>. When this flag is on, in the
     * specification there must be a previous table with naming matching this
     * column name and the value must match that column reference field.
     * 
     * @return The virtual flag.
     */
    public boolean isVirtual() {
        return virtual;
    }

    /**
     * Set virtual flag.
     * 
     * @param virtual
     *            The virtual flag.
     * @return The column itself.
     */
    public Column setVirtual(boolean virtual) {
        this.virtual = virtual;
        return this;
    }

    @Override
    public Column copy() {
        return new Column().setTable(table).setAlias(alias).setName(name).setKey(key).setConverter(converter).setComparator(comparator).setDefaultValue(defaultValue).setForeign(foreign).setReference(reference).setVirtual(virtual);
    }
}