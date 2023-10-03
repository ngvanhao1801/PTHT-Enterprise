package hunre.it.demo.service;

import hunre.it.demo.model.Employee;

import java.util.List;


public interface EmployeeService {

  List<Employee> findAll();

  Employee findById(Long id);

  Employee updateEmployee(Employee employee);

  void save(Employee theEmployee);

  void deleteById(Long id);

}
