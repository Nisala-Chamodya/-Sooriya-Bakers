package lk.blacky.bakerymanagement.controller;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.blacky.bakerymanagement.db.DBConnection;
import lk.blacky.bakerymanagement.util.Navigation;
import lk.blacky.bakerymanagement.util.Routes;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewMonthlyProductSellingFormController {


    public AnchorPane pane;
    public PieChart piechartPastry;



    public void initialize() {
        setPieChartPastry();

    }










    private void setPieChartPastry() {
        ObservableList<PieChart.Data> pieChartData= FXCollections.observableArrayList(
                /*new PieChart.Data("pastry",25),
                new PieChart.Data("FishBun",30),
                new PieChart.Data("Jam Bun",20),
                new PieChart.Data("Donut",50),
                new PieChart.Data("Roll",30),
                new PieChart.Data("Pizza",60),
                new PieChart.Data("Egg Bun",65),
                new PieChart.Data("Bread",500),
                new PieChart.Data("Seeni sambal Bun",80),
                new PieChart.Data("Wadee",250)*/

        );

        try {


            Connection connection = DBConnection.getInstance().getConnection();
            ResultSet rs = connection.createStatement().executeQuery("SELECT product_id,availability FROM  `order_details`ORDER BY product_id");
            while (rs.next()){
                pieChartData.add(new PieChart.Data(rs.getString(1),rs.getInt(2)));







            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        pieChartData.forEach(data ->
                data.nameProperty().bind(
                        Bindings.concat(
                                data.getName(),"  amount",data.pieValueProperty()
                        )
                )
        );



        piechartPastry.getData().addAll(pieChartData);














    }


    public void backImgOnClickAction(MouseEvent contextMenuEvent) throws IOException {

        Navigation.navigate(Routes.VIEWMONTHLYINCOMEREPORTS,pane);

    }
}
