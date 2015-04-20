package by.netcracker.web.controller;

import java.beans.PropertyEditorSupport;
import java.util.List;

import by.netcracker.pojo.Group;
import by.netcracker.pojo.Student;
import by.netcracker.serv.FacadeService;
import by.netcracker.serv.StudentService;
import by.netcracker.serv.exceptions.ServException;
import by.netcracker.web.exceptions.WebErrorCode;
import by.netcracker.web.exceptions.WebException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class AppController {
	private static Logger log = Logger.getLogger(AppController.class);

	@Autowired
	FacadeService facadeService;

	/*
	 * This method will list all existing employees.
	 */
	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listStudents(ModelMap model) throws Exception {

		List<Student> students;
		try {
			students = facadeService.getAllStudent();
		} catch (ServException e) {
			log.info("Cannot get list students");
			throw new WebException(e, WebErrorCode.NC_WEB_000);
		}
		log.info("Getting list students:"+students);
		model.addAttribute("students", students);
		return "main";
	}

		/*
	 * This method will delete an employee by it's SSN value.
	 */
	@RequestMapping(value = { "/delete-{id}-student" }, method = RequestMethod.GET)
	public String deleteStudents(@PathVariable String id) throws WebException {
		Integer idd=Integer.parseInt(id);
		try {
			facadeService.deleteStudentById(idd);
		} catch (ServException e) {
			log.info("Cannot delete student with id:"+id);
			throw new WebException(e, WebErrorCode.NC_WEB_001);
		}
		log.info("Deleting student with id:"+id);
		return "redirect:/list";
	}


	/*
	 * This method will provide the medium to add a new employee.
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newStudent(Model model) throws WebException {
		Student student=new Student();
		List<Group> groups= null;
		try {
			groups = facadeService.getAllGroup();
		} catch (ServException e) {
			log.info("Cannot get all groups");
			throw new WebException(e, WebErrorCode.NC_WEB_002);
		}
		log.info("Creating new student");
		model.addAttribute("student", student);
		model.addAttribute("groups", groups);
		return "registration";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * saving employee in database. It also validates the user input
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public String saveStudent(@Valid Student student, BindingResult result, Model model) throws WebException {
	//Student student=null;
		if (result.hasErrors()) {
			List<Group> groups= null;
			try {
				groups = facadeService.getAllGroup();
			} catch (ServException e) {
				log.info("Cannot get all groups");
				throw new WebException(e, WebErrorCode.NC_WEB_002);
			}
			log.info("Some errors in validation");
			model.addAttribute("groups", groups);
			return "registration";
		}

		try {
			facadeService.saveStudent(student);
		} catch (ServException e) {
			throw new WebException(e, WebErrorCode.NC_WEB_003);
		}

		/*model.addAttribute("success", "Employee " + employee.getName()
				+ " registered successfully");*/
		log.info("Created new student successfully");
		return "redirect:/list";
	}


	@RequestMapping(value = { "/edit-{id}-student" }, method = RequestMethod.GET)
	public String editStudent(@PathVariable String id, Model model) throws WebException {
		Integer idd=Integer.parseInt(id);
		Student student= null;
		List<Group> groups= null;
		try {
			student = facadeService.getStudentById(idd);
			groups = facadeService.getAllGroup();
		} catch (ServException e) {
			log.info("Cannot edit student");
			throw new WebException(e, WebErrorCode.NC_WEB_004);
		}
		log.info("Editing student");
		model.addAttribute("student", student);
		model.addAttribute("groups", groups);
		return "edit";
	}


	@RequestMapping(value = { "/edit-{id}-student" }, method = RequestMethod.POST)
	public String updateStudent(@Valid Student student, BindingResult result, Model model) throws WebException {
		if (result.hasErrors()) {
			List<Group> groups;
			try {
				groups = facadeService.getAllGroup();
			} catch (ServException e) {
				log.info("Cannot get all groups");
				throw new WebException(e, WebErrorCode.NC_WEB_004);
			}
			model.addAttribute("groups", groups);
			return "edit";
		}

		try {
			facadeService.updateStudent(student);
		} catch (ServException e) {
			log.info("Cannot update student");
			throw new WebException(e, WebErrorCode.NC_WEB_005);
		}

		/*model.addAttribute("success", "Employee " + employee.getName()
				+ " registered successfully");*/
		log.info("Updated new student successfully");
		return "redirect:/list";
	}

	@RequestMapping(value = { "/search" }, method = RequestMethod.GET)
	public String findStudent(@RequestParam("search") String search, Model model) throws WebException {
		List<Student> students;
		try {
			students = facadeService.findStudents(search);
			if (students.size()==0) {
				log.info("Cannot find students");
				throw new WebException(WebErrorCode.NC_WEB_006);
			}
		} catch (ServException e) {
			log.info("Error with find students");
			throw new WebException(e, WebErrorCode.NC_WEB_001);
		}
		log.info("Finded students successfully"+students);
		model.addAttribute("students", students);
		return "main";
	}
	
	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(Group.class, "group", new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) {
				try {
					Integer id = Integer.parseInt(text);
					Group group= null;
					try {
						group = facadeService.getGroupById(id);
					} catch (ServException e) {
						log.info("Cannot get all groups");
						e.printStackTrace();
					}
					setValue(group);
					log.info("Set value for: "+group);
				}catch (NumberFormatException e) {
					log.info("Cannot get group with number: "+text);
					setValue(null);
				}
			}
		});
	}

}
