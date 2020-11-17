package training.employee;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Locale;
import java.util.Random;

@Component
@RequestScope
public class LanguageController {
    private Random random = new Random();

    public Locale getLocale() {
        return random.nextBoolean() ? new Locale("hu", "HU") : new Locale("en", "US");
    }
}
