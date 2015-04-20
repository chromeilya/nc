package by.netcracker.serv;

import by.netcracker.dao.Dao;
import by.netcracker.dao.exceptions.DaoException;
import by.netcracker.pojo.Group;
import by.netcracker.pojo.Student;
import by.netcracker.serv.exceptions.ServException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.junit.Assert.*;

/**
 * Created by ilya on 4/20/15.
 */
@RunWith(MockitoJUnitRunner.class)
public class GroupServiceTest {

    @Mock
    private Dao<Group, Integer> groupDao;

    @InjectMocks
    private GroupService groupService=new GroupServiceImpl();

    private Group group1;
    private Group group2;
    private Group group3;
    private List<Group> groups;

    @Before
    public void initParam(){

        MockitoAnnotations.initMocks(this);

        Integer idGroup1 = 1;
        Integer group_num1=111;
        String facult1="facult1";

        Integer idGroup2 = 2;
        Integer group_num2 = 222;
        String facult2 = "facult2";

        Integer idGroup3 = 3;
        Integer group_num3 = 333;
        String facult3 = "facult3";

        group1=new Group(idGroup1, group_num1, facult1);
        group2=new Group(idGroup2, group_num2, facult2);
        group3=new Group(group_num3, facult3);

        groups= Arrays.asList(group1, group2);
    }

    @Test
    public void getAllGroup(){
        try {
            when(groupDao.getAll()).thenReturn(groups);

            assertNotNull(groupService.getAllGroup());
            assertEquals(groups, groupService.getAllGroup());
        }catch (DaoException e) {
            e.printStackTrace();
        } catch (ServException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getGroupById(){
        try {
            when(groupDao.get(group1.getId())).thenReturn(group1);

            assertEquals(group1, groupService.getGroupById(group1.getId()));
        }catch (DaoException e) {
            e.printStackTrace();
        } catch (ServException e) {
            e.printStackTrace();
        }
    }

}
