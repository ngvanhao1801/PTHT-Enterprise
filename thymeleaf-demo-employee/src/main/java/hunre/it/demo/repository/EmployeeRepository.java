package hunre.it.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hunre.it.demo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
