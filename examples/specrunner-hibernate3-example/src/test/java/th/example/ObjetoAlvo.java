package th.example;

import org.specrunner.converters.Converter;
import org.specrunner.junit.ExpectedMessage;

public class ObjetoAlvo {

    public void abrir(@Converter(name = "object", resultType = Person.class) Person p) {
        System.out.println("PESSOA:" + p);
    }

    @ExpectedMessage(message = "Converter named 'testing' not found.")
    public void erro(@Converter(name = "testing", resultType = Person.class) Person p) {
        System.out.println("PESSOA:" + p);
    }
}
