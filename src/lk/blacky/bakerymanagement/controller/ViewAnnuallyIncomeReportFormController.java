package lk.blacky.bakerymanagement.controller;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.blacky.bakerymanagement.util.Navigation;
import lk.blacky.bakerymanagement.util.Routes;

import java.io.IOException;

public class ViewAnnuallyIncomeReportFormController {


    public AnchorPane pane;

    public void backImgOnClickAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.VIEWINCOMEREPORTS,pane);
    }

    public void btnProductSalesOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ANNUALLYPRODUCTSALES,pane);
    }

    public void btnSalesDetails(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ANNUALLYSALESDATAILS,pane);
    }
}
