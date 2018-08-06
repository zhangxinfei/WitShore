package witstore.DAO;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import witstore.domain.*;
import java.util.List;
import java.util.Map;


@Repository
public interface MaterialDAO{

    ////////////////////////////////////////////////////仓库////////////////////////////////////////////////////
    //添加新仓库
    void insertNewWarehouse(WareHouse wareHouse);

    void deleteWarehouseByWarehouseId(int warehouseId);

    //更新仓库信息
    void updateWarehouse(WareHouse wareHouse);

    //查询仓库基本信息(resultType为WareHouse对象,不需要List<Material> materials)
    WareHouse getWarehouseDetail(int warehouseId);

    ////////////////////////////////////////////////////物料////////////////////////////////////////////////////
    //添加物料(物料名称,库存数量,进价,图片url)
    void insertNewMaterial(Material material);

    //通过物料ID删除原材料(修改物料的isUsing值为false)
    void deleteMaterialByMaterialId(int matId);

    /**
     * 删除仓库级联删除 原料(批量更新isUsing属性)
     *
     * @param warehouseId  仓库id
     */
    void deleteMaterialByWarehouseId(int warehouseId);

    //更新物料信息(修改物料名称,类别,图片,进价,库存数)
    void updateMaterial(Material material);

    //通过物料ID获取物料信息
    Material getMaterialDetail(int matId);

    //返回物料仓库对应数量
    List<Map<Integer,Integer>> warehouse_MatCount(@Param("matName")String matName,@Param("userId")int userId);
//
//
//    //增加物料数量(处理进货)    有一个印象是参数可以设置为一个map
//    void addMaterialNum(@Param("materialId") int materialId, @Param("amount") int amount);
//
//    //更新物料库存数(处理出货)
//    void updateMaterialNum(@Param("materialId") int materialId, @Param("prodId") int prodId);

    ////////////////////////////////////////////////////类别////////////////////////////////////////////////////
    //增加类别信息(返回类别主键Id值)
    int insertNewType(Type type);

    //删除类别
    void deleteTypeByTypeId(int typeId);

    //更新类别信息
    void updateType(Type type);

    //获取所有物料信息,按类别分类
    List<Type> getTypes_MaterialsByUserId(int userId);

    Material getMaterialsByTypeId_Sept(int typeId);

    //获取用户所有的类别信息
    List<Type> getTypesByUserId(int userId);
}
