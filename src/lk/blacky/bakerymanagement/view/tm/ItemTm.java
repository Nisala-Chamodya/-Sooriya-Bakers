package lk.blacky.bakerymanagement.view.tm;

import javafx.scene.control.Button;

public class ItemTm {
    private String itemId;
    private  String brand ;
    private String description;
    private int availability ;
    private Button btn;

    public ItemTm() {
    }

    public ItemTm(String itemId, String brand, String description, int availability, Button btn) {
        this.itemId = itemId;
        this.brand = brand;
        this.description = description;
        this.availability = availability;
        this.btn = btn;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
