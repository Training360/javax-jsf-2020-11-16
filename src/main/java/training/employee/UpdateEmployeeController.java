package training.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Component
@RequestScope
public class UpdateEmployeeController {

    private final EmployeeService employeeService;

    private long id;

    private ModifyEmployeeCommand modifyEmployeeCommand = new ModifyEmployeeCommand();

    public UpdateEmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void findEmployeeById() {
        EmployeeDto employee = employeeService.findEmployeeById(id);
        modifyEmployeeCommand = new ModifyEmployeeCommand();
        modifyEmployeeCommand.setId(id);
        modifyEmployeeCommand.setName(employee.getName());
    }

    public String modifyEmployee() {
        employeeService.modifyEmployee(modifyEmployeeCommand);

        FacesContext
                .getCurrentInstance()
                .addMessage(null, new FacesMessage("Employee has been modified: " + modifyEmployeeCommand.getName()));
// Redirect after post miatt
        FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getFlash()
                .setKeepMessages(true);


        return "employees.xhtml?faces-redirect=true";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ModifyEmployeeCommand getModifyEmployeeCommand() {
        return modifyEmployeeCommand;
    }

    public void setModifyEmployeeCommand(ModifyEmployeeCommand modifyEmployeeCommand) {
        this.modifyEmployeeCommand = modifyEmployeeCommand;
    }
}
