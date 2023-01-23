package lk.blacky.bakerymanagement.view.tm;

import javafx.scene.control.Button;

public class SupplierTm {
    String supplierId;
    String name;
    String address;
    String tpNo;
    String email;
    Button btn;

    public SupplierTm() {
    }

    public SupplierTm(String supplierId, String name, String address, String tpNo, String email, Button btn) {
        this.supplierId = supplierId;
        this.name = name;
        this.address = address;
        this.tpNo = tpNo;
        this.email = email;
        this.btn = btn;
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

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
}
