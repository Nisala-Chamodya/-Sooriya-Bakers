package lk.blacky.bakerymanagement.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.blacky.bakerymanagement.model.EmployeeModel;
import lk.blacky.bakerymanagement.to.Employee;
import lk.blacky.bakerymanagement.util.Navigation;
import lk.blacky.bakerymanagement.util.Routes;

import java.io.IOException;
import java.sql.SQLException;

import static lk.blacky.bakerymanagement.util.Validator.*;

public class ManageEmployeeFormController {
    public AnchorPane pane;

    public JFXTextField txtName;
    public JFXTextField txtSalary;
    public JFXTextField txtEmpId;
    public JFXTextField txtTpNo;
    public JFXTextField txtEmail;
    public JFXTextField txtGender;
    public JFXTextField txtDivision;
    public JFXTextField txtDateOfBirth;


    public void backImgClickOnAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.ADMINDASHBOARD,pane);

    }

    public void btnAddEmployeeOnAction(ActionEvent actionEvent) {
        if(isEmployeeIdMatcher(txtEmpId.getText())){
            if (isNameMatch(txtName.getText())){
                if (isGenderMatcher(txtGender.getText())){
                    if (isDevisionMatcher(txtDivision.getText())){
                        if (isPriceMatcher(txtSalary.getText())){
                            if (isAgeMatch(txtTpNo.getText())){
                                if (isEmailMatch(txtEmail.getText())){
                                    if (isBirthdayMatcher(txtDateOfBirth.getText())){


        String empId = txtEmpId.getText();
        String name = txtName.getText();
        String gender = txtGender.getText();
        String division = txtDivision.getText();
        double salary = Double.parseDouble(txtSalary.getText());
        String tpNo=txtTpNo.getText();
        String email=txtEmail.getText();
        String date=txtDateOfBirth.getText();



        Employee employee = new Employee(empId,name,gender,division,salary,tpNo,email,date);

        try {
            boolean isAdded = EmployeeModel.addEmployee(employee);
            if (isAdded){

                new Alert(Alert.AlertType.CONFIRMATION, "Employee Added!").show();

            }else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }              }else {
                                        new Alert(Alert.AlertType.ERROR, "Pleace Insert Valid Valid Date of birth \n 2002-06-20").show();
                                        txtDateOfBirth.setStyle("-jfx-unfocus-color : red");
                                    }

                            }else {
                                    new Alert(Alert.AlertType.ERROR, "Pleace Insert Valid Valid Email \n  blacky2002@gmail.com ").show();
                                    txtEmail.setStyle("-jfx-unfocus-color : red");
                                }
                            }else {
                                new Alert(Alert.AlertType.ERROR, "Pleace Insert Valid Tp No ").show();
                                txtTpNo.setStyle("-jfx-unfocus-color : red");
                            }

                        }else {
                            new Alert(Alert.AlertType.ERROR, "Pleace Insert Valid Amount \n 5000.00 ").show();
                            txtSalary.setStyle("-jfx-unfocus-color : red");
                        }

                    }else {
                        new Alert(Alert.AlertType.ERROR, "Pleace Insert Valid Division \n bakery,financial or cleaning ").show();
                        txtDivision.setStyle("-jfx-unfocus-color : red");
                    }

            }else {
                    new Alert(Alert.AlertType.ERROR, "Pleace Insert Valid Data\n Male or Female ").show();
                    txtGender.setStyle("-jfx-unfocus-color : red");
                }

        }else {
                new Alert(Alert.AlertType.ERROR, "Pleace Insert Valid Name").show();
                txtName.setStyle("-jfx-unfocus-color : red");
            }

    }else{
            new Alert(Alert.AlertType.ERROR, "Please check the Valid Emp_Id. \n(E-001) Like That").show();
            txtEmpId.setStyle("-jfx-unfocus-color : red");
        }


    }

    public void btnClearOnAction(ActionEvent actionEvent) {
            txtEmpId.clear();
            txtName.clear();
            txtGender.clear();
            txtDivision.clear();
             txtSalary.clear();
            txtTpNo.clear();
              txtEmail.clear();
              txtDateOfBirth.clear();




    }

    public void btnSearchOnAction(ActionEvent actionEvent) {
        try {
            Employee employee= EmployeeModel.searchEmployee(txtEmpId.getText());

            if (employee==null){
                new Alert(Alert.AlertType.INFORMATION,"Employee Not Found").show();


            }else {
                txtName.setText(employee.getName());
                txtGender.setText(employee.getGender());
                txtDivision.setText(employee.getDivision());
                txtSalary.setText(String.valueOf(employee.getSalary()));
                txtTpNo.setText(employee.getTpNo());
                txtEmail.setText(employee.getEmail());
                txtDateOfBirth.setText(employee.getDate());

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void btnUpdateEmployeeOnAction(ActionEvent actionEvent) {




        if(isEmployeeIdMatcher(txtEmpId.getText())){
            if (isNameMatch(txtName.getText())){
                if (isGenderMatcher(txtGender.getText())){
                    if (isDevisionMatcher(txtDivision.getText())){
                        if (isPriceMatcher(txtSalary.getText())){
                            if (isAgeMatch(txtTpNo.getText())){
                                if (isEmailMatch(txtEmail.getText())){
                                    if (isBirthdayMatcher(txtDateOfBirth.getText())){









        String empId = txtEmpId.getText();
        String name = txtName.getText();
        String gender = txtGender.getText();
        String division = txtDivision.getText();
        double salary = Double.parseDouble(txtSalary.getText());
        String tpNo=txtTpNo.getText();
        String email=txtEmail.getText();
        String date=txtDateOfBirth.getText();


        Employee employee = new Employee(empId,name,gender,division,salary,tpNo,email,date);

        try {
            boolean isAdded = EmployeeModel.updateEmployee(employee);
            if (isAdded){

                new Alert(Alert.AlertType.CONFIRMATION, "Employee Updated!").show();

            }else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

                                    }else {
                                        new Alert(Alert.AlertType.ERROR, "Pleace Insert Valid Valid Date of birth \n 2002-06-20").show();
                                        txtDateOfBirth.setStyle("-jfx-unfocus-color : red");
                                    }

                                }else {
                                    new Alert(Alert.AlertType.ERROR, "Pleace Insert Valid Valid Email \n  blacky2002@gmail.com ").show();
                                    txtEmail.setStyle("-jfx-unfocus-color : red");
                                }
                            }else {
                                new Alert(Alert.AlertType.ERROR, "Pleace Insert Valid Tp No ").show();
                                txtTpNo.setStyle("-jfx-unfocus-color : red");
                            }

                        }else {
                            new Alert(Alert.AlertType.ERROR, "Pleace Insert Valid Amount \n 5000.00 ").show();
                            txtSalary.setStyle("-jfx-unfocus-color : red");
                        }

                    }else {
                        new Alert(Alert.AlertType.ERROR, "Pleace Insert Valid Division \n bakery,financial or cleaning ").show();
                        txtDivision.setStyle("-jfx-unfocus-color : red");
                    }

                }else {
                    new Alert(Alert.AlertType.ERROR, "Pleace Insert Valid Data\n Male or Female ").show();
                    txtGender.setStyle("-jfx-unfocus-color : red");
                }

            }else {
                new Alert(Alert.AlertType.ERROR, "Pleace Insert Valid Name").show();
                txtName.setStyle("-jfx-unfocus-color : red");
            }

        }else{
            new Alert(Alert.AlertType.ERROR, "Please check the Valid Emp_Id. \n(E-001) Like That").show();
            txtEmpId.setStyle("-jfx-unfocus-color : red");
        }





    }

    public void btnDeleteEmployeeOnAction(ActionEvent actionEvent) {


        try {
            boolean isDeleted=   EmployeeModel.deleteEmployee(txtEmpId.getText());
            if (isDeleted){
                new Alert(Alert.AlertType.INFORMATION,"Employee  Deleted Successfully!").show();

            }else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void btnEmployeeViewOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ADMINEMPLOYEEVIEW,pane);
    }
}
