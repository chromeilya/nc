package by.netcracker.dao;

import by.netcracker.dao.configuration.HibernateConfiguration;
import by.netcracker.dao.exceptions.DaoException;
import by.netcracker.pojo.Group;
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
 * Created by ilya on 4/20/15.
 */
@DataSet
@Transactional
public class GroupDaoTest extends UnitilsJUnit4 {

    @SpringBeanByName
    private Dao<Group, Integer> groupDao;
    private Group group1;
    private Group group2;
    private Group group3;

    @SpringApplicationContext
    public ConfigurableApplicationContext createApplicationContext() {
        return new AnnotationConfigApplicationContext(
                HibernateConfiguration.class);
    }

    @Before
    public void initParam() {

        Integer idGroup1 = 1;
        Integer group_num1 = 111;
        String facult1 = "facult1";

        Integer idGroup2 = 2;
        Integer group_num2 = 222;
        String facult2 = "facult2";

        Integer idGroup3 = 3;
        Integer group_num3 = 333;
        String facult3 = "facult3";

        group1 = new Group(idGroup1, group_num1, facult1);
        group2 = new Group(idGroup2, group_num2, facult2);
        group3 = new Group(group_num3, facult3);
    }

    @Test
    public void getAllGroup() throws DaoException {
        List<Group> groups = null;
        try {
            groups = groupDao.getAll();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        List<Group> groupTest = Arrays.asList(group1, group2);
        assertNotNull(groups);
        assertEquals(groups.size(), groupTest.size());
    }

    @Test
    public void getGroupById() throws DaoException {
        Group groupResult = null;
        try {
            groupResult = groupDao.get(group1.getId());
        } catch (DaoException e) {
            e.printStackTrace();
        }
        assertNotNull(groupResult);
        assertEquals(group1, groupResult);
    }

    @Test
    public void addGroup() throws DaoException {
        Integer groupIdResult = null;
        try {
            groupIdResult = groupDao.add(group3);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        assertNotNull(groupIdResult);
    }

    @Test
    public void updateGroup() throws DaoException {
        group1.setFacult(group2.getFacult());
        Group groupResult = null;
        try {
            groupDao.update(group1);
            groupResult = groupDao.get(group1.getId());
        } catch (DaoException e) {
            e.printStackTrace();
        }
        assertNotNull(groupResult);
        assertEquals(group1, groupResult);
    }

    @Test
    public void deleteGroup() throws DaoException {
        Group groupResult = group2;
        try {
            groupDao.delete(group2);
            groupResult = groupDao.get(group2.getId());
        } catch (DaoException e) {
            e.printStackTrace();
        }
        assertNull(groupResult);
    }

}
