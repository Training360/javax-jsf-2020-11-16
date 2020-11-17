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

    private EmployeesQuery employeesQuery = new EmployeesQuery();

    public EmployeesController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void initEmployees() {
        employees = employeeService.listEmployees(employeesQuery);
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

    public EmployeesQuery getEmployeesQuery() {
        return employeesQuery;
    }

    public void setEmployeesQuery(EmployeesQuery employeesQuery) {
        this.employeesQuery = employeesQuery;
    }
}
