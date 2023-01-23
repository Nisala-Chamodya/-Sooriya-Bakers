package lk.blacky.bakerymanagement.view.tm;

import javafx.scene.control.Button;

public class StockTm {
    private String supplierId;
    private String itemId;
    private  String brand ;
    private int availability;
    private Button btn;

    public StockTm() {
    }

    public StockTm(String supplierId, String itemId, String brand, int availability, Button btn) {
        this.supplierId = supplierId;
        this.itemId = itemId;
        this.brand = brand;
        this.availability = availability;
        this.btn = btn;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
}
