

        package lk.blacky.bakerymanagement.controller;

        import com.jfoenix.controls.JFXTextField;
        import javafx.event.ActionEvent;
        import javafx.scene.control.Alert;
        import javafx.scene.input.MouseEvent;
        import javafx.scene.layout.AnchorPane;
        import lk.blacky.bakerymanagement.dao.CustomerDAOImpl;
        import lk.blacky.bakerymanagement.dao.custom.impl.CRUDDAO;
        import lk.blacky.bakerymanagement.dao.custom.impl.CustomerDAO;
        import lk.blacky.bakerymanagement.to.Customer;
        import lk.blacky.bakerymanagement.util.Navigation;
        import lk.blacky.bakerymanagement.util.Routes;

        import java.io.IOException;
        import java.sql.SQLException;
        import static lk.blacky.bakerymanagement.util.Validator.*;

public class ManageCustomerFormController {
    public AnchorPane pane;
    public JFXTextField txtCustId;
    public JFXTextField txtName;
    public JFXTextField txtNic;
    public JFXTextField txtAddress;
    public JFXTextField txtTpNo;
    //Dipendancy Injection
      CRUDDAO customerDAO=new CustomerDAOImpl() ;

        public void backImgOnClickAction(MouseEvent mouseEvent) throws IOException {
            Navigation.navigate(Routes.ADMINDASHBOARD, pane);
        }

        public void btnAddCustomerOnAction(ActionEvent actionEvent) {
            if (isIdMatcher(txtCustId.getText())) {
                if (isNameMatch(txtName.getText())) {
                    if (isNicMatcher(txtNic.getText())) {
                        if (isNameMatch(txtAddress.getText())) {
                            if (isAgeMatch(txtTpNo.getText())) {


                                String custId = txtCustId.getText();
                                String name = txtName.getText();
                                String nic = txtNic.getText();
                                String address = txtAddress.getText();
                                String tpNo = txtTpNo.getText();

                                Customer customer = new Customer(custId, name, nic, address, tpNo);


                                boolean isAdded = customerDAO.add(customer);
                                if (isAdded) {
                                    new Alert(Alert.AlertType.CONFIRMATION, "Customer Added!").show();
                                } else {
                                    new Alert(Alert.AlertType.WARNING, "Something happened!").show();
                                }

                            } else {
                                new Alert(Alert.AlertType.ERROR, "Pleace Insert Valid Te-No").show();
                                txtTpNo.setStyle("-jfx-unfocus-color : red");
                            }

                        } else {
                            new Alert(Alert.AlertType.ERROR, "Pleace Insert Valid Address").show();
                            txtAddress.setStyle("-jfx-unfocus-color : red");
                        }
                    } else {
                        new Alert(Alert.AlertType.ERROR, "Pleace Insert Valid NIC").show();
                        txtNic.setStyle("-jfx-unfocus-color : red");
                    }

                } else {
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

        public void btnUpdateCustomerOnAction(ActionEvent actionEvent) {
            if (isIdMatcher(txtCustId.getText())) {
                if (isNameMatch(txtName.getText())) {
                    if (isNicMatcher(txtNic.getText())) {
                        if (isNameMatch(txtAddress.getText())) {
                            if (isAgeMatch(txtTpNo.getText())) {


                                String custId = txtCustId.getText();
                                String name = txtName.getText();
                                String nic = txtNic.getText();
                                String address = txtAddress.getText();
                                String tpNo = txtTpNo.getText();

                                Customer customer = new Customer(custId, name, nic, address, tpNo);
                                boolean isUpdated = customerDAO.update(customer);
                                if (isUpdated) {
                                    new Alert(Alert.AlertType.INFORMATION, "Customer Updated Sucessfully").show();
                                } else {
                                    new Alert(Alert.AlertType.WARNING, "Something happened!").show();
                                }


                            } else {
                                new Alert(Alert.AlertType.ERROR, "Pleace Insert Valid Te-No").show();
                                txtTpNo.setStyle("-jfx-unfocus-color : red");
                            }
                        } else {
                            new Alert(Alert.AlertType.ERROR, "Pleace Insert Valid Address").show();
                            txtAddress.setStyle("-jfx-unfocus-color : red");
                        }

                    } else {
                        new Alert(Alert.AlertType.ERROR, "Pleace Insert Valid NIC").show();
                        txtNic.setStyle("-jfx-unfocus-color : red");

                    }

                } else {
                    new Alert(Alert.AlertType.ERROR, "Pleace Insert Valid Name").show();
                    txtName.setStyle("-jfx-unfocus-color : red");
                }
            } else {
                new Alert(Alert.AlertType.ERROR, "Please check the Valid Cust_Id. (C-001) Like That").show();
                txtCustId.setStyle("-jfx-unfocus-color : red");
            }

        }

        public void btnSearchCustomerOnAction(ActionEvent actionEvent) {
            Customer customer = (Customer) customerDAO.search(txtCustId.getText());
            if (customer == null) {
                new Alert(Alert.AlertType.INFORMATION, "Customer Not Found").show();
            } else {
                txtName.setText(customer.getName());
                txtNic.setText(customer.getNic());
                txtAddress.setText(customer.getAddress());
                txtTpNo.setText(customer.getTpNo());

            }
        }

        public void btnCustomerDeleteOnAction(ActionEvent actionEvent) {
            boolean isDeleted = customerDAO.delete(txtCustId.getText());
            if (isDeleted) {
                new Alert(Alert.AlertType.INFORMATION, "Customer  Deleted Successfully!").show();

            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        }

        public void btnCustomerViewOnAction(ActionEvent actionEvent) throws IOException {
            Navigation.navigate(Routes.ADMINCUSTOMERVIEW, pane);

        }


    }

