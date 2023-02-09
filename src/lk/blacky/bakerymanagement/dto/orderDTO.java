package lk.blacky.bakerymanagement.dto;

import java.sql.Date;

public class orderDTO {
    private String orderID;
    private Date date;
    private double totalCost;
    private String CustomerID;

    public orderDTO() {
    }

    public orderDTO(String orderID, Date date, double totalCost, String customerID) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
        return "orderDTO{" +
                "orderID='" + orderID + '\'' +
                ", date=" + date +
                ", totalCost=" + totalCost +
                ", CustomerID='" + CustomerID + '\'' +
                '}';
    }
}
