package lk.blacky.bakerymanagement.to;

public class Stock {

    private String supplierId;
    private String itemId;
    private  String brand ;
    private int availability;

    public Stock() {
    }

    public Stock(String supplierId, String itemId, String brand, int availability) {
        this.supplierId = supplierId;
        this.itemId = itemId;
        this.brand = brand;
        this.availability = availability;
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
}
