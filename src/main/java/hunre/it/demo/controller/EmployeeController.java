package hunre.it.demo.controller;

import hunre.it.demo.model.Employee;
import hunre.it.demo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

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

    return "/employee-form";
  }

  @GetMapping("/showFormForUpdate")
  public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel) {

    Employee theEmployee = employeeService.findById(theId);
    theModel.addAttribute("employee", theEmployee);

    return "/employee-form";
  }

  @GetMapping("/delete")
  public String deleteEmployee(@RequestParam("employeeId") int theId) {

    employeeService.deleteById(theId);

    return "redirect:/employees/list";
  }

  @PostMapping("/save")
  public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {

    employeeService.save(theEmployee);

    return "redirect:/employees/list";
  }
}
