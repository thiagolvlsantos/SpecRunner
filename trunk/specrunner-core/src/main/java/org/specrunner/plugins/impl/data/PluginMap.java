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
package org.specrunner.plugins.impl.data;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import nu.xom.Element;
import nu.xom.Node;

import org.specrunner.context.IContext;
import org.specrunner.plugins.ENext;
import org.specrunner.plugins.IAction;
import org.specrunner.plugins.PluginException;
import org.specrunner.plugins.impl.AbstractPluginTable;
import org.specrunner.result.IResultSet;
import org.specrunner.result.Status;
import org.specrunner.util.UtilEvaluator;
import org.specrunner.util.impl.CellAdapter;
import org.specrunner.util.impl.RowAdapter;
import org.specrunner.util.impl.TableAdapter;

/**
 * Creates a memory map.
 * 
 * @author Thiago Santos
 * 
 */
public class PluginMap extends AbstractPluginTable implements IAction {

    /**
     * true, to resolve content before mapping, false, otherwise.
     */
    private Boolean after = false;

    /**
     * The order of mapping, before or after perform content.
     * 
     * @return false, to perform after, true, otherwise. Default is 'false'.
     */
    public Boolean getAfter() {
        return after;
    }

    /**
     * Change perform order.
     * 
     * @param after
     *            true, to perform content previously, false, otherwise.
     */
    public void setAfter(Boolean after) {
        this.after = after;
    }

    @Override
    public ENext doStart(IContext context, IResultSet result, TableAdapter tableAdapter) throws PluginException {
        if (!after) {
            process(context, result, tableAdapter);
            return ENext.SKIP;
        } else {
            return ENext.DEEP;
        }
    }

    @Override
    public void doEnd(IContext context, IResultSet result, TableAdapter tableAdapter) throws PluginException {
        if (after) {
            process(context, result, tableAdapter);
        }
    }

    /**
     * Processo the content creating the mappings.
     * 
     * @param context
     *            The context.
     * @param result
     *            The result.
     * @param tableAdapter
     *            The adapter.
     * @throws PluginException
     *             On execution errors.
     */
    private void process(IContext context, IResultSet result, TableAdapter tableAdapter) throws PluginException {
        final List<Map<String, Node>> data = new LinkedList<Map<String, Node>>();
        RowAdapter ths = tableAdapter.getRow(0);
        List<RowAdapter> trs = tableAdapter.getRows();
        for (int i = 0; i < tableAdapter.getRowCount(); i++) {
            if (i == 0) { // ignore headers.
                continue;
            }
            RowAdapter tr = trs.get(i);
            if (tr.getCellsCount() != ths.getCellsCount()) {
                throw new PluginException("Number of headers '" + ths.getCellsCount() + "' is diferent from line columns '" + tr.getCellsCount() + "'.");
            }
            List<CellAdapter> tds = tr.getCells();
            Map<String, Node> line = new HashMap<String, Node>();
            data.add(line);
            for (int j = 0; j < tds.size(); j++) {
                Element e = tds.get(j).getElement();
                line.put(UtilEvaluator.START_DATA + j + UtilEvaluator.END, e);
                line.put(UtilEvaluator.START_DATA + ths.getCell(j).getElement().getValue().trim() + UtilEvaluator.END, e);
            }
        }
        IDataMap<Node> map = new IDataMap<Node>() {
            @Override
            public int getTotal() {
                return data.size();
            }

            @Override
            public Iterator<Map<String, Node>> iterator() {
                return data.iterator();
            }
        };
        saveLocal(context, getName(), map);
        for (int i = 0; i < ths.getCellsCount(); i++) {
            result.addResult(Status.SUCCESS, context.newBlock(ths.getCell(i).getElement(), this));
        }
    }
}