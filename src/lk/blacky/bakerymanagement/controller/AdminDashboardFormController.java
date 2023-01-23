package lk.blacky.bakerymanagement.controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lk.blacky.bakerymanagement.util.Navigation;
import lk.blacky.bakerymanagement.util.Routes;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AdminDashboardFormController {
    public AnchorPane pane;
    public Label lblTime;
    public void initialize(){
        setDateAndTime();
    }

    private void setDateAndTime() {

        Timeline time=new Timeline(
                new KeyFrame(Duration.ZERO, e->{
                    DateTimeFormatter formatter=DateTimeFormatter.ofPattern("YYYY-MM-dd      HH:mm:ss ");
                    lblTime.setText(LocalDateTime.now().format(formatter));
                }),new KeyFrame(Duration.seconds(1))   );
        time.setCycleCount(Animation.INDEFINITE);
        time.play();

    }

    public void backImgOnClickAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.LOGIN,pane);
    }

    public void btnManageCustomerOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.MANAGECUSTOMER,pane);

    }

    public void btnManageProductOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.MANAGEPRODUCT,pane);
    }

    public void btnManageEmployeeOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.MANAGEEMPLOYEE,pane);
    }

    public void btnManageSupplierDetailsOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.MANAGESUPPLIER,pane);
    }

    public void btnManageStockOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.MANAGESTOCK,pane);
    }


    public void btnViewIncomeReportsOnAction(ActionEvent actionEvent) throws IOException {
        //Navigation.navigate(Routes.VIEWINCOMEREPORTS,pane);
        Navigation.navigate(Routes.VIEWMONTHLYINCOMEREPORTS,pane);
    }
}
