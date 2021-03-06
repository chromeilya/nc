package by.netcracker.serv;

import by.netcracker.dao.Dao;
import by.netcracker.dao.exceptions.DaoException;
import by.netcracker.pojo.Group;
import by.netcracker.pojo.Student;
import by.netcracker.serv.exceptions.ServException;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * This class testing GroupService with mocks.
 * @see by.netcracker.serv.StudentService
 * @author Hromenkov Ilya
 * @version 1.0
 */
@RunWith(MockitoJUnitRunner.class)
public class StudentServiceTest {

    @InjectMocks
    private StudentService studentService=new StudentServiceImpl();

    @Mock
    private Dao<Student, Integer> studentDao;

    private Group group1;
    private Group group2;

    private Student student1;
    private Student student2;
    private Student student3;
    private Integer studentId3 = 3;

    private List<Student> students;

    /**
     * Initialize custom parameter for tests.
     */
    @Before
    public void initParam(){

        MockitoAnnotations.initMocks(this);

        Integer idGroup1 = 1;
        Integer group_num1=111;
        String facult1="facult1";

        Integer idGroup2 = 2;
        Integer group_num2 = 222;
        String facult2 = "facult2";

        group1=new Group(idGroup1, group_num1, facult1);
        group2=new Group(idGroup2, group_num2, facult2);

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


        student1=new Student(id1, fio1, group1, type_stipend1, joinDate1);
        student2=new Student(id2, fio2, group2, type_stipend2, joinDate2);
        student3=new Student(fio3, group2, type_stipend3, joinDate3);

        students= Arrays.asList(student1, student2);
    }

    /**
     * Testing studentService.getAllStudent().
     */
    @Test
    public void getAllStudent(){
        try{
            when(studentDao.getAll()).thenReturn(students);

            assertNotNull(studentService.getAllStudent());
            assertEquals(students, studentService.getAllStudent());
        }catch (ServException e){
            e.printStackTrace();
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    /**
     * Testing studentService.deleteStudentById.
     */
    @Test
    public void deleteStudentById(){
        try {
            doNothing().when(studentDao).delete(student2);

            assertTrue(studentService.deleteStudentById(student2.getId()));
        } catch (DaoException e) {
            e.printStackTrace();
        } catch (ServException e) {
            e.printStackTrace();
        }
    }

    /**
     * Testing studentService.saveStudent.
     */
    @Test
    public void saveStudent(){
        try {
            studentService.saveStudent(student3);

            verify(studentDao).add(student3);
        } catch (DaoException e) {
            e.printStackTrace();
        } catch (ServException e) {
            e.printStackTrace();
        }
    }

    /**
     * Testing studentService.getStudentById.
     */
    @Test
    public void getStudentById(){
        try {
            when(studentDao.get(student1.getId())).thenReturn(student1);

            assertEquals(student1, studentService.getStudentById(student1.getId()));
        }catch (DaoException e) {
            e.printStackTrace();
        } catch (ServException e) {
            e.printStackTrace();
        }
    }

    /**
     * Testing studentService.updateStudent.
     */
    @Test
    public void updateStudent(){
        student1.setFio(student2.getFio());
        try {
            studentService.updateStudent(student1);

            verify(studentDao).update(student1);
        }catch (DaoException e) {
            e.printStackTrace();
        } catch (ServException e) {
            e.printStackTrace();
        }
    }


}
