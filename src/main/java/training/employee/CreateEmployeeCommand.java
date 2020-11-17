package training.employee;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class CreateEmployeeCommand {

    @NotBlank(message = "Name can not be empty")
    @Size(max = 20)
    private String name;

    private String favouriteLanguage;

    private Phone phone = new Phone("20", "1234354");
}
