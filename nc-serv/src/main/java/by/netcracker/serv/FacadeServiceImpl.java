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
 * Created by ilya on 4/20/15.
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

    @Override
    public List<Student> getAllStudent() throws ServException {
        return studentService.getAllStudent();
    }

    @Override
    public Boolean deleteStudentById(Integer id) throws ServException {
        return studentService.deleteStudentById(id);
    }

    @Override
    public Boolean saveStudent(Student student) throws ServException {
        return studentService.saveStudent(student);
    }

    @Override
    public Student getStudentById(Integer id) throws ServException {
        return studentService.getStudentById(id);
    }

    @Override
    public Boolean updateStudent(Student student) throws ServException {
        return studentService.updateStudent(student);
    }

    @Override
    public List<Student> findStudents(String param) throws ServException {
        return studentService.findStudents(param);
    }

    @Override
    public List<Group> getAllGroup() throws ServException {
        return groupService.getAllGroup();
    }

    @Override
    public Group getGroupById(Integer id) throws ServException {
        return groupService.getGroupById(id);
    }
}
