package lk.blacky.bakerymanagement.controller;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.blacky.bakerymanagement.util.Navigation;
import lk.blacky.bakerymanagement.util.Routes;

import java.io.IOException;

public class ViewAnnualProductSalesFormController {


    public AnchorPane pane;
    public BarChart barChartAnnally;

    public void initialize(){

        setBarChartAnnually();




    }

    private void setBarChartAnnually() {
        XYChart.Series series1=new XYChart.Series();
        series1.setName("Pastry");

        series1.getData().add(new XYChart.Data("2021",4500)  );
        series1.getData().add(new XYChart.Data("2022",5500)  );
        series1.getData().add(new XYChart.Data("2023",7000)  );



        XYChart.Series series2=new XYChart.Series();
        series2.setName("Cakes");

        series2.getData().add(new XYChart.Data("2021",3500)  );
        series2.getData().add(new XYChart.Data("2022",4500)  );
        series2.getData().add(new XYChart.Data("2023",6000)  );

        barChartAnnally.getData().addAll(series1,series2);



    }

    public void backImgOnClickAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.VIEWANNUALLYINCOMEREPORTS,pane);
    }
}
