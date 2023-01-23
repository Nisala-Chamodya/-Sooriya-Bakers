package lk.blacky.bakerymanagement.view.tm;

public class MonthlyTm {
    private String orderId;
    private String productId;
    private int availability;
    private double unitPrice;

    public MonthlyTm() {
    }

    public MonthlyTm(String orderId, String productId, int availability, double unitPrice) {
        this.orderId = orderId;
        this.productId = productId;
        this.availability = availability;
        this.unitPrice = unitPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
