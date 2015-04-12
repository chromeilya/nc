package by.netcracker.serv;

import by.netcracker.dao.Dao;
import by.netcracker.dao.exceptions.DaoException;
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
}
