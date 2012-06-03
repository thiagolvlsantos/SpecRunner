package org.specrunner.plugins.type;

import org.specrunner.plugins.ActionType;

/**
 * Command: is not error, has importance 1.
 */
public class Command extends ActionType {

    /**
     * Singleton.
     */
    public static final Command INSTANCE = new Command();

    /**
     * Default constructor.
     */
    protected Command() {
        super("action", 1);
    }
}