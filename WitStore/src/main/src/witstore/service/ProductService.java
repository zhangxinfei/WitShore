package witstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import witstore.DAO.ProductDAO;
import witstore.domain.CompRelation;
import witstore.domain.Product;

import java.util.List;

@Service
public class ProductService {
    private final ProductDAO productDAO;
    @Autowired
    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    ////////////////////////////////////////////////////产品////////////////////////////////////////////////////
    //添加产品
    public void insertProduct(Product product){
        productDAO.insertProduct(product);
    }

    //删除产品
    public void deleteProduct(int prodId){
        //删除产品组成信息(级联)
        productDAO.deleteCompRelationByProdId(prodId);
        //删除产品信息
        productDAO.deleteProductByProdId(prodId);
    }

    //更新产品
    public void updateProduct(Product product){
        productDAO.updateProduct(product);
    }

    //查询产品详细信息
    public Product getProduct(int prodId){
        return productDAO.getProductByProdId(prodId);
    }

    //查询用户所有的产品
    public List<Product> getProductsByUserId(int userId){
        return productDAO.getProductsByUserId(userId);
    }

    ////////////////////////////////////////////////////产品组成////////////////////////////////////////////////////
    //添加产品物料组成
    public void insertCompRelation(CompRelation compRelation){
        productDAO.insertCompRelation(compRelation);
    }

    //更新产品物料组成信息
    public void updateCompRelation(CompRelation compRelation){
        productDAO.updateCompRelation(compRelation);
    }

    //删除产品组成信息
    public void deleteCompRelation(int compRelationId){
        productDAO.deleteCompRelation(compRelationId);
    }
}
