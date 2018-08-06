package witstore.service.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import witstore.DAO.UserDAO;
import witstore.domain.User;
import witstore.service.ZUserService;

@Service
public class ZUserServiceImpl implements ZUserService {
    @Autowired
    UserDAO userDAO;

    @Override
    public int deleteByPrimaryKey(Integer userid) {
        userDAO.deleteByPrimaryKey(userid);
        return 0;
    }

    @Override
    public int insert(User record) {
        userDAO.insert(record);
        return 0;
    }

    @Override
    public int insertSelective(User record) {
        return 0;
    }

    @Override
    public User selectByPrimaryKey(Integer userid) {
        return userDAO.selectByPrimaryKey(userid);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(User record) {
        String userId = String.valueOf(record.getUserId());
        if (userId != null){
            userDAO.updateByPrimaryKey(record);
        }else {
            return 1;
        }
        return 0;
    }


//    @Override
//    public void insertNewUser(User user) {
//
//    }
//
//    @Override
//    public User getUserByOpenId(String openId) {
//        return null;
//    }
}
