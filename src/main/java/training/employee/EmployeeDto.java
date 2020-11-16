package training.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeDto {

    private Long id;

    private String name;

    public EmployeeDto(Employee employee) {
        id = employee.getId();
        name = employee.getName();
    }
}
