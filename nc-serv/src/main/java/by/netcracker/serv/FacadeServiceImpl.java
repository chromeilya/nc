package by.netcracker.serv;

import by.netcracker.pojo.Group;
import by.netcracker.pojo.Student;
import by.netcracker.serv.exceptions.ServException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementing FacadeService interface.
 * Connecting StudentService and GroupService in general class.
 * @see by.netcracker.serv.FacadeService
 * @author Hromenkov Ilya
 * @version 1.0
 */
@Component
@Service("facadeService")
@Transactional
public class FacadeServiceImpl implements FacadeService {

    @Autowired
    StudentService studentService;

    @Autowired
    GroupService groupService;

    public FacadeServiceImpl() {
    }

    /**
     * This method getting all student.
     * @return studentService.getAllStudent()
     * @throws ServException pushing in up method.
     */
    @Override
    public List<Student> getAllStudent() throws ServException {
        return studentService.getAllStudent();
    }

    /**
     * This method deleting student by id.
     * @param id Student id.
     * @return studentService.deleteStudentById(id).
     * @throws ServException pushing in up method.
     */
    @Override
    public Boolean deleteStudentById(Integer id) throws ServException {
        return studentService.deleteStudentById(id);
    }

    /**
     * This method saving student.
     * @param student Student pojo object.
     * @return studentService.saveStudent(student).
     * @throws ServException pushing in up method.
     */
    @Override
    public Boolean saveStudent(Student student) throws ServException {
        return studentService.saveStudent(student);
    }

    /**
     * This method getting student by id.
     * @param id Student id.
     * @return studentService.getStudentById(id).
     * @throws ServException pushing in up method.
     */
    @Override
    public Student getStudentById(Integer id) throws ServException {
        return studentService.getStudentById(id);
    }

    /**
     * This method updating student.
     * @param student Student pojo object.
     * @return studentService.updateStudent(student).
     * @throws ServException pushing in up method.
     */
    @Override
    public Boolean updateStudent(Student student) throws ServException {
        return studentService.updateStudent(student);
    }

    /**
     * This method finding students.
     * @param param String parametr for find students.
     * @return studentService.findStudents(param)
     * @throws ServException pushing in up method.
     */
    @Override
    public List<Student> findStudents(String param) throws ServException {
        return studentService.findStudents(param);
    }

    /**
     * This method getting all Groups.
     * @return groupService.getAllGroup()
     * @throws ServException pushing in up method.
     */
    @Override
    public List<Group> getAllGroup() throws ServException {
        return groupService.getAllGroup();
    }

    /**
     * This method getting group by id.
     * @param id Student id.
     * @return groupService.getGroupById(id)
     * @throws ServException pushing in up method.
     */
    @Override
    public Group getGroupById(Integer id) throws ServException {
        return groupService.getGroupById(id);
    }
}
