package lk.blacky.bakerymanagement.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.blacky.bakerymanagement.dao.CashierDAOImpl;
import lk.blacky.bakerymanagement.dao.custom.CashierDAO;
import lk.blacky.bakerymanagement.to.Cashier;
import lk.blacky.bakerymanagement.util.Navigation;
import lk.blacky.bakerymanagement.util.Routes;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static lk.blacky.bakerymanagement.util.Validator.isPasswordMatcher;

public class CashierForgotPasswordFormController {
    public AnchorPane pane;
    public JFXTextField txtUserName;
    public JFXPasswordField txtPassword;
    public JFXPasswordField txtConfirmPassword;

    public void backImgOnClickAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.CASHIERLOGIN,pane);
    }

    public void fbImgOnClickAction(MouseEvent mouseEvent) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://www.facebook.com/"));
    }

    public void googleImgOnClickAction(MouseEvent mouseEvent) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://www.google.com/"));
    }

    public void btnChangePasswordOnAction(ActionEvent actionEvent) {
        if (isPasswordMatcher(txtPassword.getText())) {
            String userName = txtUserName.getText();
            String password = txtPassword.getText();


            Cashier cashier = new Cashier(userName, password);
            CashierDAO cashierDAO=new CashierDAOImpl();
            boolean isUpdated = cashierDAO.updateCashier(cashier);
            if (isUpdated) {
                new Alert(Alert.AlertType.INFORMATION, "Password Updated Successfully").show();
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
