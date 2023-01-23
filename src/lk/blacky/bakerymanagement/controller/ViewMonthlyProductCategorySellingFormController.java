package lk.blacky.bakerymanagement.controller;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.blacky.bakerymanagement.db.DBConnection;
import lk.blacky.bakerymanagement.util.Navigation;
import lk.blacky.bakerymanagement.util.Routes;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewMonthlyProductCategorySellingFormController {


    public AnchorPane pane;
    public BarChart barChartMonthly;

    public void initialize() {
        setBarChartMonthly();

    }

    private void setBarChartMonthly() {

        XYChart.Series<String,Integer> series1 = new XYChart.Series();
        series1.setName("Bakery Items");

       /* series1.getData().add(new XYChart.Data("January", 100));
        series1.getData().add(new XYChart.Data("February", 300));
        series1.getData().add(new XYChart.Data("March", 500));
        series1.getData().add(new XYChart.Data("April", 700));
        series1.getData().add(new XYChart.Data("May", 900));
        series1.getData().add(new XYChart.Data("June", 350));
        series1.getData().add(new XYChart.Data("July", 600));
        series1.getData().add(new XYChart.Data("August", 150));
        series1.getData().add(new XYChart.Data("September", 300));
        series1.getData().add(new XYChart.Data("October", 500));
        series1.getData().add(new XYChart.Data("November", 900));
        series1.getData().add(new XYChart.Data("December", 800));*/








        try {
            Connection connection = DBConnection.getInstance().getConnection();
            ResultSet rs = connection.createStatement().executeQuery("SELECT product_id,availability FROM  `order_details`ORDER BY product_id");

            while (rs.next()){

             series1.getData().add(new XYChart.Data<>(rs.getString(1),rs.getInt(2)));



            }
            barChartMonthly.getData().add(series1);



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }





      /*  XYChart.Series series2 = new XYChart.Series();
        series2.setName("Cakes");

        series2.getData().add(new XYChart.Data("January", 100));
        series2.getData().add(new XYChart.Data("February", 150));
        series2.getData().add(new XYChart.Data("March", 250));
        series2.getData().add(new XYChart.Data("April", 600));
        series2.getData().add(new XYChart.Data("May", 300));
        series2.getData().add(new XYChart.Data("June", 200));
        series2.getData().add(new XYChart.Data("July", 450));
        series2.getData().add(new XYChart.Data("August", 100));
        series2.getData().add(new XYChart.Data("September", 250));
        series2.getData().add(new XYChart.Data("October", 100));
        series2.getData().add(new XYChart.Data("November", 700));
        series2.getData().add(new XYChart.Data("December", 800));*/




    }


    public void backImgOnClickAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.VIEWMONTHLYINCOMEREPORTS,pane);

    }
}


