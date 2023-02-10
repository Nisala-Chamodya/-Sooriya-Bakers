package lk.blacky.bakerymanagement.entity;

import java.sql.Date;

public class CustomEntity {
    //Customer Entity
    private  String custId;
    private  String cName;
    private  String cNic;
    private  String cAddress;
    private String ctpNo;


    //Employee Entity
    private String empId;
    private String eName ;
    private String egender;
    private String edivision;
    private double esalary ;
    private String etpNo;
    private String eemail;
    private Date  edate;


    // item Entity
    private String itemId;
    private  String ibrand ;
    private String idescription;
    private int  iavailability ;

    //item Supplier Entity
    private String supplierID;
    private String itemID;
    private String brand;
    private  int availability;


    //order details
    private String orderID;
    private String productID;
    private int odavailability;
    private double unitPrice;


    ///order
    private String order_ID;
    private Date date;
    private double totalCost;
    private String CustomerID;


    //product

    private String productId;
    private  String productName;
    private  double price;
    private String description;
    private int p_availability;

    //recipe
    private String recipeId;
    private   String foodName;
    private   String r_description;


    //stock  entity
    private String ssupplierId;
    private String st_itemId;
    private  String st_brand ;
    private int st_availability;


    //supplier entities
    private String supplierId;
    private String name;
    private String address;
    private String tpNo;
    private String email;

    public CustomEntity() {
    }

    public CustomEntity(String custId, String cName, String cNic, String cAddress, String ctpNo, String empId, String eName, String egender, String edivision, double esalary, String etpNo, String eemail, Date edate, String itemId, String ibrand, String idescription, int iavailability, String supplierID, String itemID, String brand, int availability, String orderID, String productID, int odavailability, double unitPrice, String order_ID, Date date, double totalCost, String customerID, String productId, String productName, double price, String description, int p_availability, String recipeId, String foodName, String r_description, String ssupplierId, String st_itemId, String st_brand, int st_availability, String supplierId, String name, String address, String tpNo, String email) {
        this.custId = custId;
        this.cName = cName;
        this.cNic = cNic;
        this.cAddress = cAddress;
        this.ctpNo = ctpNo;
        this.empId = empId;
        this.eName = eName;
        this.egender = egender;
        this.edivision = edivision;
        this.esalary = esalary;
        this.etpNo = etpNo;
        this.eemail = eemail;
        this.edate = edate;
        this.itemId = itemId;
        this.ibrand = ibrand;
        this.idescription = idescription;
        this.iavailability = iavailability;
        this.supplierID = supplierID;
        this.itemID = itemID;
        this.brand = brand;
        this.availability = availability;
        this.orderID = orderID;
        this.productID = productID;
        this.odavailability = odavailability;
        this.unitPrice = unitPrice;
        this.order_ID = order_ID;
        this.date = date;
        this.totalCost = totalCost;
        CustomerID = customerID;
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.p_availability = p_availability;
        this.recipeId = recipeId;
        this.foodName = foodName;
        this.r_description = r_description;
        this.ssupplierId = ssupplierId;
        this.st_itemId = st_itemId;
        this.st_brand = st_brand;
        this.st_availability = st_availability;
        this.supplierId = supplierId;
        this.name = name;
        this.address = address;
        this.tpNo = tpNo;
        this.email = email;
    }


    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcNic() {
        return cNic;
    }

    public void setcNic(String cNic) {
        this.cNic = cNic;
    }

    public String getcAddress() {
        return cAddress;
    }

    public void setcAddress(String cAddress) {
        this.cAddress = cAddress;
    }

    public String getCtpNo() {
        return ctpNo;
    }

    public void setCtpNo(String ctpNo) {
        this.ctpNo = ctpNo;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getEgender() {
        return egender;
    }

    public void setEgender(String egender) {
        this.egender = egender;
    }

    public String getEdivision() {
        return edivision;
    }

    public void setEdivision(String edivision) {
        this.edivision = edivision;
    }

    public double getEsalary() {
        return esalary;
    }

    public void setEsalary(double esalary) {
        this.esalary = esalary;
    }

    public String getEtpNo() {
        return etpNo;
    }

    public void setEtpNo(String etpNo) {
        this.etpNo = etpNo;
    }

    public String getEemail() {
        return eemail;
    }

    public void setEemail(String eemail) {
        this.eemail = eemail;
    }

    public Date getEdate() {
        return edate;
    }

    public void setEdate(Date edate) {
        this.edate = edate;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getIbrand() {
        return ibrand;
    }

    public void setIbrand(String ibrand) {
        this.ibrand = ibrand;
    }

    public String getIdescription() {
        return idescription;
    }

    public void setIdescription(String idescription) {
        this.idescription = idescription;
    }

    public int getIavailability() {
        return iavailability;
    }

    public void setIavailability(int iavailability) {
        this.iavailability = iavailability;
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

    public int getOdavailability() {
        return odavailability;
    }

    public void setOdavailability(int odavailability) {
        this.odavailability = odavailability;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getOrder_ID() {
        return order_ID;
    }

    public void setOrder_ID(String order_ID) {
        this.order_ID = order_ID;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getP_availability() {
        return p_availability;
    }

    public void setP_availability(int p_availability) {
        this.p_availability = p_availability;
    }

    public String getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(String recipeId) {
        this.recipeId = recipeId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getR_description() {
        return r_description;
    }

    public void setR_description(String r_description) {
        this.r_description = r_description;
    }

    public String getSsupplierId() {
        return ssupplierId;
    }

    public void setSsupplierId(String ssupplierId) {
        this.ssupplierId = ssupplierId;
    }

    public String getSt_itemId() {
        return st_itemId;
    }

    public void setSt_itemId(String st_itemId) {
        this.st_itemId = st_itemId;
    }

    public String getSt_brand() {
        return st_brand;
    }

    public void setSt_brand(String st_brand) {
        this.st_brand = st_brand;
    }

    public int getSt_availability() {
        return st_availability;
    }

    public void setSt_availability(int st_availability) {
        this.st_availability = st_availability;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTpNo() {
        return tpNo;
    }

    public void setTpNo(String tpNo) {
        this.tpNo = tpNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "CustomEntity{" +
                "custId='" + custId + '\'' +
                ", cName='" + cName + '\'' +
                ", cNic='" + cNic + '\'' +
                ", cAddress='" + cAddress + '\'' +
                ", ctpNo='" + ctpNo + '\'' +
                ", empId='" + empId + '\'' +
                ", eName='" + eName + '\'' +
                ", egender='" + egender + '\'' +
                ", edivision='" + edivision + '\'' +
                ", esalary=" + esalary +
                ", etpNo='" + etpNo + '\'' +
                ", eemail='" + eemail + '\'' +
                ", edate=" + edate +
                ", itemId='" + itemId + '\'' +
                ", ibrand='" + ibrand + '\'' +
                ", idescription='" + idescription + '\'' +
                ", iavailability=" + iavailability +
                ", supplierID='" + supplierID + '\'' +
                ", itemID='" + itemID + '\'' +
                ", brand='" + brand + '\'' +
                ", availability=" + availability +
                ", orderID='" + orderID + '\'' +
                ", productID='" + productID + '\'' +
                ", odavailability=" + odavailability +
                ", unitPrice=" + unitPrice +
                ", order_ID='" + order_ID + '\'' +
                ", date=" + date +
                ", totalCost=" + totalCost +
                ", CustomerID='" + CustomerID + '\'' +
                ", productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", p_availability=" + p_availability +
                ", recipeId='" + recipeId + '\'' +
                ", foodName='" + foodName + '\'' +
                ", r_description='" + r_description + '\'' +
                ", ssupplierId='" + ssupplierId + '\'' +
                ", st_itemId='" + st_itemId + '\'' +
                ", st_brand='" + st_brand + '\'' +
                ", st_availability=" + st_availability +
                ", supplierId='" + supplierId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", tpNo='" + tpNo + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
