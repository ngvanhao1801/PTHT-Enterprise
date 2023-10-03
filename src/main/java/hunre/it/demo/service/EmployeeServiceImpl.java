package hunre.it.demo.service;

import hunre.it.demo.model.Employee;
import hunre.it.demo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  private final EmployeeRepository employeeRepository;

  public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
    employeeRepository = theEmployeeRepository;
  }

  @Override
  public List<Employee> findAll() {
    return employeeRepository.findAll();
  }

  @Override
  public Employee findById(Long id) {
    return employeeRepository.findById(id).get();
  }

  @Override
  public Employee updateEmployee(Employee employee) {
    return employeeRepository.save(employee);
  }

  @Override
  public void save(Employee theEmployee) {
    employeeRepository.save(theEmployee);
  }

  @Override
  public void deleteById(Long id) {
    employeeRepository.deleteById(id);
  }

}
