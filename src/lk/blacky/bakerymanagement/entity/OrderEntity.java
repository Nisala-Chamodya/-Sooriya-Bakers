package lk.blacky.bakerymanagement.entity;

import java.sql.Date;

public class OrderEntity {
    private String orderID;
    private String date;
    private double totalCost;
    private String CustomerID;

    public OrderEntity() {
    }

    public OrderEntity(String orderID, String date, double totalCost, String customerID) {
        this.orderID = orderID;
        this.date = date;
        this.totalCost = totalCost;
        CustomerID = customerID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        CustomerID = customerID;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "orderID='" + orderID + '\'' +
                ", date='" + date + '\'' +
                ", totalCost=" + totalCost +
                ", CustomerID='" + CustomerID + '\'' +
                '}';
    }
}
