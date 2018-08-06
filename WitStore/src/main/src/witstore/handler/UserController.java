package witstore.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import witstore.Tools.HttpRequest;
import witstore.Tools.JsonUtil;
import witstore.Tools.MySessionContext;
import witstore.Tools.Tools;
import witstore.domain.User;
import witstore.domain.WeChatSession_OpenId;
import witstore.service.UserService;
import witstore.service.ZUserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/User")
public class UserController {


    @Autowired
    UserService userService;
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

    /**
     * @Description: 解密用户敏感数据
     * @param encryptedData 明文,加密数据
     * @param iv   加密算法的初始向量
     * @param code  用户允许登录后，回调内容会带上 code（有效期五分钟），开发者需要将 code 发送到开
     *              发者服务器后台，使用code 换取 session_key api，将 code 换成 openid 和 session_key
     */
    @ResponseBody
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @RequestMapping(value = "/decodeUserInfo",method = RequestMethod.POST)
    public Map decodeUserInfo(String encryptedData, String iv, String code,HttpServletRequest request) {
        Map map = new HashMap();
        // 登录凭证不能为空
        if (code == null || code.length() == 0) {
            map.put("status", 0);
            map.put("msg", "code 不能为空");
            return map;
        }
        String wxspAppid = "wxa778be6e9b8556de";// 小程序唯一标识
        String wxspSecret = "04e96eed850431ff0f79bfa582564282";//小程序的 app secret
        String grant_type = "authorization_code"; // 授权（必填）
        //////////////// 1、向微信服务器 使用登录凭证 code 获取 session_key 和 openid ////////////////
        // 请求参数
        String params = "appid=" + wxspAppid + "&secret=" + wxspSecret + "&js_code=" + code + "&grant_type=" + grant_type;
        // 发送请求
        String sr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);
        //解析相应内容（转换成json对象）
        WeChatSession_OpenId WO = JsonUtil.string2Obj(sr,WeChatSession_OpenId.class);
        assert WO != null;
        String openId= Tools.encryption(WO.getOpenid());
        User user=userService.getUserByOpenId(openId);
        if (user!=null){
            //已存在该用户,向session域当中添加user对象
            HttpSession session=request.getSession();
            session.setAttribute("user",user);
            map.put("sessionId",session.getId());
            map.put("status", 1);
            map.put("msg", "登陆成功");
        }





        else{
            //用户未注册,注册用户
            boolean flag=userService.insertNewUser(encryptedData, iv, WO.getSession_key());
            if (flag){
                map.put("status", 1);
                map.put("msg", "解密成功");
            }
            else{
                map.put("status", 0);
                map.put("msg", "解密失败");
            }
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("test")
    public User test(HttpServletRequest request){
        System.out.println(request.getHeader("sessionId"));
        MySessionContext myc= MySessionContext.getInstance();
        HttpSession session = myc.getSession(request.getHeader("sessionId"));
        System.out.println(session.getAttribute("user"));
        User user= new User();
        return user;
    }
    @Autowired
    ZUserService zUserService;
    
    @RequestMapping("/insert")
    public void insert(HttpServletRequest request){
        HttpSession session = null;
        User user = (User) session.getAttribute("user");
        zUserService.insert(user);
    }
    
    @RequestMapping("/deleteByPrimaryKey")
    public void deleteByPrimaryKey(HttpServletRequest request){
        int primaryKey = 0;
        String  primaryKey1 = (String)request.getAttribute("primaryKey");
        if(primaryKey1 != null && !"".equals(primaryKey1)){
            primaryKey = new Integer(primaryKey1);
            //或者result = Integer.parseInt(attrValue);
        }
        zUserService.deleteByPrimaryKey(primaryKey);
    }


    @RequestMapping("/selectByPrimaryKey")
    @ResponseBody
    public User selectByPrimaryKey(HttpServletRequest request){
        int primaryKey = 0;
        String  primaryKey1 = (String)request.getAttribute("primaryKey");
        if(primaryKey1 != null && !"".equals(primaryKey1)){
            primaryKey = new Integer(primaryKey1);
            //或者result = Integer.parseInt(attrValue);
        }
        User user = zUserService.selectByPrimaryKey(primaryKey);
        return user;
    }

    @RequestMapping("/updateByPrimaryKey")
    @ResponseBody
    public int updateByPrimaryKey(HttpServletRequest request){
        HttpSession session = null;
        User user = (User) session.getAttribute("user");
        int value = zUserService.updateByPrimaryKey(user);
        if(value == 0){
            return 1;
        }
        return 0;
    }

}
































//    // 获取会话密钥（session_key）
//    String session_key=WO.getSession_key();
//    // 获取用户的唯一标识（openid）
//    String openid =WO.getOpenid();
//
////////////////// 2、对encryptedData加密数据进行AES解密 ////////////////
//        try {
//                String result = AesCbcUtil.decrypt(encryptedData, session_key, iv, "UTF-8");
//
//                if (null != result && result.length() > 0) {
//                map.put("status", 1);
//                map.put("msg", "解密成功");
//
//                assert user != null;
////                Map userInfo = new HashMap();
////                userInfo.put("openId",user.getOpenId());
////                userInfo.put("nickName",user.getNickName());
////                userInfo.put("gender",user.getGender());
////                userInfo.put("city",user.getCity());
////                userInfo.put("province",user.getProvince());
////                userInfo.put("country",user.getCountry());
////                userInfo.put("avatarUrl",user.getAvatarUrl());
////                map.put("userInfo", userInfo);
//                } else {
//                map.put("status", 0);
//                map.put("msg", "解密失败");
//                }
//                } catch (Exception e) {
//                e.printStackTrace();
//                }