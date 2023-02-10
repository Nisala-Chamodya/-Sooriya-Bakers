package lk.blacky.bakerymanagement.entity;

public class OrderDetailsEntity {
    private String orderID;
    private String productID;
    private int availability;
    private double unitPrice;

    public OrderDetailsEntity(String orderID, String productID, int availability, double unitPrice) {
        this.orderID = orderID;
        this.productID = productID;
        this.availability = availability;
        this.unitPrice = unitPrice;
    }

    public OrderDetailsEntity() {
    }


    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
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

    @Override
    public String toString() {
        return "OrderDetailsEntity{" +
                "orderID='" + orderID + '\'' +
                ", productID='" + productID + '\'' +
                ", availability=" + availability +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
