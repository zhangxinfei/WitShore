package witstore.service;

import witstore.domain.User;

public interface ZUserService {
//    //添加新用户
//    void insertNewUser(User user);
//
//    //根据openId查询用户是否存在
//    User getUserByOpenId(String openId);

    //  通过主键删除用户
    int deleteByPrimaryKey(Integer userid);
    //  增加用户
    int insert(User record);

    int insertSelective(User record);
    //  通过主键查询用户
    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);
    //  通过主键修改用户
    int updateByPrimaryKey(User record);

}
