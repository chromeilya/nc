package by.netcracker.web.controller;

import java.beans.PropertyEditorSupport;
import java.util.List;

import by.netcracker.pojo.Group;
import by.netcracker.pojo.Student;
import by.netcracker.serv.Serv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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
	 * This method will delete an employee by it's SSN value.
	 */
	@RequestMapping(value = { "/delete-{id}-student" }, method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable String id) {
		Integer idd=Integer.parseInt(id);
		serv.deleteStudentById(idd);
		return "redirect:/list";
	}


	/*
	 * This method will provide the medium to add a new employee.
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newStudent(Model model) {
		Student student=new Student();
		List<Group> groups=serv.getAllGroup();

		model.addAttribute("student", student);
		model.addAttribute("groups", groups);
		return "registration";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * saving employee in database. It also validates the user input
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("student") Student student, Model model, BindingResult result) {
	//Student student=null;
		/*if (result.hasErrors()) {
			return "registration";
		}*/

		serv.saveStudent(student);

		/*model.addAttribute("success", "Employee " + employee.getName()
				+ " registered successfully");*/
		return "redirect:/list";
	}


	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(Group.class, "group", new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) {
				try {
					Integer id = Integer.parseInt(text);
					Group group=serv.getGroupById(id);
					setValue(group);
				}catch (NumberFormatException e) {
					setValue(null);
				}
			}
		});
	}

}
