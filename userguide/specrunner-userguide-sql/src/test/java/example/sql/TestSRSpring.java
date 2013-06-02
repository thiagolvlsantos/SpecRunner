package example.sql;

import java.util.Arrays;

import org.junit.runner.RunWith;
import org.specrunner.junit.SRRunnerSpring;
import org.springframework.test.context.TestExecutionListeners;

@RunWith(SRRunnerSpring.class)
@TestExecutionListeners(inheritListeners = false, listeners = { PrintListener.class })
public class TestSRSpring {

    public Iterable<Qualquer> lista() {
        return Arrays.asList(new Qualquer(1, "Eu"), new Qualquer(2, "Tu"));
    }
}