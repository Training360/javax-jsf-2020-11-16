package training.employee;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.time.LocalDateTime;

@Component
@RequestScope
public class HelloController {

    private String message = "Type your name!";

    private String name = "Jack Doe";

    public void sayHello() {
        message = "Hello " + name + " " + LocalDateTime.now();
        name = "";
    }

    public String getMessage() {
        return message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
