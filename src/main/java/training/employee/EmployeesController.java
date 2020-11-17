package training.employee;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.List;

@Component
@RequestScope
public class EmployeesController {

    private EmployeeService employeeService;

    private List<EmployeeDto> employees;

    public EmployeesController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostConstruct
    public void init() {
        employees = employeeService.listEmployees();
    }

    public List<EmployeeDto> getEmployees() {
        return employees;
    }

    public String deleteEmployee(long id) {
        DeleteEmployeeCommand deleteEmployeeCommand = new DeleteEmployeeCommand();
        deleteEmployeeCommand.setId(id);
        employeeService.deleteEmployee(deleteEmployeeCommand);

        FacesContext
                .getCurrentInstance()
                .addMessage(null, new FacesMessage("Employee has been deleted with id: " + id));
// Redirect after post miatt
        FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getFlash()
                .setKeepMessages(true);

        return "employees.xhtml?faces-redirect=true";
    }
}
