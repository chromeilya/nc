package by.netcracker.serv;

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
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by ilya on 4/20/15.
 */
@RunWith(MockitoJUnitRunner.class)
public class FacadeServiceTest{

    @InjectMocks
    private FacadeService facadeService=new FacadeServiceImpl();

    @Mock
    private StudentService studentService;

    @Mock
    private GroupService groupService;

    private Group group1;
    private Group group2;

    private Student student1;
    private Student student2;
    private Student student3;

    private List<Student> students;
    private List<Group> groups;


    @Before
    public void setUp(){

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
        groups= Arrays.asList(group1, group2);

    }


    @Test
    public void getAllStudent(){
        try {
            when(studentService.getAllStudent()).thenReturn(students);
            assertEquals(facadeService.getAllStudent(), students);
        } catch (ServException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteStudentById(){
        try {
            facadeService.deleteStudentById(student1.getId());
            verify(studentService).deleteStudentById(student1.getId());
        } catch (ServException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void saveStudent(){
        try {
            facadeService.saveStudent(student2);
            verify(studentService).saveStudent(student2);
        } catch (ServException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getStudentById(){
        try {
            facadeService.getStudentById(student2.getId());
            verify(studentService).getStudentById(student2.getId());
        } catch (ServException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateStudent(){
        student2.setFio(student1.getFio());
        try {
            facadeService.updateStudent(student2);
            verify(studentService).updateStudent(student2);
        } catch (ServException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findStudents(){
        try {
            facadeService.findStudents(student3.getFio());
            verify(studentService).findStudents(student3.getFio());
        } catch (ServException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAllGroup(){
        try {
            when(groupService.getAllGroup()).thenReturn(groups);
            assertEquals(facadeService.getAllGroup(), groups);
        } catch (ServException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getGroupById(){
        try {
            facadeService.getGroupById(group1.getId());
            verify(groupService).getGroupById(group1.getId());
        } catch (ServException e) {
            e.printStackTrace();
        }
    }
}
