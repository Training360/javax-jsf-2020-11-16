package training.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<EmployeeDto> listEmployees(EmployeesQuery employeesQuery) {
        return employeeRepository
                //.findAll(Sort.by("name"))
                .findAllByNameLikeOrderByName(employeesQuery.getNameQuery() == null ? "%" : employeesQuery.getNameQuery() + "%")
                .stream()
                .map(EmployeeDto::new)
                .collect(Collectors.toList());
    }

    public void createEmployee(CreateEmployeeCommand command) {
        Employee employee = new Employee();
        employee.setName(command.getName());
        employee.setFavouriteLanguage(command.getFavouriteLanguage());
        // Save tranzakciot indit
        employeeRepository.save(employee);
    }

    public EmployeeDto findEmployeeById(long id) {
        return new EmployeeDto(employeeRepository.getOne(id));
    }

    @Transactional
    public void modifyEmployee(ModifyEmployeeCommand command) {
        Employee employee = employeeRepository.getOne(command.getId());
        employee.setName(command.getName());
        employee.setFavouriteLanguage(command.getFavouriteLanguage());
    }

    public void deleteEmployee(DeleteEmployeeCommand command) {
        // Delete tranzakciot indit
        employeeRepository.deleteById(command.getId());
    }

    public List<String> listAvailableLanguages() {
        // Adatbázisból jön
        return List.of("Java", "Python", "JavaScript", "C#");
    }
}
