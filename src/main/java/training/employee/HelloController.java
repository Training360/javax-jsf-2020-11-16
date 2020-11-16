package training.employee;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.time.LocalDateTime;

@Component
@SessionScope
public class HelloController {

    private String message = "Type your name!";

    private String name = "Jack Doe";

    public String sayHello() {
        message = "Hello " + name + " " + LocalDateTime.now();
        name = "";
        return "/hello.xhtml?faces-redirect=true";
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
