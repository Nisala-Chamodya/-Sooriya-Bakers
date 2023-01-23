package lk.blacky.bakerymanagement.controller;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.blacky.bakerymanagement.util.Navigation;
import lk.blacky.bakerymanagement.util.Routes;

import java.io.IOException;

public class ViewAnnuallySalesDetailsFormController {
    public AnchorPane pane;
    public PieChart piechartAnnuallyPastry;
    public PieChart piechartAnnuallyCake;
    public void initialize(){


        setPieChartAnuallyPastry();
        setPieChartAnnuallyCake();



    }

    private void setPieChartAnnuallyCake() {
        ObservableList<PieChart.Data> pieChartData= FXCollections.observableArrayList(
                new PieChart.Data("Chocolate Cake",5000),
                new PieChart.Data("Biscuit Cake",6000),
                new PieChart.Data("Butter Cake ",7000),
                new PieChart.Data("Pound Cake",3500),
                new PieChart.Data("Sponge Cake",4500),
                new PieChart.Data("Genoise Cake",6000),
                new PieChart.Data("Angel Food Cake",1500),
                new PieChart.Data("Chiffon Cake",3500),
                new PieChart.Data(" Fallen Chocolate Cake",2500),
                new PieChart.Data("Carrot Cake",4500)

        );







        pieChartData.forEach(data ->
                data.nameProperty().bind(
                        Bindings.concat(
                                data.getName(),"amount",data.pieValueProperty()
                        )
                )
        );
        piechartAnnuallyCake.getData().addAll(pieChartData);


    }

    private void setPieChartAnuallyPastry() {
        ObservableList<PieChart.Data> pieChartData= FXCollections.observableArrayList(
                new PieChart.Data("pastry",20000),
                new PieChart.Data("FishBun",60000),
                new PieChart.Data("Jam Bun",70000),
                new PieChart.Data("Donut",45000),
                new PieChart.Data("Roll",85000),
                new PieChart.Data("Pizza",6000),
                new PieChart.Data("Egg Bun",6500),
                new PieChart.Data("Bread",85000),
                new PieChart.Data("Seeni sambal Bun",78500),
                new PieChart.Data("Wadee",98000)

        );







        pieChartData.forEach(data ->
                data.nameProperty().bind(
                        Bindings.concat(
                                data.getName(),"amount",data.pieValueProperty()
                        )
                )
        );
        piechartAnnuallyPastry.getData().addAll(pieChartData);






    }

    public void backImgOnClickAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.VIEWINCOMEREPORTS,pane);
    }
}
