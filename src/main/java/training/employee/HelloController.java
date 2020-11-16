package training.employee;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.time.LocalDateTime;

@Component
@RequestScope
public class HelloController {

    public String getMessage() {
        return "Hello World " + LocalDateTime.now();
    }
}
