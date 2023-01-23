package lk.blacky.bakerymanagement.model;

public class ProductDetails {
    private String productId;
    private double unitPrice;
    private int availability;

    public ProductDetails() {
    }

    public ProductDetails(String productId, double unitPrice, int availability) {
        this.productId = productId;
        this.unitPrice = unitPrice;
        this.availability = availability;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }
}
