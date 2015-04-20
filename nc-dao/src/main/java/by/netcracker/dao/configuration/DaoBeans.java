package by.netcracker.dao.configuration;

import by.netcracker.dao.Dao;
import by.netcracker.dao.DaoImpl;
import by.netcracker.pojo.Group;
import by.netcracker.pojo.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ilya on 4/8/15.
 */

@Configuration
@ComponentScan({"by.netcracker.dao"})
public class DaoBeans {

    @Bean(name = "studentDao")
    public Dao<Student, Integer> studentDao() {
        return new DaoImpl<Student, Integer>(Student.class);
    }

    @Bean(name = "groupDao")
    public Dao<Group, Integer> groupDao() {
        return new DaoImpl<Group, Integer>(Group.class);
    }

}
