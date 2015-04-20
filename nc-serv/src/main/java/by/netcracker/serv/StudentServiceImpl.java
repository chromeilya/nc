package by.netcracker.serv;

import by.netcracker.dao.Dao;
import by.netcracker.dao.exceptions.DaoException;
import by.netcracker.pojo.Group;
import by.netcracker.pojo.Student;
import by.netcracker.serv.exceptions.ServErrorCode;
import by.netcracker.serv.exceptions.ServException;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ilya on 4/13/15.
 */
@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService {
    private static Logger log = Logger.getLogger(StudentServiceImpl.class);

    @Autowired
    private Dao<Student, Integer> studentDao;

    StudentServiceImpl(){
    }

    @Override
    public List<Student> getAllStudent() throws ServException {
        List<Student> students;
        try {
            students=studentDao.getAll();
            log.info("Getting all students:"+students);
        } catch (DaoException e) {
            throw new ServException(e, ServErrorCode.NC_SERV_000);
        }
        return students;
    }

    @Override
    public Boolean deleteStudentById(Integer id) throws ServException{
        Student student;
        try {
            student=studentDao.get(id);
            studentDao.delete(student);
            log.info("Deleting student:"+student);
            return true;
        } catch (DaoException e) {
            throw new ServException(e, ServErrorCode.NC_SERV_002);
        }
    }

    @Override
    public Boolean saveStudent(Student student) throws ServException{

        try {
            studentDao.add(student);
            log.info("Adding student:"+student);
            return true;
        } catch (DaoException e) {
            throw new ServException(e, ServErrorCode.NC_SERV_003);
        }
    }

    @Override
    public Student getStudentById(Integer id) throws ServException{
        Student student;
        try {
            student=studentDao.get(id);
            log.info("Getting student:"+student);
        }catch (DaoException e){
            throw new ServException(e, ServErrorCode.NC_SERV_004);
        }
       return student;
    }

    @Override
    public Boolean updateStudent(Student student) throws ServException{
        try {
            studentDao.update(student);
            log.info("Updating student:"+student);
            return true;
        } catch (DaoException e) {
            throw new ServException(e, ServErrorCode.NC_SERV_006);
        }
    }


    public List<Student> findStudents(String param) throws ServException{
        List<Student> students;
        param='%'+param+'%';
        try {
            Query query=studentDao.getQuery("from Student stud where stud.fio like  :param " +
                    "or stud.group.facult like :param");
            query.setParameter("param", param);
            students=query.list();
            log.info("Finding students:"+students);
        } catch (DaoException e) {
            throw new ServException(e, ServErrorCode.NC_SERV_007);
        }
        return students;
    }


}
