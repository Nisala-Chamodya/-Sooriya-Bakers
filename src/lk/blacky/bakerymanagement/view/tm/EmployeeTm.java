package lk.blacky.bakerymanagement.view.tm;

import javafx.scene.control.Button;

public class EmployeeTm {
    private String empId;
    private String name ;
    private String gender;
    private  String division;
    private double salary ;
    private String tpNo;
    private String email;
    private String date;
    private Button btn;

    public EmployeeTm() {
    }

    public EmployeeTm(String empId, String name, String gender, String division, double salary, String tpNo, String email, String date, Button btn) {
        this.empId = empId;
        this.name = name;
        this.gender = gender;
        this.division = division;
        this.salary = salary;
        this.tpNo = tpNo;
        this.email = email;
        this.date = date;
        this.btn = btn;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getTpNo() {
        return tpNo;
    }

    public void setTpNo(String tpNo) {
        this.tpNo = tpNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
}
