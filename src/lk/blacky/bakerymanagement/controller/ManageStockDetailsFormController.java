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
import lk.blacky.bakerymanagement.view.tm.StockTm;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class ManageStockDetailsFormController {

    public AnchorPane pane;
    public TableView tblStock;
    public TableColumn colSupplierId;
    public TableColumn colItemId;
    public TableColumn colBrand;
    public TableColumn colAvailability;
    public TableColumn colOption;
    public JFXTextField txtSearch;
    private  String searchText="";
    public void initialize(){
        colSupplierId.setCellValueFactory(new PropertyValueFactory<>("supplierId"));
        colItemId.setCellValueFactory(new PropertyValueFactory<>("itemId"));
        colBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        colAvailability.setCellValueFactory(new PropertyValueFactory<>("availability"));
        colOption.setCellValueFactory(new PropertyValueFactory<>("btn"));

        searchStock(searchText);
        txtSearch.textProperty()
                .addListener((observable, oldValue, newValue) -> {
                    searchText=newValue;
                    searchStock(searchText);

                });


    }

    private void searchStock(String text) {
        try {
            String searchText="%"+text+"%";

            ObservableList<StockTm> tmList= FXCollections.observableArrayList();
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT  * FROM item_supplier WHERE supplier_id LIKE ? || brand LIKE ?");
            statement.setObject(1,searchText);
            statement.setObject(2,searchText);
            ResultSet set = statement.executeQuery();
            while (set.next()){

                Button btn = new Button("Delete");
                btn.setStyle("-fx-background-color : red");


                StockTm tm=new StockTm(
                        set.getString(1),
                        set.getString(2),
                        set.getString(3),
                        set.getInt(4),

                        btn
                );
                tmList.add(tm);
                btn.setOnAction(event -> {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you Shuar delete this Stock Details ? ",
                            ButtonType.YES, ButtonType.NO);

                    Optional<ButtonType> buttonType = alert.showAndWait();
                    if (buttonType.get() == ButtonType.YES) {


                        try {

                            Connection connection1 = DBConnection.getInstance().getConnection();
                            PreparedStatement statement1 = connection1.prepareStatement("DELETE FROM item_supplier WHERE  supplier_id=?");
                            statement1.setObject(1,tm.getSupplierId());


                            if (  statement1.executeUpdate() >0 ) {
                                searchStock(searchText);
                                new Alert(Alert.AlertType.INFORMATION, "Stock Details Deleted!!").show();

                            } else {
                                new Alert(Alert.AlertType.WARNING, "Try Again !!!").show();
                            }


                        } catch (ClassNotFoundException | SQLException e) {
                            e.printStackTrace();
                        }







                    }



                });
                tblStock.setItems(tmList );
            }





        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    public void backImgOnClickAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.ADMINDASHBOARD,pane);

    }
}
