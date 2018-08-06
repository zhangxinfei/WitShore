package witstore.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import witstore.Tools.upLoadImg;
import witstore.domain.Material;
import witstore.domain.Type;
import witstore.domain.WareHouse;
import witstore.service.MaterialService;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;


@Controller
public class MaterialController{
    private final MaterialService materialService;
    @Autowired
    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    /**
     * 获取仓库详细信息
     * @param warehouseId  仓库ID
     * @return 仓库详细信息
     */
    @ResponseBody
    @RequestMapping("getWarehouseDetail")
    public WareHouse getWarehouseDetail(int warehouseId){
        System.out.println("getWarehouseDetail"+warehouseId);
        return materialService.getWarehouseDetail(warehouseId);
    }

    /**
     *  获取物料详细信息
     * @param matId 物料ID
     * @return 物料详细信息
     */
    @ResponseBody
    @RequestMapping("getMaterialDetail")
    public Material getMaterialDetail(int matId){
        System.out.println("getMaterialDetail"+matId);
        return materialService.getMaterialDetail(matId);
    }

    /**
     *  获取用户的所有类别
     * @param userId 用户ID
     * @return   类别集合
     */
    @ResponseBody
    @RequestMapping("getTypes")
    public List<Type> getTypes(int userId){
        System.out.println("getTypes"+userId);
        return materialService.getTypes(userId);
    }

    /**
     *  删除仓库
     * @param warehouseId 仓库ID
     */
    @ResponseBody
    @RequestMapping("deleteWarehouse")
    public void deleteWarehouse(int warehouseId){
        System.out.println("warehouseId"+warehouseId);
        materialService.deleteWarehouse(warehouseId);
    }

    /**
     * 删除物料
     * @param matId 物料ID
     */
    @ResponseBody
    @RequestMapping("deleteMaterial")
    public void deleteMaterial(int matId){
        System.out.println("deleteMaterial"+matId);
        materialService.deleteMaterial(matId);
    }

    /**
     *  删除类别
     * @param typeId 类别ID
     */
    @ResponseBody
    @RequestMapping("deleteType")
    public void deleteType(int typeId){
        System.out.println("deleteType"+typeId);
        materialService.deleteType(typeId);
    }

    /**
     *  更新仓库信息
     * @param request HttpServletRequest
     * @param file 仓库图片
     * @param wareHouse 仓库基本信息
     */
    @ResponseBody
    @RequestMapping("updateWarehouse")
    public void updateWarehouse(HttpServletRequest request,@RequestParam(value = "file", required = false) MultipartFile file,WareHouse wareHouse){
        String realPath = request.getSession().getServletContext().getRealPath("/");//图片URL
        try {
            String ImgUrl=upLoadImg.upload(file,realPath);
            wareHouse.setImgUrl(ImgUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("updateWarehouse::"+wareHouse);
        materialService.updateWarehouse(wareHouse);
    }

    /**
     * 更新物料信息
     * @param request HttpServletRequest
     * @param file  物料图片
     * @param material 物料基本信息
     */
    @ResponseBody
    @RequestMapping("updateMaterial")
    public void updateMaterial(HttpServletRequest request,@RequestParam(value = "file", required = false) MultipartFile file,Material material){
        String realPath = request.getSession().getServletContext().getRealPath("/");//图片URL
        try {
            String ImgUrl=upLoadImg.upload(file,realPath);
            material.setMatImgUrl(ImgUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("updateMaterial::"+material);
        materialService.updateMaterial(material);
    }

    /**
     * 更新类别信息
     * @param type 类别
     */
    @ResponseBody
    @RequestMapping("updateType")
    public void updateType(Type type){
        System.out.println("updateType::"+type);
        materialService.updateType(type);
    }

    /**
     * 添加仓库
     * @param request HttpServletRequest
     * @param file 仓库图片
     * @param wareHouse 仓库基本信息
     */
    @ResponseBody
    @RequestMapping("insertWarehouse")
    public void insertWarehouse(HttpServletRequest request,@RequestParam(value = "file", required = false) MultipartFile file,WareHouse wareHouse){
        String realPath = request.getSession().getServletContext().getRealPath("/");//图片URL
        try {
            String ImgUrl=upLoadImg.upload(file,realPath);
            wareHouse.setImgUrl(ImgUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("insertWarehouse::"+wareHouse);
        materialService.insertNewWarehouse(wareHouse);
    }

    /**
     * 添加类别
     * @param type  类别信息
     */
    @ResponseBody
    @RequestMapping("insertType")
    public void insertType(Type type){
        System.out.println("insertType::"+type);
        materialService.insertNewType(type);
    }

    /**
     * 添加物料信息
     * @param request HttpServletRequest
     * @param file  物料图片
     * @param material 物料基本信息
     */
    @ResponseBody
    @RequestMapping("insertMaterial")
    public void insertMaterial(HttpServletRequest request,@RequestParam(value = "file", required = false) MultipartFile file,Material material){
        //图片URL
        String realPath = request.getSession().getServletContext().getRealPath("/");
        try {
            String matImgUrl=upLoadImg.upload(file,realPath);
            material.setMatImgUrl(matImgUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //插入新物料
        System.out.println(material);
        materialService.insertNewMaterial(material);
    }

    /**
     *  获取用户所有物料
     * @param userId 用户ID
     * @return 物料集合
     */
    @ResponseBody
    @RequestMapping("getMaterials")
    public List<Type> getTypes_MaterialsByUserId(int userId){
        return materialService.getTypes_MaterialsByUserId(userId);
    }

    /**
     *  获取 某一物料 仓库存量 分仓库
     * @param matName 物料名称
     * @param userId 用户Id
     * @return 集合
     */
    @ResponseBody
    @RequestMapping("getMatCountClassify")
    public List<Map<Integer,Integer>> getMatCountClassify(String matName,int userId){
        return materialService.warehouse_MatCount(matName,userId);
    }
}