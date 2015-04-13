package by.netcracker.web.controller;

import java.util.List;

import by.netcracker.pojo.Student;
import by.netcracker.serv.Serv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class AppController {

	@Autowired
	Serv serv;

	/*
	 * This method will list all existing employees.
	 */
	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listEmployees(ModelMap model) {

		List<Student> students = serv.getAllStudent();
		model.addAttribute("students", students);
		return "main";
	}

	/*
	 * This method will provide the medium to add a new employee.
	 */
/*	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newEmployee(ModelMap model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "registration";
	}*/

	/*
	 * This method will be called on form submission, handling POST request for
	 * saving employee in database. It also validates the user input
	 */
/*	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public String saveEmployee(@Valid Employee employee, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "registration";
		}

		service.saveEmployee(employee);

		model.addAttribute("success", "Employee " + employee.getName()
				+ " registered successfully");
		return "success";
	}*/

	/*
	 * This method will delete an employee by it's SSN value.
	 */
	/*@RequestMapping(value = { "/delete-{ssn}-employee" }, method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable String ssn) {
		service.deleteEmployeeBySsn(ssn);
		return "redirect:/list";
	}*/

}
