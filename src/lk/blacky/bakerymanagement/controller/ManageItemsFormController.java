package lk.blacky.bakerymanagement.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.blacky.bakerymanagement.dao.ItemDAOImpl;
import lk.blacky.bakerymanagement.model.ItemModel;
import lk.blacky.bakerymanagement.to.Item;
import lk.blacky.bakerymanagement.util.Navigation;
import lk.blacky.bakerymanagement.util.Routes;

import java.io.IOException;
import java.sql.SQLException;

import static lk.blacky.bakerymanagement.util.Validator.*;

public class ManageItemsFormController {

    public AnchorPane pane;
    public JFXTextField txtItemId;
    public JFXTextField txtBrand;
    public JFXTextField txtDescription;
    public JFXTextField txtAvailability;

    public void backImgOnClickAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.CHEIFCOOKDASHBOARD,pane);
    }

    public void btnAddItemsOnAction(ActionEvent actionEvent) {
        if (isItemIdMatcher(txtItemId.getText())) {
            if (isNameMatch(txtBrand.getText())){
                if (isNameMatch(txtDescription.getText())){
                    if (isAvailabilityMatcher(txtAvailability.getText())){
            String itemId = txtItemId.getText();
            String brand = txtBrand.getText();
            String description = txtDescription.getText();
            int availability = Integer.parseInt(txtAvailability.getText());


            Item item = new Item(itemId, brand, description, availability);

            try {
                boolean isAdded = ItemDAOImpl.AddItem(item);
                if (isAdded) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Item Added!").show();
                } else {
                    new Alert(Alert.AlertType.WARNING, "Something happened!").show();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
                    }else {
                        new Alert(Alert.AlertType.ERROR, "Please Enter Valid Number").show();
                        txtAvailability.setStyle("-jfx-unfocus-color : red");
                    }
                }else {
                    new Alert(Alert.AlertType.ERROR, "Please Enter Valid Description").show();
                    txtDescription.setStyle("-jfx-unfocus-color : red");
                }
            }else {
                new Alert(Alert.AlertType.ERROR, "Please Enter Valid Brand Name").show();
                txtBrand.setStyle("-jfx-unfocus-color : red");
            }
        }else {
            new Alert(Alert.AlertType.ERROR, "Please check the Valid Cust_Id.\n (I-001) Like That").show();
            txtItemId.setStyle("-jfx-unfocus-color : red");
        }
    }

    public void btnClearItemOnAction(ActionEvent actionEvent) {
        txtItemId.clear();
        txtBrand.clear();
        txtDescription.clear();
        txtAvailability.clear();
    }

    public void btnSearchItemOnAction(ActionEvent actionEvent) {
        try {
            Item item= ItemDAOImpl.searchItem(txtItemId.getText());
            if (item==null){
                new Alert(Alert.AlertType.INFORMATION,"Item Not Found").show();
            }else {
                txtBrand.setText(item.getBrand());
                txtDescription.setText(item.getDescription());
                txtAvailability.setText(String.valueOf(item.getAvailability()));


            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void btnUpdateItemOnAction(ActionEvent actionEvent) {
        if (isItemIdMatcher(txtItemId.getText())) {
            if (isNameMatch(txtBrand.getText())){
                if (isNameMatch(txtDescription.getText())){
                    if (isAvailabilityMatcher(txtAvailability.getText())){
                        String itemId = txtItemId.getText();
        String brand = txtBrand.getText();
        String description = txtDescription.getText();
        int availability = Integer.parseInt(txtAvailability.getText());


        Item item = new Item(itemId,brand,description,availability);
        try {
            boolean isUpdated=  ItemDAOImpl.updateItem(item);
            if (isUpdated){
                new Alert(Alert.AlertType.INFORMATION,"Item Updated Successfully").show();
            }else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
                    }else {
                        new Alert(Alert.AlertType.ERROR, "Please Enter Valid Number").show();
                        txtAvailability.setStyle("-jfx-unfocus-color : red");
                    }
                }else {
                    new Alert(Alert.AlertType.ERROR, "Please Enter Valid Description").show();
                    txtDescription.setStyle("-jfx-unfocus-color : red");
                }
            }else {
                new Alert(Alert.AlertType.ERROR, "Please Enter Valid Brand Name").show();
                txtBrand.setStyle("-jfx-unfocus-color : red");
            }
        }else {
            new Alert(Alert.AlertType.ERROR, "Please check the Valid Cust_Id.\n (I-001) Like That").show();
            txtItemId.setStyle("-jfx-unfocus-color : red");
        }


    }

    public void btnDeleteItemOnAction(ActionEvent actionEvent) {

        try {
            boolean isDeleted=   ItemDAOImpl.deleteItem(txtItemId.getText());
            if (isDeleted){
                new Alert(Alert.AlertType.INFORMATION,"Item  Deleted Successfully!").show();

            }else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void btnItemViewOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.CHEIFCOOKVIEWITEM,pane);
    }
}
