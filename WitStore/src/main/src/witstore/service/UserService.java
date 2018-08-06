package witstore.service;//package witstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import witstore.DAO.UserDAO;
import witstore.Tools.AesCbcUtil;
import witstore.Tools.JsonUtil;
import witstore.Tools.Tools;
import witstore.domain.User;


@Service
public class UserService {
    private final UserDAO userDAO;
    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    //添加新用户
    public boolean insertNewUser(String encryptedData, String iv, String session_key){
        System.out.println("1"+encryptedData);
        System.out.println("1"+iv);
        System.out.println("1"+session_key);
        try {
            String result = AesCbcUtil.decrypt(encryptedData, session_key, iv, "UTF-8");
            System.out.println("2"+result);
            if (null != result && result.length() > 0) {
                User user= JsonUtil.string2Obj(result,User.class);
                assert user != null;
                String openId=user.getOpenId();
                user.setOpenId(Tools.encryption(openId));
                userDAO.insertNewUser(user);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

   public User getUserByOpenId(String openId){
        return userDAO.getUserByOpenId(openId);
    }
}
