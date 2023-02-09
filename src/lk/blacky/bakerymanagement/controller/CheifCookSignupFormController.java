package lk.blacky.bakerymanagement.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.blacky.bakerymanagement.dao.impl.CheifCookDAOImpl;
import lk.blacky.bakerymanagement.dao.custom.CheifCookDAO;
import lk.blacky.bakerymanagement.to.CheifCook;
import lk.blacky.bakerymanagement.util.Navigation;
import lk.blacky.bakerymanagement.util.Routes;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static lk.blacky.bakerymanagement.util.Validator.isPasswordMatcher;

public class CheifCookSignupFormController {

    public AnchorPane pane;
    public JFXTextField txtUserName;
    public JFXPasswordField txtPassword;
    public JFXPasswordField txtConfirmPassword;

    public void backImgOnClickAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.CHEIFCOOKLOGIN,pane);
    }

    public void fbImgOnClickAction(MouseEvent mouseEvent) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://www.facebook.com/"));
    }

    public void googleImgOnClickAction(MouseEvent mouseEvent) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://www.google.com/"));
    }


    public void btnCheifCookSignUpOnAction(ActionEvent actionEvent) {
        if (isPasswordMatcher(txtPassword.getText())) {
            String userName = txtUserName.getText();
            String password = txtPassword.getText();


            CheifCook cheifCook = new CheifCook(userName, password);
            CheifCookDAO cheifCookDAO=new CheifCookDAOImpl();


            boolean isAdded = cheifCookDAO.addCheifCook(cheifCook);
            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "Sign Up Successfully!").show();
                Clear();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
                Clear();
            }

        }else {
            new Alert(Alert.AlertType.ERROR, "Please Insert Valid Password \n minimum 10 Digits ").show();
            txtPassword.setStyle("-jfx-unfocus-color : red");
        }

    }

    private void Clear() {

        txtUserName.clear();
        txtPassword.clear();
        txtConfirmPassword.clear();
    }
}
