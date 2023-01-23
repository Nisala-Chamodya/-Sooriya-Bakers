package lk.blacky.bakerymanagement.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.blacky.bakerymanagement.db.DBConnection;
import lk.blacky.bakerymanagement.to.Supplier;
import lk.blacky.bakerymanagement.util.Navigation;
import lk.blacky.bakerymanagement.util.Routes;
import lk.blacky.bakerymanagement.view.tm.SupplierTm;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Optional;

public class AdminSupplierViewFormController {

    public AnchorPane pane;
    public TableView <SupplierTm> tblSupplier;
    public TableColumn colSupplierId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colTpNo;
    public TableColumn colEmail;
    public TableColumn colOption;
    public JFXTextField txtSearch;
    public JFXTextField txtYear;
    private  String searchText="";



    public void initialize(){
        colSupplierId.setCellValueFactory(new PropertyValueFactory<>("supplierId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colTpNo.setCellValueFactory(new PropertyValueFactory<>("tpNo"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colOption.setCellValueFactory(new PropertyValueFactory<>("btn"));
        searchSupplier(searchText);


        txtSearch.textProperty()
                .addListener((observable, oldValue, newValue) -> {
                    searchText=newValue;
                    searchSupplier(searchText);

                });

    }

    private void searchSupplier(String text) {

        try {

            String searchText="%"+text+"%";

            ObservableList<SupplierTm> tmList= FXCollections.observableArrayList();
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT  * FROM supplier WHERE supplier_id LIKE ? || name  LIKE ?");
            statement.setObject(1,searchText);
            statement.setObject(2,searchText);
            ResultSet set = statement.executeQuery();

            while (set.next()){
                Button btn = new Button("Delete");
                btn.setStyle("-fx-background-color : red");


                SupplierTm tm=new SupplierTm(
                        set.getString(1),
                        set.getString(2),
                        set.getString(3),
                        set.getString(4),
                        set.getString(5),

                        btn
                );
                tmList.add(tm);


                btn.setOnAction(event -> {

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you Shuar delete this Supplier ? ",
                            ButtonType.YES, ButtonType.NO);

                    Optional<ButtonType> buttonType = alert.showAndWait();
                    if (buttonType.get() == ButtonType.YES) {


                        try {

                            Connection connection1 = DBConnection.getInstance().getConnection();
                            PreparedStatement statement1 = connection1.prepareStatement("DELETE FROM supplier WHERE  supplier_id=?");
                            statement1.setObject(1,tm.getSupplierId());


                            if (  statement1.executeUpdate() >0 ) {
                                searchSupplier(searchText);
                                new Alert(Alert.AlertType.INFORMATION, "Supplier Deleted!!").show();

                            } else {
                                new Alert(Alert.AlertType.WARNING, "Try Again !!!").show();
                            }


                        } catch (ClassNotFoundException | SQLException e) {
                            e.printStackTrace();
                        }







                    }







                });


                tblSupplier.setItems(tmList );

            }













        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }

    }


    public void backImgOnClickAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.MANAGESUPPLIER,pane);
    }

    public void printSupplierDetailsOnAction(ActionEvent actionEvent) {

        HashMap<String,Object>hm=new HashMap<>();
        hm.put("year",txtYear.getText());
        InputStream inputStream = this.getClass().getResourceAsStream("/lk/blacky/bakerymanagement/report/SupplierDetails.jrxml");
        try {
            JasperReport compileReport = JasperCompileManager.compileReport(inputStream);
            JasperPrint jasperPrint=  JasperFillManager
                    .fillReport(compileReport,hm, DBConnection.getInstance().getConnection());
            //JasperPrintManager.printReport(jasperPrint,true);
            JasperViewer.viewReport(jasperPrint);
        } catch (JRException | ClassNotFoundException | SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    }

