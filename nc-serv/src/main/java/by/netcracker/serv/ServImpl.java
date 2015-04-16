package by.netcracker.serv;

import by.netcracker.dao.Dao;
import by.netcracker.dao.exceptions.DaoException;
import by.netcracker.pojo.Group;
import by.netcracker.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ilya on 4/13/15.
 */
@Service("serv")
@Transactional
public class ServImpl implements Serv {

    @Autowired
    private Dao<Student, Integer> studentDao;

    @Autowired
    private Dao<Group, Integer> groupDao;


    @Override
    public List<Student> getAllStudent() {

        List<Student> students = null;

        try {
            students=studentDao.getAll();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public List<Group> getAllGroup(){
      List<Group> groups=null;
        try {
            groups=groupDao.getAll();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return groups;
    };

    @Override
    public Boolean deleteStudentById(Integer id){
        Student student;
        try {
            student=studentDao.get(id);
            studentDao.delete(student);
            return true;
        } catch (DaoException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Boolean saveStudent(Student student){

        try {
            studentDao.add(student);
            return true;
        } catch (DaoException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Student getStudentById(Integer id){
        Student student=null;
        try {
            student=studentDao.get(id);
        }catch (DaoException e){
            e.printStackTrace();
        }
       return student;
    }

    @Override
    public Group getGroupById(Integer id){
      Group group=null;
        try {
           group=groupDao.get(id);

        }catch (DaoException e){
            e.printStackTrace();
        }
        return group;
    }

    @Override
    public Boolean updateStudent(Student student){
        try {
            studentDao.update(student);
            return true;
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return false;
    }


}
