package lk.blacky.bakerymanagement.dto;

public class CustomerDTO {

  private  String custId;
    private  String name;
    private  String nic;
    private  String address;
    private String tpNo;

    public CustomerDTO() {
    }

    public CustomerDTO(String custId, String name, String nic, String address, String tpNo) {
        this.custId = custId;
        this.name = name;
        this.nic = nic;
        this.address = address;
        this.tpNo = tpNo;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
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
        return "Customer{" +
                "custId='" + custId + '\'' +
                ", name='" + name + '\'' +
                ", nic='" + nic + '\'' +
                ", address='" + address + '\'' +
                ", tpNo='" + tpNo + '\'' +
                '}';
    }
}
