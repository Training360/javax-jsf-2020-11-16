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

    public List<EmployeeDto> listEmployees() {
        return employeeRepository
                .findAll(Sort.by("name"))
                .stream()
                .map(EmployeeDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void createEmployee(CreateEmployeeCommand command) {
        Employee employee = new Employee();
        employee.setName(command.getName());
        employeeRepository.save(employee);
    }

    public EmployeeDto findEmployeeById(long id) {
        return new EmployeeDto(employeeRepository.getOne(id));
    }

    @Transactional
    public void modifyEmployee(ModifyEmployeeCommand command) {
        Employee employee = employeeRepository.getOne(command.getId());
        employee.setName(command.getName());
    }

    public void deleteEmployee(DeleteEmployeeCommand command) {
        employeeRepository.deleteById(command.getId());
    }
}
