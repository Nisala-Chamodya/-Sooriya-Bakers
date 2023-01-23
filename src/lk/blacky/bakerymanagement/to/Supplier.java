package lk.blacky.bakerymanagement.to;

public class Supplier {
  String supplierId;
   String name;
      String address;
 String tpNo;
     String email;

    public Supplier() {
    }

    public Supplier(String supplierId, String name, String address, String tpNo, String eMail) {
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
}
