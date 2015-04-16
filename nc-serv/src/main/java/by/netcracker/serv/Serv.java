package by.netcracker.serv;

import by.netcracker.pojo.Group;
import by.netcracker.pojo.Student;

import java.util.List;

/**
 * Created by ilya on 4/13/15.
 */
public interface Serv {

    public List<Student> getAllStudent();

    public List<Group> getAllGroup();

    public Boolean deleteStudentById(Integer id);

    public Boolean saveStudent(Student student);

    public Group getGroupById(Integer id);

}
