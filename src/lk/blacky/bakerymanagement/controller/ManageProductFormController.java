package lk.blacky.bakerymanagement.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.blacky.bakerymanagement.dao.ProductDAOImpl;
import lk.blacky.bakerymanagement.dao.custom.impl.ProductDAO;
import lk.blacky.bakerymanagement.to.Product;
import lk.blacky.bakerymanagement.util.Navigation;
import lk.blacky.bakerymanagement.util.Routes;

import java.io.IOException;

import static lk.blacky.bakerymanagement.util.Validator.*;

public class ManageProductFormController {
    public AnchorPane pane;
    public JFXTextField txtProductId;
    public JFXTextField txtProductName;
    public JFXTextField txtPrice;
    public JFXTextField txtDescription;
    public JFXTextField txtAvailabilty;

// Dipendancy Injection
    ProductDAO productDAO=new ProductDAOImpl();



    public void backImgClickOnAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.ADMINDASHBOARD,pane);

    }

    public void btnProductViewOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ADMINPRODUCTVIEW,pane);


    }

    public void btnAddProductOnAction(ActionEvent actionEvent) {
        if (isProductIdMatcher(txtProductId.getText())) {
            if (isNameMatch(txtProductName.getText())){
                if (isPriceMatcher(txtPrice.getText())){
                    if (isNameMatch(txtDescription.getText())){
                        if (isAvailabilityMatcher(txtAvailabilty.getText())){
        String productId=txtProductId.getText();
        String productName= txtProductName.getText();
        double price=Double.parseDouble(txtPrice.getText());
        String description=txtDescription.getText();
        int availability=Integer.parseInt(txtAvailabilty.getText());

        Product product = new Product(productId,productName,price,description,availability);
                            boolean isAdded= productDAO.AddProduct(product);
                            if (isAdded){
                                new Alert(Alert.AlertType.CONFIRMATION, "Product Added!").show();
                            }else {
                                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
                            }
                        }else {
                            new Alert(Alert.AlertType.ERROR, "Pleace Enter Valid Number").show();
                            txtAvailabilty.setStyle("-jfx-unfocus-color : red");
                        }


                }else {
                        new Alert(Alert.AlertType.ERROR, "Pleace Enter Valid Description").show();
                        txtDescription.setStyle("-jfx-unfocus-color : red");
                    }


            }else {
                    new Alert(Alert.AlertType.ERROR, "Pleace Insert Valid Price").show();
                    txtPrice.setStyle("-jfx-unfocus-color : red");

                }

            }else {
                new Alert(Alert.AlertType.ERROR, "Pleace Insert Valid Name").show();
                txtProductName.setStyle("-jfx-unfocus-color : red");
            }


    }else {
            new Alert(Alert.AlertType.ERROR, "Please check the Valid Product_Id. (P-001) Like That").show();
            txtProductId.setStyle("-jfx-unfocus-color : red");
        }
    }

    public void btnProductClearOnAction(ActionEvent actionEvent) {
      txtProductId.clear();
       txtProductName.clear();
        txtPrice.clear();
        txtDescription.clear();
         txtAvailabilty.clear();


    }

    public void btnProductSearchOnAction(ActionEvent actionEvent) {
        Product product= productDAO.searchProduct(txtProductId.getText());
        if (product==null){
            new Alert(Alert.AlertType.INFORMATION,"Product Not Found").show();
        }else {
            txtProductName.setText(product.getProductName());
            txtPrice.setText(String.valueOf(product.getPrice()));
            txtDescription.setText(product.getDescription());
            txtAvailabilty.setText(String.valueOf(product.getAvailability()));

        }


    }

    public void btnProductUpdateOnAction(ActionEvent actionEvent) {
        if (isProductIdMatcher(txtProductId.getText())) {
            if (isNameMatch(txtProductName.getText())){
                if (isPriceMatcher(txtPrice.getText())){
                    if (isNameMatch(txtDescription.getText())){
                        if (isAvailabilityMatcher(txtAvailabilty.getText())){

        String productId=txtProductId.getText();
        String productName= txtProductName.getText();
        double price=Double.parseDouble(txtPrice.getText());
        String description=txtDescription.getText();
        int availability=Integer.parseInt(txtAvailabilty.getText());

        Product product = new Product(productId,productName,price,description,availability);
                            boolean isUpdated=  productDAO.updateProduct(product);
                            if (isUpdated){
                                new Alert(Alert.AlertType.INFORMATION,"Product Updated Sucessfully").show();
                            }else {
                                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
                            }


                        }else {
                            new Alert(Alert.AlertType.ERROR, "Pleace Enter Valid Number").show();
                            txtAvailabilty.setStyle("-jfx-unfocus-color : red");
                        }


                    }else {
                        new Alert(Alert.AlertType.ERROR, "Pleace Enter Valid Description").show();
                        txtDescription.setStyle("-jfx-unfocus-color : red");
                    }


                }else {
                    new Alert(Alert.AlertType.ERROR, "Pleace Insert Valid Price").show();
                    txtPrice.setStyle("-jfx-unfocus-color : red");

                }

            }else {
                new Alert(Alert.AlertType.ERROR, "Pleace Insert Valid Name").show();
                txtProductName.setStyle("-jfx-unfocus-color : red");
            }


        }else {
            new Alert(Alert.AlertType.ERROR, "Please check the Valid Product_Id. (P-001) Like That").show();
            txtProductId.setStyle("-jfx-unfocus-color : red");
        }














    }

    public void btnDeleteProductOnAction(ActionEvent actionEvent) {
        boolean isDeleted=   productDAO.deleteProduct(txtProductId.getText());
        if (isDeleted){
            new Alert(Alert.AlertType.INFORMATION,"Product  Deleted Successfully!").show();

        }else {
            new Alert(Alert.AlertType.WARNING, "Something happened!").show();
        }
    }
}
