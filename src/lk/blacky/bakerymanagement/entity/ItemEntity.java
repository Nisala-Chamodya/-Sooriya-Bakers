package lk.blacky.bakerymanagement.entity;

public class ItemEntity {

    private String itemId;
    private  String brand ;
    private String description;
    private int availability ;

    public ItemEntity() {
    }

    public ItemEntity(String itemId, String brand, String description, int availability) {
        this.itemId = itemId;
        this.brand = brand;
        this.description = description;
        this.availability = availability;
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

    @Override
    public String toString() {
        return "ItemEntity{" +
                "itemId='" + itemId + '\'' +
                ", brand='" + brand + '\'' +
                ", description='" + description + '\'' +
                ", availability=" + availability +
                '}';
    }
}
