package hunre.it.demo.service;

import hunre.it.demo.model.Employee;

import java.util.List;


public interface EmployeeService {

  List<Employee> findAll();

  Employee findById(int theId);

  void save(Employee theEmployee);

  void deleteById(int theId);

}
