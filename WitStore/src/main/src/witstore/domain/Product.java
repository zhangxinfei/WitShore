package witstore.domain;


import java.util.List;

public class Product {
    private int prodId;
    private int warehouseId;
    private int userId;
    private String prodName;
    private double prodPrice;
    private int isUsing;
    private List<CompRelation> compRelations;

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public double getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(double prodPrice) {
        this.prodPrice = prodPrice;
    }

    public int getIsUsing() {
        return isUsing;
    }

    public void setIsUsing(int isUsing) {
        this.isUsing = isUsing;
    }

    public List<CompRelation> getCompRelations() {
        return compRelations;
    }

    public void setCompRelations(List<CompRelation> compRelations) {
        this.compRelations = compRelations;
    }

    @Override
    public String toString() {
        return "Product{" +
                "prodId=" + prodId +
                ", warehouseId=" + warehouseId +
                ", userId=" + userId +
                ", prodName='" + prodName + '\'' +
                ", prodPrice=" + prodPrice +
                ", isUsing=" + isUsing +
                ", compRelations=" + compRelations +
                '}';
    }
}
