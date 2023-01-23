package lk.blacky.bakerymanagement.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.blacky.bakerymanagement.model.RecipeModel;
import lk.blacky.bakerymanagement.model.StockModel;
import lk.blacky.bakerymanagement.to.Recipe;
import lk.blacky.bakerymanagement.to.Stock;
import lk.blacky.bakerymanagement.util.Navigation;
import lk.blacky.bakerymanagement.util.Routes;

import java.io.IOException;
import java.sql.SQLException;

import static lk.blacky.bakerymanagement.util.Validator.*;

public class ChiefCookManageStockDetailsFormController {
    public AnchorPane pane;
    public JFXTextField txtSupplierId;
    public JFXTextField txtItemId;
    public JFXTextField txtBrand;
    public JFXTextField txtAvailability;

    public void backImgClickOnAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.CHEIFCOOKDASHBOARD,pane);

    }

    public void btnAddStockOnAction(ActionEvent actionEvent) {
        if (isSupplierIdMatcher(txtSupplierId.getText())) {
            if (isItemIdMatcher(txtItemId.getText())){
                if (isNameMatch(txtBrand.getText())){
                    if (isAvailabilityMatcher(txtAvailability.getText())){

        String supplierId = txtSupplierId.getText();
        String itemId= txtItemId.getText();
        String brand = txtBrand.getText();
        int availability = Integer.parseInt(txtAvailability.getText());


        Stock stock = new Stock(supplierId,itemId,brand,availability);

        try {
            boolean isAdded = StockModel.addDetails(stock);
            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "Stock Details Added!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
                    }else {
                        new Alert(Alert.AlertType.ERROR, "Please Enter The Valid Number .").show();
                        txtAvailability.setStyle("-jfx-unfocus-color : red");
                    }
                }else {
                    new Alert(Alert.AlertType.ERROR, "Please Enter The Valid Description .").show();
                    txtBrand.setStyle("-jfx-unfocus-color : red");
                }
            }else {
                new Alert(Alert.AlertType.ERROR, "Please check the Valid Item_Id.\n (I-001) Like That").show();
                txtItemId.setStyle("-jfx-unfocus-color : red");
            }
        }else {
            new Alert(Alert.AlertType.ERROR, "Please check the Valid Supplier_Id.\n (S-001) Like That").show();
            txtSupplierId.setStyle("-jfx-unfocus-color : red");
        }


    }

    public void btnUpdateStockOnAction(ActionEvent actionEvent) {
        if (isSupplierIdMatcher(txtSupplierId.getText())) {
            if (isItemIdMatcher(txtItemId.getText())){
                if (isNameMatch(txtBrand.getText())){
                    if (isAvailabilityMatcher(txtAvailability.getText())){

                        String supplierId = txtSupplierId.getText();
        String itemId= txtItemId.getText();
        String brand = txtBrand.getText();
        int availability = Integer.parseInt(txtAvailability.getText());


        Stock stock = new Stock(supplierId,itemId,brand,availability);

        try {
            boolean isUpdated = StockModel.updateStockDetails(stock);
            if (isUpdated) {
                new Alert(Alert.AlertType.INFORMATION, "Stock Details Updated Successfully").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
                    }else {
                        new Alert(Alert.AlertType.ERROR, "Please Enter The Valid Number .").show();
                        txtAvailability.setStyle("-jfx-unfocus-color : red");
                    }
                }else {
                    new Alert(Alert.AlertType.ERROR, "Please Enter The Valid Description .").show();
                    txtBrand.setStyle("-jfx-unfocus-color : red");
                }
            }else {
                new Alert(Alert.AlertType.ERROR, "Please check the Valid Item_Id.\n (I-001) Like That").show();
                txtItemId.setStyle("-jfx-unfocus-color : red");
            }
        }else {
            new Alert(Alert.AlertType.ERROR, "Please check the Valid Supplier_Id.\n (S-001) Like That").show();
            txtSupplierId.setStyle("-jfx-unfocus-color : red");
        }



    }

    public void btnSearchStockOnAction(ActionEvent actionEvent) {

        try {
            Stock stock= StockModel.searchStockDetails(txtSupplierId.getText());
            if (stock==null){
                new Alert(Alert.AlertType.INFORMATION,"Recipe Not Found").show();
            }else {
                txtItemId.setText(stock.getItemId());
                txtBrand.setText(stock.getBrand());
                txtAvailability.setText(String.valueOf(stock.getAvailability()));


            }




        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    public void btnClearStockOnAction(ActionEvent actionEvent) {
        txtSupplierId.clear();
        txtItemId.clear();
        txtBrand.clear();
        txtAvailability.clear();
    }

    public void btnDeleteStockOnAction(ActionEvent actionEvent) {

        try {
            boolean isDeleted=   StockModel.deleteStockDetails(txtSupplierId.getText());

            if (isDeleted){
                new Alert(Alert.AlertType.INFORMATION,"Stock Details  Deleted Successfully!").show();


            }else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void btnViewStockOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.CHEIFCOOKVIEWSTOCK,pane);
    }
}
