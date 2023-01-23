package lk.blacky.bakerymanagement.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.blacky.bakerymanagement.db.DBConnection;
import lk.blacky.bakerymanagement.util.Navigation;
import lk.blacky.bakerymanagement.util.Routes;
import lk.blacky.bakerymanagement.view.tm.CustomerTm;
import lk.blacky.bakerymanagement.view.tm.MonthlyTm;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class ViewMonthlyIncomeReportFormController {

    public AnchorPane pane;
    public TableView<MonthlyTm> tblMonthlyIncome;
    public TableColumn colOrderId;
    public TableColumn colProductId;
    public TableColumn colAvailability;
    public TableColumn colUnitPrice;
    public JFXTextField txtSearch;
    public JFXTextField txtMonth;


    private  String searchText="";

    public void  initialize(){

        colOrderId.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        colProductId.setCellValueFactory(new PropertyValueFactory<>("productId"));
        colAvailability.setCellValueFactory(new PropertyValueFactory<>("availability"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));

        searchMonthlyIncome(searchText);

        txtSearch.textProperty()
                .addListener((observable, oldValue, newValue) -> {
                    searchText=newValue;
                    searchMonthlyIncome(searchText);

                });



    }




    private void searchMonthlyIncome(String text) {

        try {

            String searchText="%"+text+"%";

            ObservableList<MonthlyTm> tmList= FXCollections.observableArrayList();
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT  * FROM `order_details` WHERE order_id LIKE ? || product_id  LIKE ?");
            statement.setObject(1,searchText);
            statement.setObject(2,searchText);
            ResultSet set = statement.executeQuery();
            while (set.next()){
                MonthlyTm tm=new MonthlyTm(
                        set.getString(1),
                        set.getString(2),
                        set.getInt(3),
                        set.getDouble(4)


                );
                tmList.add(tm);
                tblMonthlyIncome.setItems(tmList );



            }



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public void backImgOnClickAction(MouseEvent mouseEvent) throws IOException {
       // Navigation.navigate(Routes.VIEWINCOMEREPORTS,pane);
        Navigation.navigate(Routes.ADMINDASHBOARD,pane);

    }


    public void btnProductCategorySellingOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.MONTHLYPRODUCTCATEGORY,pane);

    }

    public void btnProductSelling(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.MONTHLYPRODUCTSELLING,pane);

    }

    public void btnPrintMonthlyIncomeReportOnAction(ActionEvent actionEvent) {
        HashMap<String,Object> hm=new HashMap<>();
        hm.put("month",txtMonth.getText());
        InputStream inputStream = this.getClass().getResourceAsStream("/lk/blacky/bakerymanagement/report/MonthlyIncome.jrxml");
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

