package by.netcracker.serv;

import by.netcracker.dao.Dao;
import by.netcracker.dao.exceptions.DaoException;
import by.netcracker.pojo.Group;
import by.netcracker.serv.exceptions.ServErrorCode;
import by.netcracker.serv.exceptions.ServException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementing GroupService interface.
 * Processing business-logic for work with Group.
 * @author Hromenkov Ilya
 * @version 1.0
 */
@Service("groupService")
@Transactional
public class GroupServiceImpl implements GroupService {

    private static Logger log = Logger.getLogger(GroupServiceImpl.class);

    @Autowired
    private Dao<Group, Integer> groupDao;

    public GroupServiceImpl() {
    }

    /**
     * This method getting all groups.
     * @return groups.
     * @throws ServException catch DaoException, create new ServException and pushing up.
     */
    @Override
    public List<Group> getAllGroup() throws ServException {
        List<Group> groups;
        try {
            groups = groupDao.getAll();
            log.info("Getting all groups:" + groups);
        } catch (DaoException e) {
            throw new ServException(e, ServErrorCode.NC_SERV_001);
        }
        return groups;
    }

    /**
     * This method getting group by id.
     * @param id Group id.
     * @return group.
     * @throws ServException catch DaoException, create new ServException and pushing up.
     */
    @Override
    public Group getGroupById(Integer id) throws ServException {
        Group group;
        try {
            group = groupDao.get(id);
            log.info("Getting group:" + group);
        } catch (DaoException e) {
            throw new ServException(e, ServErrorCode.NC_SERV_005);
        }
        return group;
    }
}
