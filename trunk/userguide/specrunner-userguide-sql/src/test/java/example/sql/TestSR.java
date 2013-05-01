package example.sql;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.specrunner.SpecRunnerServices;
import org.specrunner.expressions.IExpressionFactory;
import org.specrunner.junit.SRRunner;
import org.specrunner.plugins.IPluginFactory;
import org.specrunner.plugins.impl.factories.PluginFactoryCSS;
import org.specrunner.plugins.impl.factories.PluginFactoryElement;

@RunWith(SRRunner.class)
public class TestSR {

    @Before
    public void antes() throws Exception {
        System.out.println("antes");
        SpecRunnerServices.get(IExpressionFactory.class).bindClass("dt", Date.class);
        SpecRunnerServices.get(IPluginFactory.class).bind(PluginFactoryCSS.KIND, "meu", new MeuPlugin());
        SpecRunnerServices.get(IPluginFactory.class).bind(PluginFactoryElement.KIND, "outro", new OutroPlugin());
    }

    public String call(Date date) {
        return "funciona " + date;
    }

    public String greeting(String nome) {
        return "Oi " + nome + "!";
    }

    public boolean bool(int index) {
        return index % 2 == 0;
    }

    public List<?> chamar(Date dt) {
        return Arrays.asList("a", "b", "c");
    }

    @After
    public void depois() {
        System.out.println("depois");
    }
}
