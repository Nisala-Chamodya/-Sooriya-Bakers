package lk.blacky.bakerymanagement.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.blacky.bakerymanagement.dao.SupplierDAOImpl;
import lk.blacky.bakerymanagement.dao.custom.impl.SupplierDAO;
import lk.blacky.bakerymanagement.model.SupplierModel;
import lk.blacky.bakerymanagement.to.Supplier;
import lk.blacky.bakerymanagement.util.Navigation;
import lk.blacky.bakerymanagement.util.Routes;

import java.io.IOException;
import java.sql.SQLException;

import static lk.blacky.bakerymanagement.util.Validator.*;

public class ManageSupplierDetailsFormController {

    public AnchorPane pane;
    public JFXTextField txtSupplierId;
    public JFXTextField txtName;
    public JFXTextField txtAddress;
    public JFXTextField txtTpNo;
    public JFXTextField txtEmail;

    // Dependancy Injection
    SupplierDAO supplierDAO=new SupplierDAOImpl();


    public void backImgClickOnAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.ADMINDASHBOARD,pane);
    }

    public void btnAddSupplierOnAction(ActionEvent actionEvent) {
        if (isSupplierIdMatcher(txtSupplierId.getText())) {
            if (isNameMatch(txtName.getText())){
                if (isNameMatch(txtAddress.getText())){
                    if (isAgeMatch(txtTpNo.getText())) {
                        if (isEmailMatch(txtEmail.getText())){


        String supplierId=txtSupplierId.getText();
        String name=txtName.getText();
        String address=txtAddress.getText();
        String tpNo=txtTpNo.getText();
        String eMail=txtEmail.getText();

        Supplier supplier=new Supplier(supplierId,name,address,tpNo,eMail);


                            boolean isAdded = supplierDAO.AddSupplier(supplier);
                            if (isAdded){
                                new Alert(Alert.AlertType.CONFIRMATION, "Supplier Added!").show();
                            }else {
                                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
                            }


                        }else {
                            new Alert(Alert.AlertType.ERROR, "Please Enter the Valid Email Address \n backy2002@gamil.com").show();
                            txtEmail.setStyle("-jfx-unfocus-color : red");
                        }
                }else {
                        new Alert(Alert.AlertType.ERROR, "Please Enter the Valid Number \n with 10 numbers").show();
                        txtTpNo.setStyle("-jfx-unfocus-color : red");
                    }
                }else {
                    new Alert(Alert.AlertType.ERROR, "Please check the Valid Address").show();
                    txtAddress.setStyle("-jfx-unfocus-color : red");
                }
        }else {
                new Alert(Alert.AlertType.ERROR, "Please check the Valid Name").show();
                txtName.setStyle("-jfx-unfocus-color : red");
            }

        }else {
            new Alert(Alert.AlertType.ERROR, "Please check the Valid Supplier_Id. \n(S-001) Like That").show();
            txtSupplierId.setStyle("-jfx-unfocus-color : red");
        }
    }

    public void btnSearchSupplierOnAction(ActionEvent actionEvent) {

        Supplier supplier= supplierDAO.searchSupplier(txtSupplierId.getText());
        if (supplier==null){
            new Alert(Alert.AlertType.INFORMATION,"Supplier Not Found").show();
        }else {


            txtName.setText(supplier.getName());
            txtAddress.setText(supplier.getAddress());
            txtTpNo.setText(supplier.getTpNo());
            txtEmail.setText(supplier.geteMail());
        }


    }

    public void btnClearSupplierOnAction(ActionEvent actionEvent) {
        txtSupplierId.clear();
        txtName.clear();
        txtAddress.clear();
        txtTpNo.clear();
        txtEmail.clear();
    }

    public void btnDeleteSupplierOnAction(ActionEvent actionEvent) {


        boolean isDeleted = supplierDAO.deleteSupplier(txtSupplierId.getText());
        if (isDeleted){
            new Alert(Alert.AlertType.INFORMATION,"Supplier  Deleted Successfully!").show();

        }else {

            new Alert(Alert.AlertType.WARNING, "Something happened!").show();
        }

    }

    public void btnUpdateSupplierOnAction(ActionEvent actionEvent) {

        if (isSupplierIdMatcher(txtSupplierId.getText())) {
            if (isNameMatch(txtName.getText())){
                if (isNameMatch(txtAddress.getText())){
                    if (isAgeMatch(txtTpNo.getText())) {
                        if (isEmailMatch(txtEmail.getText())){
        String supplierId=txtSupplierId.getText();
        String name=txtName.getText();
        String address=txtAddress.getText();
        String tpNo=txtTpNo.getText();
        String eMail=txtEmail.getText();

        Supplier supplier=new Supplier(supplierId,name,address,tpNo,eMail);

                            boolean isUpdated=  supplierDAO.updateSupplier(supplier);
                            if (isUpdated){
                                new Alert(Alert.AlertType.INFORMATION,"Supplier Updated Sucessfully").show();
                            }else {
                                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
                            }

                        }else {
                            new Alert(Alert.AlertType.ERROR, "Please Enter the Valid Email Address \n backy2002@gmil.com").show();
                            txtEmail.setStyle("-jfx-unfocus-color : red");
                        }
                    }else {
                        new Alert(Alert.AlertType.ERROR, "Please Enter the Valid Number \n with 10 numbers").show();
                        txtTpNo.setStyle("-jfx-unfocus-color : red");
                    }
                }else {
                    new Alert(Alert.AlertType.ERROR, "Please check the Valid Address").show();
                    txtAddress.setStyle("-jfx-unfocus-color : red");
                }
            }else {
                new Alert(Alert.AlertType.ERROR, "Please check the Valid Name").show();
                txtName.setStyle("-jfx-unfocus-color : red");
            }

        }else {
            new Alert(Alert.AlertType.ERROR, "Please check the Valid Supplier_Id. \n(S-001) Like That").show();
            txtSupplierId.setStyle("-jfx-unfocus-color : red");
        }


    }

    public void btnSupplierViewOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ADMINSUPPLIERVIEW,pane);
    }
}
