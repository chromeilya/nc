package by.netcracker.serv;

import by.netcracker.pojo.Group;
import by.netcracker.pojo.Student;
import by.netcracker.serv.exceptions.ServException;

import java.util.List;

/**
 * Interface using facade pattern for FacadeServiceImpl class.
 * @see by.netcracker.serv.FacadeServiceImpl
 * @author Hromenkov Ilya
 * @version 1.0
 */
public interface FacadeService {

    public List<Student> getAllStudent() throws ServException;

    public Boolean deleteStudentById(Integer id) throws ServException;

    public Boolean saveStudent(Student student) throws ServException;

    public Student getStudentById(Integer id) throws ServException;

    public Boolean updateStudent(Student student) throws ServException;

    public List<Student> findStudents(String param) throws ServException;

    public List<Group> getAllGroup() throws ServException;

    public Group getGroupById(Integer id) throws ServException;
}
