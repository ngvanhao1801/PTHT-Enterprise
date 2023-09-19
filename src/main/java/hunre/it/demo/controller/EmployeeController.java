package hunre.it.demo.controller;

import hunre.it.demo.model.Employee;
import hunre.it.demo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

		Employee thEmployee = new Employee();
		theModel.addAttribute("employees", thEmployee);

		return "/employee-form";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee thEmployee) {

		employeeService.save(thEmployee);

		return "redirect:/employees/list";
	}
}
