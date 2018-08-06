package witstore.DAO;

import org.springframework.stereotype.Repository;
import witstore.domain.CompRelation;
import witstore.domain.Product;
import witstore.domain.Type;

import java.util.List;

@Repository
public interface ProductDAO {
    ////////////////////////////////////////////////////产品////////////////////////////////////////////////////
    //通过产品ID获取产品信息
    Product getProductByProdId(int prodId);
    //通过产品Id获取所有组成原材料类别(分步查询 getProductByProdId)
    List<CompRelation> getCompRelationsByProdId_Sept(int prodId);
    //通过类别ID获取所有的类别信息(分步查询 getProdRelationsSeptByProdId)
    Type getTypeByTypeId_Sept(int typeId);

    //通过产品ID更新产品信息
    void updateProduct(Product product);

    //添加产品信息
    void insertProduct(Product product);

    //通过产品ID删除产品
    void deleteProductByProdId(int prodId);

    //获取某一用户的所有产品
    List<Product> getProductsByUserId(int userId);

    ////////////////////////////////////////////////////产品组成////////////////////////////////////////////////////
    //更新产品组成信息
    void updateCompRelation(CompRelation compRelation);
//
//    //插入产品组成信息
    void insertCompRelation(CompRelation compRelations);
//
//    //删除产品组成信息
    void deleteCompRelation(int compRelationId);

    //删除产品组成信息(级联)
    void deleteCompRelationByProdId(int prodId);

}
