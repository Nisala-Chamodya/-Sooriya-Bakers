package lk.blacky.bakerymanagement.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.blacky.bakerymanagement.dao.CustomerDAOImpl;
import lk.blacky.bakerymanagement.dao.custom.impl.CashierDAO;
import lk.blacky.bakerymanagement.dao.custom.impl.CustomerDAO;
import lk.blacky.bakerymanagement.to.Customer;
import lk.blacky.bakerymanagement.util.Navigation;
import lk.blacky.bakerymanagement.util.Routes;

import java.io.IOException;
import java.sql.SQLException;

import static lk.blacky.bakerymanagement.util.Validator.*;

public class CashierManageCustomerFormController {
    public AnchorPane pane;
    public JFXTextField txtCustId;
    public JFXTextField txtName;
    public JFXTextField txtNic;
    public JFXTextField txtAddress;
    public JFXTextField txtTpNo;


//Dipendancy Injection
    CustomerDAO customerDAO=new CustomerDAOImpl();

    public void backImgOnClickAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.CASHIERDASHBOARD,pane);
    }

    public void btnAddCustomerOnAction(ActionEvent actionEvent) {

        if (isIdMatcher(txtCustId.getText())) {
            if (isNameMatch(txtName.getText())) {
                if (isNicMatcher(txtNic.getText())){
                    if (isNameMatch(txtAddress.getText())){
                        if (isAgeMatch(txtTpNo.getText())){



        String custId = txtCustId.getText();
        String name = txtName.getText();
        String nic = txtNic.getText();
        String address = txtAddress.getText();
        String tpNo = txtTpNo.getText();

        Customer customer = new Customer(custId, name, nic, address, tpNo);
                            boolean isAdded = customerDAO.AddCustomer(customer);
                            if (isAdded) {
                                new Alert(Alert.AlertType.CONFIRMATION, "Customer Added!").show();
                            } else {
                                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
                            }
                        }else {
                            new Alert(Alert.AlertType.ERROR, "Pleace Insert Valid Te-No").show();
                            txtTpNo.setStyle("-jfx-unfocus-color : red");
                        }

                    }else {
                        new Alert(Alert.AlertType.ERROR, "Pleace Insert Valid Address").show();
                        txtAddress.setStyle("-jfx-unfocus-color : red");
                    }
                }else {
                    new Alert(Alert.AlertType.ERROR, "Pleace Insert Valid NIC").show();
                    txtNic.setStyle("-jfx-unfocus-color : red");
                }

            }else {
                new Alert(Alert.AlertType.ERROR, "Pleace Insert Valid Name").show();
                txtName.setStyle("-jfx-unfocus-color : red");
            }
        } else {
            new Alert(Alert.AlertType.ERROR, "Please check the Valid Cust_Id. (C-001) Like That").show();
            txtCustId.setStyle("-jfx-unfocus-color : red");
        }



    }

    public void btnClearOnAction(ActionEvent actionEvent) {


        txtCustId.clear();
        txtName.clear();
        txtNic.clear();
        txtAddress.clear();
        txtTpNo.clear();

    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        if (isIdMatcher(txtCustId.getText())) {
            if (isNameMatch(txtName.getText())) {
                if (isNicMatcher(txtNic.getText())){
                    if (isNameMatch(txtAddress.getText())){
                        if (isAgeMatch(txtTpNo.getText())){


                            String custId=txtCustId.getText();
                            String name=txtName.getText();
                            String nic=txtNic.getText();
                            String address=txtAddress.getText();
                            String tpNo=txtTpNo.getText();

                            Customer customer=new Customer(custId,name,nic,address,tpNo);
                            boolean isUpdated=  customerDAO.updateCustomer(customer);
                            if (isUpdated){
                                new Alert(Alert.AlertType.INFORMATION,"Customer Updated Sucessfully").show();
                            }else {
                                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
                            }


                        }else {
                            new Alert(Alert.AlertType.ERROR, "Pleace Insert Valid Te-No").show();
                            txtTpNo.setStyle("-jfx-unfocus-color : red");
                        }
                    }else {
                        new Alert(Alert.AlertType.ERROR, "Pleace Insert Valid Address").show();
                        txtAddress.setStyle("-jfx-unfocus-color : red");
                    }

                }else {
                    new Alert(Alert.AlertType.ERROR, "Pleace Insert Valid NIC").show();
                    txtNic.setStyle("-jfx-unfocus-color : red");

                }

            }else {
                new Alert(Alert.AlertType.ERROR, "Pleace Insert Valid Name").show();
                txtName.setStyle("-jfx-unfocus-color : red");
            }
        }else {
            new Alert(Alert.AlertType.ERROR, "Please check the Valid Cust_Id. (C-001) Like That").show();
            txtCustId.setStyle("-jfx-unfocus-color : red");
        }

    }

    public void btnSearchOnClickAction(ActionEvent actionEvent) {


        Customer customer= customerDAO.searchCustomer(txtCustId.getText());
        if (customer==null){
            new Alert(Alert.AlertType.INFORMATION,"Customer Not Found").show();
        }else {
            txtName.setText(customer.getName());
            txtNic.setText(customer.getNic());
            txtAddress.setText(customer.getAddress());
            txtTpNo.setText(customer.getTpNo());

        }
    }

    public void btnDeleteOnClickAction(ActionEvent actionEvent) {


        boolean isDeleted=   customerDAO.deleteCustomer(txtCustId.getText());
        if (isDeleted){
            new Alert(Alert.AlertType.INFORMATION,"Customer  Deleted Successfully!").show();

        }else {
            new Alert(Alert.AlertType.WARNING, "Something happened!").show();
        }
    }

    public void btnViewOnClickAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.CASHIERVIEWCUSTOMER,pane);
    }
}
