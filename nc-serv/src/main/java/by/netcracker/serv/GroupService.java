package by.netcracker.serv;

import by.netcracker.pojo.Group;
import by.netcracker.serv.exceptions.ServException;

import java.util.List;

/**
 * Interface for GroupServiceImpl class.
 * @author Hromenkov Ilya
 * @version 1.0
 */
public interface GroupService {

    public List<Group> getAllGroup() throws ServException;

    public Group getGroupById(Integer id) throws ServException;
}
