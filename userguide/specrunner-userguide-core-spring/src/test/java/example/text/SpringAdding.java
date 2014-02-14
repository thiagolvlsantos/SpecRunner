package example.text;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.specrunner.junit.SRRunnerSpring;
import org.specrunner.plugins.core.language.Sentence;
import org.specrunner.plugins.core.language.Synonyms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import example.text.suv.Calc;

@RunWith(SRRunnerSpring.class)
@ContextConfiguration(locations = { "/applicationContext-Calc.xml" })
public class SpringAdding {

    @Autowired
    private Calc calc;

    @Sentence("turn on")
    public void reset() {
        calc.clear();
    }

    @Sentence("entered (-?\\d+)")
    public void enter(int n) {
        calc.enter(n);
    }

    public void whenIPressAdd() {
        calc.add();
    }

    @Sentence("anything")
    @Synonyms({ "result should be (-?\\d+)" })
    public boolean result(Integer v) {
        Assert.assertEquals(v, calc.result());
        return true;
    }

    @Sentence("end")
    public void end() {
    }
}