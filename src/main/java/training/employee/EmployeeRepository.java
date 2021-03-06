package training.employee;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findAllByNameLikeOrderByName(String name);

    List<Employee> findByName(String name);
}
