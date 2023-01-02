package spring5;

import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Data
@Component
public class SpringBean {
    private String name;

    public void method() throws Exception {
        System.out.println("this is tow method !");
        Thread.sleep(5000);
    }
}
