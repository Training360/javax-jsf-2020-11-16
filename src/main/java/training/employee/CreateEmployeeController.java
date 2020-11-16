package training.employee;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Component
@RequestScope
public class CreateEmployeeController {

    private final EmployeeService employeeService;

    private CreateEmployeeCommand createEmployeeCommand = new CreateEmployeeCommand();

    public CreateEmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public CreateEmployeeCommand getCreateEmployeeCommand() {
        return createEmployeeCommand;
    }

    public String createEmployee() {
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
}
