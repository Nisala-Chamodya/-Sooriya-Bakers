package lk.blacky.bakerymanagement.controller;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.blacky.bakerymanagement.util.Navigation;
import lk.blacky.bakerymanagement.util.Routes;

import java.io.IOException;

public class ViewIncomeReportFormController {

    public AnchorPane pane;

    public void backImgOnClickAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.ADMINDASHBOARD,pane);
    }

    public void btnViewMonthlyOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.VIEWMONTHLYINCOMEREPORTS,pane);

    }


    public void btnViewAnnuallyOnAction(ActionEvent actionEvent) throws IOException {

     Navigation.navigate(Routes.VIEWANNUALLYINCOMEREPORTS,pane);
    }
}
