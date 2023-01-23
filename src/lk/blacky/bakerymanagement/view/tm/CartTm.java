package lk.blacky.bakerymanagement.view.tm;

import javafx.scene.control.Button;

public class CartTm {
  private   String productId;
    private   String name;
    private double price;
    private String description;
    private int qty;
    private double total;
    private Button btn;

    public CartTm() {
    }

    public CartTm(String productId, String name, double price, String description, int qty, double total, Button btn) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.description = description;
        this.qty = qty;
        this.total = total;
        this.btn = btn;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
}
