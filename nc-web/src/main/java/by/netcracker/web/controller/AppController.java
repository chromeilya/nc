package by.netcracker.web.controller;

import by.netcracker.pojo.Group;
import by.netcracker.pojo.Student;
import by.netcracker.serv.FacadeService;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.util.List;

/**
 *
 */

@Controller
@RequestMapping("/")
public class AppController {
    private static Logger log = Logger.getLogger(AppController.class);

    @Autowired
    FacadeService facadeService;

    /**
     * This method will get all students.
     * @param model Spring Model for work with form attribute.
     * @return "main" page
     * @throws WebException catch ServException
     */
    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public String listStudents(Model model) throws WebException {

        List<Student> students;
        try {
            students = facadeService.getAllStudent();
        } catch (ServException e) {
            log.info("Cannot get list students");
            throw new WebException(e, WebErrorCode.NC_WEB_000);
        }
        log.info("Getting list students:" + students);
        model.addAttribute("students", students);
        return "main";
    }

    /**
     * This method will delete student by id.
     * @param id Get student id.
     * @param redirectAttributes attribute for input success response.
     * @return "redirect:/list" to main page
     * @throws WebException catch ServException
     */
    @RequestMapping(value = {"/delete-{id}-student"}, method = RequestMethod.GET)
    public String deleteStudents(@PathVariable String id, final RedirectAttributes redirectAttributes) throws WebException {
        Integer idd = Integer.parseInt(id);
        Student student;
        try {
            student = facadeService.getStudentById(idd);
            facadeService.deleteStudentById(idd);
        } catch (ServException e) {
            log.info("Cannot delete student with id:" + id);
            throw new WebException(e, WebErrorCode.NC_WEB_001);
        }
        redirectAttributes.addFlashAttribute("success", "Student " + student.getFio()
                + " deleted successfully!");
        log.info("Deleting student with id:" + id);
        return "redirect:/list";
    }


    /**
     * This method will provide the medium to add a new student.
     * @param model Spring Model for work with form attribute.
     * @return "registration" page
     * @throws WebException catch ServException
     */
    @RequestMapping(value = {"/new"}, method = RequestMethod.GET)
    public String newStudent(Model model) throws WebException {
        Student student = new Student();
        List<Group> groups = null;
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

    /**
     * 
     * @param student
     * @param result
     * @param model
     * @param redirectAttributes
     * @return
     * @throws WebException
     */
    @RequestMapping(value = {"/new"}, method = RequestMethod.POST)
    public String saveStudent(@Valid Student student, BindingResult result, Model model, final RedirectAttributes redirectAttributes) throws WebException {
        //Student student=null;
        if (result.hasErrors()) {
            List<Group> groups = null;
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

        redirectAttributes.addFlashAttribute("success", "Student " + student.getFio()
                + " registered successfully!");
        log.info("Created new student successfully");
        return "redirect:/list";
    }


    @RequestMapping(value = {"/edit-{id}-student"}, method = RequestMethod.GET)
    public String editStudent(@PathVariable String id, Model model) throws WebException {
        Integer idd = Integer.parseInt(id);
        Student student = null;
        List<Group> groups = null;
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


    @RequestMapping(value = {"/edit-{id}-student"}, method = RequestMethod.POST)
    public String updateStudent(@Valid Student student, BindingResult result, Model model, final RedirectAttributes redirectAttributes) throws WebException {
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

        redirectAttributes.addFlashAttribute("success", "Student " + student.getFio()
                + " updated successfully!");
        log.info("Updated new student successfully");
        return "redirect:/list";
    }

    @RequestMapping(value = {"/search"}, method = RequestMethod.GET)
    public String findStudent(@RequestParam("search") String search, Model model) throws WebException {
        List<Student> students;
        try {
            students = facadeService.findStudents(search);
            if (students.size() == 0) {
                log.info("Cannot find students");
                throw new WebException(WebErrorCode.NC_WEB_006);
            }
        } catch (ServException e) {
            log.info("Error with find students");
            throw new WebException(e, WebErrorCode.NC_WEB_001);
        }
        log.info("Finded students successfully" + students);
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
                    Group group = null;
                    try {
                        group = facadeService.getGroupById(id);
                    } catch (ServException e) {
                        log.info("Cannot get all groups");
                        e.printStackTrace();
                    }
                    setValue(group);
                    log.info("Set value for: " + group);
                } catch (NumberFormatException e) {
                    log.info("Cannot get group with number: " + text);
                    setValue(null);
                }
            }
        });
    }

}
