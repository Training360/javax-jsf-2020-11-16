package training.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Phone {

    // 30-1234567

    // 30
    private String prefix;

    // 1234567
    private String number;
}
