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

  @GetMapping("/update")
  public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel) {

    Optional <Employee> theEmployee = Optional.ofNullable(employeeService.findById(theId));
    theEmployee.isPresent();

    return "/employee-form";
  }

  @GetMapping("/saveUpdate")
  public String saveUpdate(Employee employee, BindingResult result, RedirectAttributes model) {
    if (result.hasErrors()) {
      return "/employee-form";
    } else {
      employeeService.save(employee);
      model.addFlashAttribute("success", "Cập nhật thành công!");
    }
    return "redirect:/employees/list";
  }
//  @PutMapping("update")
//  public String updateEmployee(@RequestParam("id") int id, Employee employee) {
//
//    Employee theEmployee = employeeService.findById(id, employee);
//    return "/employee-form";
//  }

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
