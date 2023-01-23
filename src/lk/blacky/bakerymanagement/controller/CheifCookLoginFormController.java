package lk.blacky.bakerymanagement.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.blacky.bakerymanagement.db.DBConnection;
import lk.blacky.bakerymanagement.util.Navigation;
import lk.blacky.bakerymanagement.util.Routes;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheifCookLoginFormController {

    public AnchorPane pane;
    public JFXTextField txtUserName;
    public JFXPasswordField txtPassword;
    public Label lblError;

    public void initialize(){
        lblError.setVisible(false);
    }

    public void backImgOnClickAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.LOGIN,pane);
    }

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        try {
            String userName=txtUserName.getText();
            String password=txtPassword.getText();
            Connection connection = DBConnection.getInstance().getConnection();
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM cheif_cook");
            while (rs.next()){
                if (userName.equals(rs.getString(1)) && password.equals(rs.getString(2)) ){
                    Navigation.navigate(Routes.CHEIFCOOKDASHBOARD,pane);


                }else {
                    lblError.setVisible(true);
                    lblError.setText("         Incorrect User Name Or Password ");
                    Clear();

                }
            }





        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

    private void Clear() {
        txtUserName.clear();
        txtPassword.clear();
    }

    public void signupBtnOnClickAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.CHEIFCOOKSIGNUP,pane);
    }

    public void txtForgotPasswordOnClickAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.CHIEFCOOKFORGOTPASSWORD,pane);
    }

    public void fbImgOnClickAction(MouseEvent mouseEvent) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://www.facebook.com/"));
    }

    public void insterImgOnClickAction(MouseEvent mouseEvent) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://www.instagram.com/"));
    }

    public void whatsappImgOnClickAction(MouseEvent mouseEvent) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://www.whatsapp.com/"));
    }
}
