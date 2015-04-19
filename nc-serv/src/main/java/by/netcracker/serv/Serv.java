package by.netcracker.serv;

import by.netcracker.pojo.Group;
import by.netcracker.pojo.Student;
import by.netcracker.serv.exceptions.ServException;

import java.util.List;

/**
 * Created by ilya on 4/13/15.
 */
public interface Serv {

    public List<Student> getAllStudent() throws ServException;

    public List<Group> getAllGroup() throws ServException;

    public Boolean deleteStudentById(Integer id) throws ServException;

    public Boolean saveStudent(Student student) throws ServException;

    public Student getStudentById(Integer id) throws ServException;

    public Group getGroupById(Integer id) throws ServException;

    public Boolean updateStudent(Student student) throws ServException;

    public List<Student> findStudents(String param) throws ServException;

    public List<Group> getAllGroup();

    public Boolean deleteStudentById(Integer id);

    public Boolean saveStudent(Student student);

    public Group getGroupById(Integer id);

}
