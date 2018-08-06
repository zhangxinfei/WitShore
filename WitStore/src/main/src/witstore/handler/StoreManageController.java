package witstore.handler;//package witstore.handler;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import witstore.domain.Material;
//import witstore.domain.WareHouse;
//import witstore.service.ProductService;
//import witstore.service.StoreManageService;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.List;
//import java.util.Map;
//
//@Controller
//public class StoreManageController {
//    private final StoreManageService storeManageService;
//    private final ProductService productService;
//    @Autowired
//    public StoreManageController(StoreManageService storeManageService,ProductService productService) {
//        this.storeManageService = storeManageService;
//        this.productService = productService;
//    }
//
//    //跳转至进货页面
//    @RequestMapping("toEnterStorePage")
//    public String toEnterStorePage(HttpServletRequest request){
//        int userId= (int) request.getSession().getAttribute("userId");
//        request.setAttribute("wareHouses",storeManageService.getWareHousesByUserId(userId));
//        return "enterStore";
//    }
//
//    //跳转至出库页面
//    @RequestMapping("toExitProduct")
//    public String toExitProduct(@RequestParam("prodId")int prodId,Map<String,Object> map){
//        map.put("product",productService.getProductInfoByProdId(prodId));
//        return "exitProduct";
//    }
//
//    //Ajax返回物料信息JSON
//    @ResponseBody
//    @RequestMapping("getMaterialsByWareHouseId")
//    public List<Material> getMaterialsByWareHouseId(@RequestParam("wareHouseId")int wareHouseId){
//        return storeManageService.getMaterialsByWareHouseId(wareHouseId);
//    }
//
//    //处理增加进货
//    @RequestMapping("addMaterialNum")
//    public String addMaterialNum(@RequestParam("wareHouseId")int wareHouseId,
//                                 @RequestParam("materialId")int[] materialIds,
//                                 @RequestParam("stock")int[] stocks,
//                                 @RequestParam("selfCost")double selfCost){
//        storeManageService.handEnterStore(wareHouseId,materialIds,stocks,selfCost);
//        return "allEnterTable";
//    }
//
//    //处理出库
//    @RequestMapping("handExitStore")
//    public String handExitStore(ExitTable exitTable,@RequestParam("materialId")int[] materialIds){
//        storeManageService.handExitStore(exitTable,materialIds);
//        return "allEnterTable";
//    }
//
//    //跳转至添加仓库
//    @RequestMapping("toAddWareHouse")
//    public String toAddWareHouse(){
//        return "addWareHouse";
//    }
//
//    //处理添加仓库
//    @RequestMapping("handAddWareHouse")
//    public String handAddWareHouse(HttpServletRequest request, WareHouse wareHouse){
//        int userId= (int) request.getSession().getAttribute("userId");
//        wareHouse.setUserId(userId);
//        storeManageService.insertWareHouse(wareHouse);
//        return "redirect:getMaterialsByUserId";
//    }
//}
//
////    @ResponseBody
////    @RequestMapping("getSessionKeyOropenid")
////    public void getSessionKeyOropenid(@RequestParam("code")String code){
////        Map<String,String> requestUrlParam = new HashMap<>();
////        requestUrlParam.put("appid","wxa778be6e9b8556de");
////        requestUrlParam.put("secret","192e2532c17a25bc64e43d4d91df6279"); //开发者设置中的appSecret
////        requestUrlParam.put("js_code", code); //小程序调用wx.login返回的code
////        requestUrlParam.put("grant_type","authorization_code"); //默认参数 authorization_code
////        System.out.println(Tools.sendPost("https://api.weixin.qq.com/sns/jscode2session",requestUrlParam));
////    }
////
////    @ResponseBody
////    @RequestMapping("testSession")
////    public String testSession(HttpServletRequest request){
////        HttpSession session=request.getSession();
////        session.setAttribute("userId","test");
////        return session.getId();
////    }
////
////    @ResponseBody
////    @RequestMapping("testSession2")
////    public void testSession2(HttpServletRequest request){
////        String sessionId=request.getHeader("sessionId");
////        System.out.println(sessionId);
////    }