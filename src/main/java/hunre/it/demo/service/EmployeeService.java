package hunre.it.demo.service;

import java.util.List;

import hunre.it.demo.model.Employee;


public interface EmployeeService {

	public List<Employee> findAll();

	public Employee findById(int theId);

	public void save(Employee theEmployee);

	public void deleteById(int theId);

}
