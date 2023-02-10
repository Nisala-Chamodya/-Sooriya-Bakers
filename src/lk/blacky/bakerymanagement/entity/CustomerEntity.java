package lk.blacky.bakerymanagement.entity;

public class CustomerEntity {
    private  String cust_Id;
    private  String name;
    private  String nic;
    private  String address;
    private String tpNo;

    public CustomerEntity() {
    }

    public CustomerEntity(String cust_Id, String name, String nic, String address, String tpNo) {
        this.cust_Id = cust_Id;
        this.name = name;
        this.nic = nic;
        this.address = address;
        this.tpNo = tpNo;
    }

    public String getCust_Id() {
        return cust_Id;
    }

    public void setCust_Id(String cust_Id) {
        this.cust_Id = cust_Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
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

    @Override
    public String toString() {
        return "CustomerEntity{" +
                "cust_Id='" + cust_Id + '\'' +
                ", name='" + name + '\'' +
                ", nic='" + nic + '\'' +
                ", address='" + address + '\'' +
                ", tpNo='" + tpNo + '\'' +
                '}';
    }
}
