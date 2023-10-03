package hunre.it.demo.controller;

import hunre.it.demo.model.Employee;
import hunre.it.demo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

  private final EmployeeService employeeService;

  public EmployeeController(EmployeeService theEmployeeService) {
    employeeService = theEmployeeService;
  }

  @GetMapping("/list")
  public String listEmployee(Model theModel) {
    List<Employee> theEmployees = employeeService.findAll();

    theModel.addAttribute("employees", theEmployees);

    return "/list-employees";
  }

  @GetMapping("/showFormForAdd")
  public String showFormForAdd(Model theModel) {

    Employee theEmployee = new Employee();
    theModel.addAttribute("employees", theEmployee);

    return "create_employee";
  }

  @PostMapping("/save")
  public String saveEmployee(@ModelAttribute("employees") Employee theEmployee) {

    employeeService.save(theEmployee);

    return "redirect:/employees/list";
  }

  @GetMapping("/edit/{id}")
  public String editStudentForm(@PathVariable Long id, Model model) {

    model.addAttribute("employees", employeeService.findById(id));

    return "edit_employees";
  }

  @PostMapping("/update/{id}")
  public String updateEmployee(@PathVariable Long id,
                               @ModelAttribute("employees") Employee employee,
                               Model model) {

    Employee existingEmployee = employeeService.findById(id);
    existingEmployee.setId(id);
    existingEmployee.setFirstName(employee.getFirstName());
    existingEmployee.setLastName(employee.getLastName());
    existingEmployee.setEmail(employee.getEmail());

    employeeService.updateEmployee(existingEmployee);
    return "redirect:/employees/list";
  }


  @GetMapping("/delete")
  public String deleteEmployee(@RequestParam("employeeId") Long id) {

    employeeService.deleteById(id);

    return "redirect:/employees/list";
  }


}
