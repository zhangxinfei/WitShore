package witstore.domain;

public class Material {
    private int matId;
    private int typeId;
    private int userId;
    private int warehouseId;
    private String matName;
    private int amount;
    private double purchPrice;
    private String matImgUrl;
    private int isUsing;

    public String getMatImgUrl() {
        return matImgUrl;
    }

    public void setMatImgUrl(String matImgUrl) {
        this.matImgUrl = matImgUrl;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMatId() {
        return matId;
    }

    public void setMatId(int matId) {
        this.matId = matId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getMatName() {
        return matName;
    }

    public void setMatName(String matName) {
        this.matName = matName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPurchPrice() {
        return purchPrice;
    }

    public void setPurchPrice(double purchPrice) {
        this.purchPrice = purchPrice;
    }

    public int getIsUsing() {
        return isUsing;
    }

    public void setIsUsing(int isUsing) {
        this.isUsing = isUsing;
    }

    @Override
    public String toString() {
        return "Material{" +
                "matId=" + matId +
                ", typeId=" + typeId +
                ", userId=" + userId +
                ", warehouseId=" + warehouseId +
                ", matName='" + matName + '\'' +
                ", amount=" + amount +
                ", purchPrice=" + purchPrice +
                ", matImgUrl='" + matImgUrl + '\'' +
                ", isUsing=" + isUsing +
                '}';
    }
}
