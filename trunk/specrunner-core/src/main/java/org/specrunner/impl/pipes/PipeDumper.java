package org.specrunner.impl.pipes;

import org.specrunner.SpecRunnerException;
import org.specrunner.SpecRunnerServices;
import org.specrunner.dumper.ISourceDumper;
import org.specrunner.dumper.ISourceDumperFactory;
import org.specrunner.dumper.SourceDumperException;
import org.specrunner.pipeline.AbortException;
import org.specrunner.pipeline.IChannel;
import org.specrunner.pipeline.IPipe;
import org.specrunner.pipeline.InvalidTypeException;
import org.specrunner.pipeline.NotFoundException;
import org.specrunner.pipeline.PipelineException;

public class PipeDumper implements IPipe {

    /**
     * Source.
     */
    public static final String DUMPER = "dumper";

    @Override
    public boolean check(IChannel channel) throws AbortException {
        return true;
    }

    @Override
    public IChannel process(IChannel channel) throws PipelineException {
        try {
            bind(channel, createDumper());
        } catch (SpecRunnerException e) {
            throw new PipelineException(e);
        }
        return channel;
    }

    /**
     * Creates an dumper instance.
     * 
     * @return A dumper.
     * @throws SourceDumperException
     *             On creation error.
     */
    protected ISourceDumper createDumper() throws SourceDumperException {
        return SpecRunnerServices.get(ISourceDumperFactory.class).newDumper();
    }

    public static void bind(IChannel channel, ISourceDumper dumper) throws NotFoundException, InvalidTypeException {
        channel.add(DUMPER, dumper);
    }

    public static ISourceDumper recover(IChannel channel) throws NotFoundException, InvalidTypeException {
        return channel.get(DUMPER, ISourceDumper.class);
    }
}
