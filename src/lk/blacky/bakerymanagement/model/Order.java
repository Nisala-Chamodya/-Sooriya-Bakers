package lk.blacky.bakerymanagement.model;

import java.util.ArrayList;
import java.util.Date;

public class Order {
    private String orderId;
    private Date date;
    private double totalCost;
    private String customer;
    private ArrayList<ProductDetails> productDetails;

    public Order(String orderId, Date date, double totalCost, String customer, ArrayList<ProductDetails> productDetails) {
        this.orderId = orderId;
        this.date = date;
        this.totalCost = totalCost;
        this.customer = customer;
        this.productDetails = productDetails;
    }

    public Order() {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public ArrayList<ProductDetails> getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(ArrayList<ProductDetails> productDetails) {
        this.productDetails = productDetails;
    }
}
