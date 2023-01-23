package lk.blacky.bakerymanagement.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.blacky.bakerymanagement.db.DBConnection;
import lk.blacky.bakerymanagement.util.Navigation;
import lk.blacky.bakerymanagement.util.Routes;
import lk.blacky.bakerymanagement.view.tm.ProductTm;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class CheifCookViewProductFormController {
    public AnchorPane pane;
    public TableView <ProductTm> tblProduct;
    public TableColumn colProduct_Id;
    public TableColumn colName;
    public TableColumn colPrice;
    public TableColumn colDescription;
    public TableColumn colAvailability;
    public TableColumn colOption;
    public JFXTextField txtSearch;
    private  String searchText="";


    public void initialize(){

        colProduct_Id.setCellValueFactory(new PropertyValueFactory<>("productId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colAvailability.setCellValueFactory(new PropertyValueFactory<>("availability"));
        colOption.setCellValueFactory(new PropertyValueFactory<>("btn"));
        searchProduct(searchText);


        txtSearch.textProperty()
                .addListener((observable, oldValue, newValue) -> {
                    searchText=newValue;
                    searchProduct(searchText);

                });

    }


    private void searchProduct(String text) {
        String searchText = "%" + text + "%";
        ObservableList<ProductTm> tmList = FXCollections.observableArrayList();
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT  * FROM product WHERE product_id LIKE ? || name  LIKE ?");
            statement.setObject(1, searchText);
            statement.setObject(2, searchText);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                Button btn = new Button("Delete");
                btn.setStyle("-fx-background-color : red");

                ProductTm tm = new ProductTm(
                        set.getString(1),
                        set.getString(2),
                        set.getDouble(3),
                        set.getString(4),
                        set.getInt(5),
                        btn
                );
                tmList.add(tm);

                btn.setOnAction(event -> {


                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you Shuar delete this Product ? ",
                            ButtonType.YES, ButtonType.NO);

                    Optional<ButtonType> buttonType = alert.showAndWait();
                    if (buttonType.get() == ButtonType.YES) {


                        try {

                            Connection connection1 = DBConnection.getInstance().getConnection();
                            PreparedStatement statement1 = connection1.prepareStatement("DELETE FROM product WHERE  product_id=?");
                            statement1.setObject(1, tm.getProductId());


                            if (statement1.executeUpdate() > 0) {
                                searchProduct(searchText);
                                new Alert(Alert.AlertType.INFORMATION, "Product Deleted!!").show();

                            } else {
                                new Alert(Alert.AlertType.WARNING, "Try Again !!!").show();
                            }


                        } catch (ClassNotFoundException | SQLException e) {
                            e.printStackTrace();
                        }


                    }


                });


                tblProduct.setItems(tmList);


            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }






        public void backImgOnClickAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.MANAGEPRODUCTWITHCHEIEFCOOK,pane);
    }
}
