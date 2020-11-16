package training.employee;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

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
        // Redirect after post tervezési minta - ide átirányítás kell
        return "employees.xhtml?faces-redirect=true";
    }
}
