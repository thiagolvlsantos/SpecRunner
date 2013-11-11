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
package org.specrunner.util;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.List;

import org.specrunner.SpecRunnerServices;
import org.specrunner.concurrency.IConcurrentMapping;
import org.specrunner.source.resource.ResourceException;
import org.specrunner.util.cache.ICache;
import org.specrunner.util.cache.ICacheFactory;

/**
 * IO utilities.
 * 
 * @author Thiago Santos
 * 
 */
public final class UtilIO {

    /**
     * Cache of resources. Avoid unnecessary file/network/jar accesses.
     */
    private static ICache<URL, byte[]> cache = SpecRunnerServices.get(ICacheFactory.class).newCache(UtilIO.class.getName());

    /**
     * Reading buffer size.
     */
    public static final int BUFFER_SIZE = 1024;
    /**
     * Temp reading.
     */
    private static final int READ_SIZE = 12;

    /**
     * Hidden constructor.
     */
    private UtilIO() {
    }

    /**
     * Write all contents to a output.
     * 
     * @param files
     *            The input list.
     * @param out
     *            The output.
     * @throws ResourceException
     *             On writing errors.
     */
    public static void writeAllTo(List<URL> files, OutputStream out) throws ResourceException {
        InputStream[] ins = null;
        int i = 0;
        try {
            ins = getInputStreams(files);
            for (InputStream in : ins) {
                writeTo(in, out);
                in.close();
                ins[i] = null;
                i++;
            }
        } catch (IOException e) {
            if (UtilLog.LOG.isDebugEnabled()) {
                UtilLog.LOG.debug(e.getMessage(), e);
            }
        } finally {
            if (ins != null) {
                for (int j = 0; j < i; j++) {
                    try {
                        if (UtilLog.LOG.isDebugEnabled()) {
                            UtilLog.LOG.debug("Closing " + ins[j]);
                        }
                        if (ins[j] != null) {
                            ins[j].close();
                        }
                    } catch (IOException e) {
                        if (UtilLog.LOG.isDebugEnabled()) {
                            UtilLog.LOG.debug(e.getMessage(), e);
                        }
                    }
                }
            }
        }
    }

    /**
     * Get all input streams for the given URL list.
     * 
     * @param files
     *            The files.
     * @return The input stream list.
     * @throws ResourceException
     *             On loading errors.
     */
    public static InputStream[] getInputStreams(List<URL> files) throws ResourceException {
        InputStream[] result = new InputStream[files.size()];
        int i = 0;
        try {
            for (URL url : files) {
                result[i++] = getStream(url);
            }
        } catch (IOException e) {
            for (int j = 0; j < i; j++) {
                try {
                    if (UtilLog.LOG.isDebugEnabled()) {
                        UtilLog.LOG.debug("Closing " + files.get(j));
                    }
                    result[j].close();
                } catch (IOException e1) {
                    if (UtilLog.LOG.isDebugEnabled()) {
                        UtilLog.LOG.debug(e1.getMessage(), e1);
                    }
                }
            }
            if (UtilLog.LOG.isDebugEnabled()) {
                UtilLog.LOG.debug(e.getMessage(), e);
            }
            throw new ResourceException(e);
        }
        return result;
    }

    /**
     * Get stream for a given URL.
     * 
     * @param url
     *            The url.
     * @return The stream.
     * @throws IOException
     *             On load errors.
     */
    public static InputStream getStream(URL url) throws IOException {
        synchronized (cache) {
            byte[] data = cache.get(url);
            if (data != null) {
                if (UtilLog.LOG.isDebugEnabled()) {
                    UtilLog.LOG.debug("Stream reused for: " + url);
                }
                return new ByteArrayInputStream(data);
            }
            InputStream in = null;
            ByteArrayOutputStream out = null;
            try {
                in = url.openStream();
                out = new ByteArrayOutputStream(in.available());
                writeTo(in, out);
                data = out.toByteArray();
                cache.put(url, data);
                if (UtilLog.LOG.isDebugEnabled()) {
                    UtilLog.LOG.debug("Stream with '" + data.length + "' bytes cached for: " + url);
                }
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        if (UtilLog.LOG.isDebugEnabled()) {
                            UtilLog.LOG.debug("Closing " + in, e);
                        }
                        throw e;
                    }
                }
                if (out != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        if (UtilLog.LOG.isDebugEnabled()) {
                            UtilLog.LOG.debug("Closing " + in, e);
                        }
                        throw e;
                    }
                }
            }
            return new ByteArrayInputStream(data);
        }
    }

    /**
     * Write a input stream to a output.
     * 
     * @param in
     *            The input.
     * @param out
     *            The output.
     * @throws IOException
     *             On writing errors.
     */
    public static void writeTo(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[BUFFER_SIZE];
        int size = 0;
        while ((size = in.read(buffer)) > 0) {
            out.write(buffer, 0, size);
        }
        out.flush();
    }

    /**
     * Write the url input to the file output.
     * 
     * @param url
     *            The input.
     * @param file
     *            The output.
     * @throws IOException
     *             On writing errors.
     */
    public static void writeToClose(URL url, File file) throws IOException {
        InputStream in = null;
        FileOutputStream fout = null;
        BufferedOutputStream bout = null;
        try {
            in = getStream(url);
            fout = new FileOutputStream(file);
            bout = new BufferedOutputStream(fout);
            writeTo(in, bout);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e) {
                    if (UtilLog.LOG.isDebugEnabled()) {
                        UtilLog.LOG.debug("Closing " + in, e);
                    }
                }
            }
            if (fout != null) {
                try {
                    fout.close();
                } catch (Exception e) {
                    if (UtilLog.LOG.isDebugEnabled()) {
                        UtilLog.LOG.debug("Closing " + fout, e);
                    }
                }
            }
            if (bout != null) {
                try {
                    bout.close();
                } catch (Exception e) {
                    if (UtilLog.LOG.isDebugEnabled()) {
                        UtilLog.LOG.debug("Closing " + bout, e);
                    }
                }
            }
        }
    }

    /**
     * Request for key interaction.
     * 
     * @throws IOException
     *             On errors.
     */
    public static void pressKey() throws IOException {
        IConcurrentMapping cm = SpecRunnerServices.get(IConcurrentMapping.class);
        if (UtilLog.LOG.isInfoEnabled()) {
            UtilLog.LOG.info("(" + cm.getThread() + ") read keybord (press 'Enter' to go on)...");
        }
        int count = System.in.read(new byte[READ_SIZE]);
        if (UtilLog.LOG.isInfoEnabled()) {
            UtilLog.LOG.info("(" + cm.getThread() + ") done..." + count);
        }
    }
}
