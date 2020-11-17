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

    private final MessageContext messageContext;

    private long id;

    private ModifyEmployeeCommand modifyEmployeeCommand = new ModifyEmployeeCommand();

    public UpdateEmployeeController(EmployeeService employeeService, MessageContext messageContext) {
        this.employeeService = employeeService;
        this.messageContext = messageContext;
    }

    public void findEmployeeById() {
        EmployeeDto employee = employeeService.findEmployeeById(id);
        modifyEmployeeCommand = new ModifyEmployeeCommand();
        modifyEmployeeCommand.setId(id);
        modifyEmployeeCommand.setName(employee.getName());
    }

    public String modifyEmployee() {
        modifyEmployeeCommand.setName(modifyEmployeeCommand.getName().trim());
        employeeService.modifyEmployee(modifyEmployeeCommand);
        messageContext.addMessage("Employee has been modified: " + modifyEmployeeCommand.getName());
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
