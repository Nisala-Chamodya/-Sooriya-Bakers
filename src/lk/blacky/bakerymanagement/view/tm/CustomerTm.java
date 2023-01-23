package lk.blacky.bakerymanagement.view.tm;

import javafx.scene.control.Button;

public class CustomerTm {
    private String custId;
    private String name;
    private String nic;
    private String address;
    private String tpNo;
    private Button btn;

    public CustomerTm() {
    }

    public CustomerTm(String custId, String name, String nic, String address, String tpNo, Button btn) {
        this.custId = custId;
        this.name = name;
        this.nic = nic;
        this.address = address;
        this.tpNo = tpNo;
        this.btn = btn;
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

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
}
