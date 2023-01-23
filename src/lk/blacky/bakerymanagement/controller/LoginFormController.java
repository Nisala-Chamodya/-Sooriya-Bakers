package lk.blacky.bakerymanagement.controller;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.blacky.bakerymanagement.util.Navigation;
import lk.blacky.bakerymanagement.util.Routes;

import java.io.IOException;

public class LoginFormController {
    public AnchorPane pane;

    public void adminImgOnClickAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.ADMINLOGIN,pane);
    }

    public void cashierImgClickOnAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.CASHIERLOGIN,pane);
    }

    public void cheifcookImgClickOnAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.CHEIFCOOKLOGIN,pane);

    }
}
