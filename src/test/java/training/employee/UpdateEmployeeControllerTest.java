package training.employee;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

// Teszt osztály
// Unit test
//  * 1 osztályt tesztelünk, 1 metódusát
// * Nincs benne, sem Spring, sem adatbázis, nincs JSF
@ExtendWith(MockitoExtension.class)
public class UpdateEmployeeControllerTest {

    @Mock
    EmployeeService employeeService;

    @Mock
    MessageContext messageContext;

    @InjectMocks
    UpdateEmployeeController updateEmployeeController;

    // Teszteset = teszt metódus
    @Test
    void testGetEmployeeById() {
        // Given
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1L);
        employeeDto.setName("John Doe");
        when(employeeService.findEmployeeById(eq(1L))).thenReturn(employeeDto);
        // When - pont mint a Faclet
        updateEmployeeController.setId(1);
        updateEmployeeController.findEmployeeById();
        // Then
        // Faceletet szimulálok
//        System.out.println(updateEmployeeController.getModifyEmployeeCommand().getId());
//        System.out.println(updateEmployeeController.getModifyEmployeeCommand().getName());

        assertEquals(1L, updateEmployeeController.getModifyEmployeeCommand().getId());
        assertEquals("John Doe", updateEmployeeController.getModifyEmployeeCommand().getName());
    }

    @Test
    void testModifyEmployee() {
        ModifyEmployeeCommand command = new ModifyEmployeeCommand();
        command.setId(5L);
        command.setName("Jack Smith");
        updateEmployeeController.setModifyEmployeeCommand(command);
        updateEmployeeController.modifyEmployee();

        verify(employeeService).modifyEmployee(argThat(c -> c.getName().equals("JACK SMITH")));
    }
}
