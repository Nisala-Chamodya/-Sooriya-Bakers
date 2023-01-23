package lk.blacky.bakerymanagement.view.tm;

import javafx.scene.control.Button;

public class ProductTm {
    String productId;
    String productName;
    double price;
    String description;
    int availability;
    private Button btn;

    public ProductTm() {
    }

    public ProductTm(String productId, String productName, double price, String description, int availability, Button btn) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.availability = availability;
        this.btn = btn;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
