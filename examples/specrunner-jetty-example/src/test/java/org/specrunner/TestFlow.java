package org.specrunner;

import org.joda.time.LocalDateTime;
import org.junit.Before;
import org.junit.Test;
import org.specrunner.junit.SpecRunnerJUnit;

public class TestFlow {

    @Before
    public void before() {
        SRServices.getExpressionFactory().bindClass("dt", LocalDateTime.class);
    }

    @Test
    public void runFlow() throws Exception {
        SpecRunnerJUnit.defaultRun("src/test/resources/income/bdd-flow.html");
    }
}