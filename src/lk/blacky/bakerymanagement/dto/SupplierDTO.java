package lk.blacky.bakerymanagement.dto;

public class SupplierDTO {
     private String supplierId;
    private String name;
    private String address;
    private String tpNo;
    private String email;

    public SupplierDTO() {
    }

    public SupplierDTO(String supplierId, String name, String address, String tpNo, String eMail) {
        this.supplierId = supplierId;
        this.name = name;
        this.address = address;
        this.tpNo = tpNo;
        this.email = eMail;
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

    public String geteMail() {
        return email;
    }

    public void seteMail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "SupplierDTO{" +
                "supplierId='" + supplierId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", tpNo='" + tpNo + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
