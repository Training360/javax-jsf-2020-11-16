package training.employee;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.List;

@Component
@RequestScope
public class CreateEmployeeController {

    private final EmployeeService employeeService;

    private CreateEmployeeCommand createEmployeeCommand = new CreateEmployeeCommand();

    private List<String> availableLanguages;

    public CreateEmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public CreateEmployeeCommand getCreateEmployeeCommand() {
        return createEmployeeCommand;
    }

    @PostConstruct
    public void loadLanguages() {
        availableLanguages = employeeService.listAvailableLanguages();
    }

    public String createEmployee() {

        if (employeeService.isEmployeeWithName(createEmployeeCommand.getName())) {
            FacesContext
                    .getCurrentInstance()
                    .addMessage(null, new FacesMessage("Employee already exists"));
            return null;
        }

        employeeService.createEmployee(createEmployeeCommand);

        FacesContext
                .getCurrentInstance()
                .addMessage(null, new FacesMessage("Employee has created"));
// Redirect after post miatt
        FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getFlash()
                .setKeepMessages(true);

        // Redirect after post tervezési minta - ide átirányítás kell
        return "employees.xhtml?faces-redirect=true";
    }

    public List<String> getAvailableLanguages() {
        return availableLanguages;
    }
}
