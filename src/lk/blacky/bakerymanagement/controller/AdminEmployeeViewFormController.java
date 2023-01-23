package lk.blacky.bakerymanagement.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.blacky.bakerymanagement.db.DBConnection;
import lk.blacky.bakerymanagement.util.Navigation;
import lk.blacky.bakerymanagement.util.Routes;
import lk.blacky.bakerymanagement.view.tm.CustomerTm;
import lk.blacky.bakerymanagement.view.tm.EmployeeTm;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class AdminEmployeeViewFormController {
    public AnchorPane pane;
    public TableView <EmployeeTm>tblEmployee;
    public TableColumn colEmpId;
    public TableColumn colName;
    public TableColumn colGender;
    public TableColumn colDivision;
    public TableColumn colSalary;
    public TableColumn colTpNo;
    public TableColumn colEmail;
    public TableColumn colDb;
    public TableColumn colOption;
    public JFXTextField txtSearch;
    private  String searchText="";


    public void initialize(){
        colEmpId.setCellValueFactory(new PropertyValueFactory<>("empId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        colDivision.setCellValueFactory(new PropertyValueFactory<>("division"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colTpNo.setCellValueFactory(new PropertyValueFactory<>("tpNo"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colDb.setCellValueFactory(new PropertyValueFactory<>("date"));
        colOption.setCellValueFactory(new PropertyValueFactory<>("btn"));
        searcEmployee(searchText);



        txtSearch.textProperty()
                .addListener((observable, oldValue, newValue) -> {
                    searchText=newValue;
                    searcEmployee(searchText);

                });

    }

    private void searcEmployee(String text) {




            String searchText="%"+text+"%";

            ObservableList<EmployeeTm> tmList= FXCollections.observableArrayList();

        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();

            PreparedStatement statement = connection.prepareStatement("SELECT  * FROM employee WHERE emp_id LIKE ? || name  LIKE ?");
            statement.setObject(1,searchText);
            statement.setObject(2,searchText);
            ResultSet set = statement.executeQuery();

            while (set.next()){

                Button btn = new Button("Delete");
                btn.setStyle("-fx-background-color : red");


                EmployeeTm tm=new EmployeeTm(
                        set.getString(1),
                        set.getString(2),
                        set.getString(3),
                        set.getString(4),
                        set.getDouble(5),
                        set.getString(6),
                        set.getString(7),
                        set.getString(8),

                        btn
                );
                tmList.add(tm);

                btn.setOnAction(event -> {

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you Shuar delete this Employee ? ",
                            ButtonType.YES, ButtonType.NO);

                    Optional<ButtonType> buttonType = alert.showAndWait();
                    if (buttonType.get() == ButtonType.YES) {


                        try {

                            Connection connection1 = DBConnection.getInstance().getConnection();
                            PreparedStatement statement1 = connection1.prepareStatement("DELETE FROM employee WHERE  emp_id=?");
                            statement1.setObject(1,tm.getEmpId());


                            if (  statement1.executeUpdate() >0 ) {
                                searcEmployee(searchText);
                                new Alert(Alert.AlertType.INFORMATION, "Employee Deleted!!").show();

                            } else {
                                new Alert(Alert.AlertType.WARNING, "Try Again !!!").show();
                            }


                        } catch (ClassNotFoundException | SQLException e) {
                            e.printStackTrace();
                        }







                    }








                });



                tblEmployee.setItems(tmList );




            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public void backImgOnClickAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.MANAGEEMPLOYEE,pane);
    }
}
