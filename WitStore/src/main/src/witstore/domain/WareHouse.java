package witstore.domain;

import java.util.List;

public class WareHouse {
    private int warehouseId;
    private int userId;
    private String warehouseName;
    private double saleVolume;
    private String imgUrl;
    private String country;
    private String province;
    private String destrict;
    private String city;
    private String detailAdd;
    private List<Product> products;
    private int isUsing;

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

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public double getSaleVolume() {
        return saleVolume;
    }

    public void setSaleVolume(double saleVolume) {
        this.saleVolume = saleVolume;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDestrict() {
        return destrict;
    }

    public void setDestrict(String destrict) {
        this.destrict = destrict;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDetailAdd() {
        return detailAdd;
    }

    public void setDetailAdd(String detailAdd) {
        this.detailAdd = detailAdd;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getIsUsing() {
        return isUsing;
    }

    public void setIsUsing(int isUsing) {
        this.isUsing = isUsing;
    }

    @Override
    public String toString() {
        return "WareHouse{" +
                "warehouseId=" + warehouseId +
                ", userId=" + userId +
                ", warehouseName='" + warehouseName + '\'' +
                ", saleVolume=" + saleVolume +
                ", imgUrl='" + imgUrl + '\'' +
                ", country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", destrict='" + destrict + '\'' +
                ", city='" + city + '\'' +
                ", detailAdd='" + detailAdd + '\'' +
                ", products=" + products +
                ", isUsing=" + isUsing +
                '}';
    }
}
