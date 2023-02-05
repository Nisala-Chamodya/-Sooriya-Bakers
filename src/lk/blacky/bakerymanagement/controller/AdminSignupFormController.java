package lk.blacky.bakerymanagement.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.blacky.bakerymanagement.dao.AdminDAOImpl;
import lk.blacky.bakerymanagement.dao.custom.impl.AdminDAO;
import lk.blacky.bakerymanagement.model.AddminModel;
import lk.blacky.bakerymanagement.model.RecipeModel;
import lk.blacky.bakerymanagement.to.Admin;
import lk.blacky.bakerymanagement.to.Recipe;
import lk.blacky.bakerymanagement.util.Navigation;
import lk.blacky.bakerymanagement.util.Routes;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;

import static lk.blacky.bakerymanagement.util.Validator.*;

public class AdminSignupFormController {

    public AnchorPane pane;
    public JFXTextField txtUserName;
    public JFXPasswordField txtPassword;
    public JFXPasswordField txtConfirmPassword;

    public void backImgOnClickAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.ADMINLOGIN,pane);
    }

    public void fbImgOnClickAction(MouseEvent mouseEvent) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://www.facebook.com/"));
    }

    public void googleImgOnAction(MouseEvent mouseEvent) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://www.google.com/"));
    }

    public void btnAdminSignUpOnAction(ActionEvent actionEvent) {
        if (isPasswordMatcher(txtPassword.getText())) {

        String userName = txtUserName.getText();
        String password = txtPassword.getText();



        Admin admin = new Admin(userName,password);
        AdminDAO adminDAO=new AdminDAOImpl();
            boolean isAdded = adminDAO.addAdmin(admin);
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
