package lk.blacky.bakerymanagement.dto;

public class ItemSupplierDTO {
    private String supplierID;
    private String itemID;
    private String brand;
    private  int availability;

    public ItemSupplierDTO() {
    }

    public ItemSupplierDTO(String supplierID, String itemID, String brand, int availability) {
        this.supplierID = supplierID;
        this.itemID = itemID;
        this.brand = brand;
        this.availability = availability;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
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

    @Override
    public String toString() {
        return "ItemSupplierDTO{" +
                "supplierID='" + supplierID + '\'' +
                ", itemID='" + itemID + '\'' +
                ", brand='" + brand + '\'' +
                ", availability=" + availability +
                '}';
    }
}

