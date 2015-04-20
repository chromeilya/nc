package by.netcracker.serv;

import by.netcracker.pojo.Group;
import by.netcracker.serv.exceptions.ServException;

import java.util.List;

/**
 * Created by ilya on 4/20/15.
 */
public interface GroupService {

    public List<Group> getAllGroup() throws ServException;

    public Group getGroupById(Integer id) throws ServException;
}
