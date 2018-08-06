package witstore.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import witstore.domain.CompRelation;
import witstore.domain.Product;
import witstore.service.ProductService;

import java.util.List;


@Controller
public class ProductController {

    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    ////////////////////////////////////////////////////产品////////////////////////////////////////////////////

    /**
     *
     * @param product 产品信息
     */
    public void insertProduct(Product product){
        productService.insertProduct(product);
    }

    public void deleteProduct(int prodId){
        productService.deleteProduct(prodId);
    }

    public void updateProduct(Product product){
        productService.updateProduct(product);
    }

    public Product getProduct(int prodId){
        return productService.getProduct(prodId);
    }

    public List<Product> getProductsByUserId(int userId){
       return productService.getProductsByUserId(userId);
    }

    ////////////////////////////////////////////////////产品组成////////////////////////////////////////////////////
    public void insertCompRelation(CompRelation compRelation){
        productService.insertCompRelation(compRelation);
    }

    public void updateCompRelation(CompRelation compRelation){
        productService.updateCompRelation(compRelation);
    }

    public void deleteCompRelation(int compRelationId){
        productService.deleteCompRelation(compRelationId);
    }
}
