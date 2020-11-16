package training.employee;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import javax.annotation.PostConstruct;
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
}
