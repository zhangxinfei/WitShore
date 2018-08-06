package witstore.domain;

import java.util.Date;
import java.util.Map;

public class EnterTab {
    private int userId;
    private Date EnterDate;
    private String EnterNum;
    private int warehouseId;
    private Map<Integer,Integer> materials;
    private String remark;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getEnterDate() {
        return EnterDate;
    }

    public void setEnterDate(Date enterDate) {
        EnterDate = enterDate;
    }

    public String getEnterNum() {
        return EnterNum;
    }

    public void setEnterNum(String enterNum) {
        EnterNum = enterNum;
    }

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Map<Integer, Integer> getMaterials() {
        return materials;
    }

    public void setMaterials(Map<Integer, Integer> materials) {
        this.materials = materials;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "EnterTab{" +
                "userId=" + userId +
                ", EnterDate=" + EnterDate +
                ", EnterNum='" + EnterNum + '\'' +
                ", warehouseId=" + warehouseId +
                ", materials=" + materials +
                ", remark='" + remark + '\'' +
                '}';
    }
}
