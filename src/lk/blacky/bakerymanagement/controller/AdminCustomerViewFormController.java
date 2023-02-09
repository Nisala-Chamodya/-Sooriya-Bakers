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
import lk.blacky.bakerymanagement.view.tm.CustomerTm;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class AdminCustomerViewFormController {
    public AnchorPane pane;
    public TableView <CustomerTm>tblCustomer;
    public TableColumn colCustId;
    public TableColumn colName;
    public TableColumn colNic;
    public TableColumn colAddress;
    public TableColumn colTpNo;
    public TableColumn colOption;
    public JFXTextField txtSearch;
    private  String searchText="";

    public void initialize(){
        colCustId.setCellValueFactory(new PropertyValueFactory<>("CustId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colNic.setCellValueFactory(new PropertyValueFactory<>("Nic"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        colTpNo.setCellValueFactory(new PropertyValueFactory<>("TpNo"));
        colOption.setCellValueFactory(new PropertyValueFactory<>("btn"));
        searchCustomers(searchText);





        txtSearch.textProperty()
                .addListener((observable, oldValue, newValue) -> {
                    searchText=newValue;
                    searchCustomers(searchText);

                });

    }




    private void searchCustomers(String text) {
        try{
            String searchText="%"+text+"%";

            ObservableList<CustomerTm> tmList= FXCollections.observableArrayList();

            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT  * FROM customer WHERE name LIKE ? || address  LIKE ?");
            statement.setObject(1,searchText);
            statement.setObject(2,searchText);
            ResultSet set = statement.executeQuery();



            while (set.next()){

                Button btn = new Button("Delete");
                btn.setStyle("-fx-background-color : red");


                CustomerTm tm=new CustomerTm(
                        set.getString(1),
                        set.getString(2),
                        set.getString(3),
                        set.getString(4),
                        set.getString(5),
                        btn
                );
                tmList.add(tm);

                btn.setOnAction(event -> {

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you Shuar delete this Customer ? ",
                            ButtonType.YES, ButtonType.NO);

                    Optional<ButtonType> buttonType = alert.showAndWait();
                    if (buttonType.get() == ButtonType.YES) {


                        try {

                            Connection connection1 = DBConnection.getInstance().getConnection();
                            PreparedStatement statement1 = connection1.prepareStatement("DELETE FROM customer WHERE  cust_id=?");
                            statement1.setObject(1,tm.getCustId());


                            if (  statement1.executeUpdate() >0 ) {
                                searchCustomers(searchText);
                                new Alert(Alert.AlertType.INFORMATION, "Customer Deleted!!").show();

                            } else {
                                new Alert(Alert.AlertType.WARNING, "Try Again !!!").show();
                            }


                        } catch (ClassNotFoundException | SQLException e) {
                            e.printStackTrace();
                        }







                    }








                });

                tblCustomer.setItems(tmList );
            }

        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }

    public void backImgOnClickAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.MANAGECUSTOMER,pane);
    }
}
