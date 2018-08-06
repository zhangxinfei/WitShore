package witstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import witstore.DAO.MaterialDAO;
import witstore.domain.Material;
import witstore.domain.Type;
import witstore.domain.WareHouse;

import java.util.List;
import java.util.Map;


@Service
public class MaterialService {
    private final MaterialDAO materialDAO;
    @Autowired
    public MaterialService(MaterialDAO materialDAO) {
        this.materialDAO = materialDAO;
    }

    ////////////////////////////////////////////////////仓库////////////////////////////////////////////////////
    //添加仓库
    public void insertNewWarehouse(WareHouse wareHouse){
        materialDAO.insertNewWarehouse(wareHouse);
    }

    //删除仓库
    public void deleteWarehouse(int warehouseId){
        //删除原料
        materialDAO.deleteMaterialByWarehouseId(warehouseId);
        //删除仓库信息
        materialDAO.deleteWarehouseByWarehouseId(warehouseId);
    }

    //更新仓库信息
    public void updateWarehouse(WareHouse wareHouse){
        materialDAO.updateWarehouse(wareHouse);
    }

    //查询仓库详细信息
    public WareHouse getWarehouseDetail(int warehouseId){
        return materialDAO.getWarehouseDetail(warehouseId);
    }

    ////////////////////////////////////////////////////物料////////////////////////////////////////////////////
    //添加物料
    public void insertNewMaterial(Material material){
        materialDAO.insertNewMaterial(material);
    }

    //删除物料
    public void deleteMaterial(int matId){
        materialDAO.deleteMaterialByMaterialId(matId);
    }

    //更新物料
    public void updateMaterial(Material material){
        materialDAO.updateMaterial(material);
    }

    //查询物料详细信息
    public Material getMaterialDetail(int matId){
        return materialDAO.getMaterialDetail(matId);
    }

    //返回物料 仓库相应的数量
    public List<Map<Integer,Integer>> warehouse_MatCount(String matName, int userId){
        return materialDAO.warehouse_MatCount(matName,userId);
    }

    ////////////////////////////////////////////////////类别////////////////////////////////////////////////////
    //增加类别信息
    public void insertNewType(Type type){
        materialDAO.insertNewType(type);
    }

    //删除类别
    public void deleteType(int typeId){
        materialDAO.deleteTypeByTypeId(typeId);
    }

    //修改类别信息
    public void updateType(Type type){
        materialDAO.updateType(type);
    }

    //查询所有的类别信息
    public List<Type> getTypes(int userId){
        return materialDAO.getTypesByUserId(userId);
    }

    public List<Type> getTypes_MaterialsByUserId(int userId){
       return materialDAO.getTypes_MaterialsByUserId(userId);
    }
}