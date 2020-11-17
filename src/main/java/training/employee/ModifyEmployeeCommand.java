package training.employee;

import lombok.Data;

@Data
public class ModifyEmployeeCommand {

    private Long id;

    private String name;

    private String favouriteLanguage;
}
