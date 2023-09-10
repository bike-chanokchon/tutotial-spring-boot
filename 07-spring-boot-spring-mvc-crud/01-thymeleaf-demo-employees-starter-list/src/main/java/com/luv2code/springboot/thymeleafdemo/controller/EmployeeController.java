package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	// load employee data
	// private List<Employee> theEmployees;

	// @PostConstruct
	// private void loadData() {

	// 	// create employees
	// 	Employee emp1 = new Employee("Leslie", "Andrews", "leslie@luv2code.com");
	// 	Employee emp2 = new Employee("Emma", "Baumgarten", "emma@luv2code.com");
	// 	Employee emp3 = new Employee("Avani", "Gupta", "avani@luv2code.com");

	// 	// create the list
	// 	theEmployees = new ArrayList<>();

	// 	// add to the list
	// 	theEmployees.add(emp1);
	// 	theEmployees.add(emp2);
	// 	theEmployees.add(emp3);
	// }

	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		// add to the spring model
		theModel.addAttribute("employees", this.employeeService.findAll());

		return "employees/list-employees";
	}

	@GetMapping("/showFormForAdd")
	public String showFromForAdd(Model model) {
		// create model attribute to bind form data
		Employee employee = new Employee();

		model.addAttribute("employee", employee);

		return "employees/employee-form";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("employee") Employee employee) {
		// save the employee
		this.employeeService.save(employee);

		// use a redirect to prevent duplicate
		return "redirect:/employees/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int id, Model model) {
		// get the employee from the service
		Employee employee = this.employeeService.findById(id);

		// set employee in the model to prepopulate the form
		model.addAttribute("employee", employee);

		// send over to our form
		return "employees/employee-form";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int id) {
		// delete the employee
		this.employeeService.deleteById(id);

		// redirect to the /employees/list
		return "redirect:/employees/list";
	}
}









