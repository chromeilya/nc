package by.netcracker.dao;


import by.netcracker.dao.configuration.HibernateConfiguration;
import by.netcracker.dao.exceptions.DaoException;
import by.netcracker.pojo.Group;
import by.netcracker.pojo.Student;
import org.hibernate.Query;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.Transactional;
import org.unitils.UnitilsJUnit4;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBeanByName;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * This class testing StudentDao with dbunit.
 * @see by.netcracker.dao.DaoImpl
 * @see by.netcracker.dao.configuration.DaoBeans
 * @author Hromenkov Ilya
 * @version 1.0
 */
@DataSet
@Transactional
public class StudentDaoTest extends UnitilsJUnit4 {

    @SpringBeanByName
    private Dao<Student, Integer> studentDao;
    private Group group1;
    private Group group2;
    private Student student1;
    private Student student2;
    private Student student3;
    private Integer studentId3 = 3;

    /**
     * Initialize spring context.
     * @return AnnotationConfigApplicationContext
     */
    @SpringApplicationContext
    public ConfigurableApplicationContext createApplicationContext() {
        return new AnnotationConfigApplicationContext(
                HibernateConfiguration.class);
    }

    /**
     * Initialize custom parameter for tests.
     */
    @Before
    public void initParam() {

        Integer idGroup1 = 1;
        Integer group_num1 = 111;
        String facult1 = "facult1";

        Integer idGroup2 = 2;
        Integer group_num2 = 222;
        String facult2 = "facult2";

        group1 = new Group(idGroup1, group_num1, facult1);
        group2 = new Group(idGroup2, group_num2, facult2);

        Integer id1 = 1;
        String fio1 = "fio1";
        String type_stipend1 = "type1";
        LocalDate joinDate1 = LocalDate.parse("2012-11-21");


        Integer id2 = 2;
        String fio2 = "fio2";
        String type_stipend2 = "type2";
        LocalDate joinDate2 = LocalDate.parse("2012-11-22");


        Integer id3 = 3;
        String fio3 = "fio3";
        String type_stipend3 = "type3";
        LocalDate joinDate3 = LocalDate.parse("2012-11-23");


        student1 = new Student(id1, fio1, group1, type_stipend1, joinDate1);
        student2 = new Student(id2, fio2, group2, type_stipend2, joinDate2);
        student3 = new Student(fio3, group2, type_stipend3, joinDate3);
    }

    /**
     * Testing studentDao.getAll().
     * @throws DaoException
     */
    @Test
    public void getAllStudent() throws DaoException {
        List<Student> students = null;
        try {
            students = studentDao.getAll();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        List<Student> studentTest = Arrays.asList(student1, student2);
        assertNotNull(students);
        assertEquals(students.size(), studentTest.size());
    }

    /**
     * Testing studentDao.get.
     * @throws DaoException
     */
    @Test
    public void getStudentById() throws DaoException {
        Student studentResult = null;
        try {
            studentResult = studentDao.get(student1.getId());
        } catch (DaoException e) {
            e.printStackTrace();
        }
        assertNotNull(studentResult);
        assertEquals(student1, studentResult);
    }

    /**
     * Testing studentDao.add.
     * @throws DaoException
     */
    @Test
    public void addStudent() throws DaoException {
        Integer studentIdResult = null;
        try {
            studentIdResult = studentDao.add(student3);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        assertNotNull(studentIdResult);
    }

    /**
     * Testing studentDao.update.
     * @throws DaoException
     */
    @Test
    public void updateStudent() throws DaoException {
        student1.setFio(student2.getFio());
        Student studentResult = null;
        try {
            studentDao.update(student1);
            studentResult = studentDao.get(student1.getId());
        } catch (DaoException e) {
            e.printStackTrace();
        }
        assertNotNull(studentResult);
        assertEquals(student1, studentResult);
    }

    /**
     * Testing studentDao.delete.
     * @throws DaoException
     */
    @Test
    public void deleteStudent() throws DaoException {
        Student studentResult = student2;
        try {
            studentDao.delete(student2);
            studentResult = studentDao.get(student2.getId());
        } catch (DaoException e) {
            e.printStackTrace();
        }
        assertNull(studentResult);
    }

    /**
     * Testing studentDao.getQuery.
     * @throws DaoException
     */
    @Test
    public void findStudent() throws DaoException {
        String param = "%io%";
        List<Student> students = null;
        try {
            Query query = studentDao.getQuery("from Student stud where stud.fio like  :param " +
                    "or stud.group.facult like :param");
            query.setParameter("param", param);
            students = query.list();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        List<Student> studentTest = Arrays.asList(student1, student2);
        assertNotNull(students);
        assertEquals(students.size(), studentTest.size());
    }
}
