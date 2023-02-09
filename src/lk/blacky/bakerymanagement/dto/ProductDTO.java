package lk.blacky.bakerymanagement.dto;

public class ProductDTO {
    private String productId;
    private  String productName;
    private  String price;
    private String description;
    private String availability;

    public ProductDTO() {
    }

    public ProductDTO(String productId, String productName, String price, String description, String availability) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.availability = availability;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", availability=" + availability +
                '}';
    }
}
