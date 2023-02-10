package lk.blacky.bakerymanagement.entity;

import java.sql.Date;

public class EmployeeEntity {
    private String empId;
    private String name;
    private String gender;
    private String division;
    private double salary;
    private String tpNo;
    private String email;
    private Date date;

    public EmployeeEntity(String empId) {
        this.empId = empId;
    }

    public EmployeeEntity() {
    }

    public EmployeeEntity(String empId, String name, String gender, String division, double salary, String tpNo, String email, Date date) {
        this.empId = empId;
        this.name = name;
        this.gender = gender;
        this.division = division;
        this.salary = salary;
        this.tpNo = tpNo;
        this.email = email;
        this.date = date;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "EmployeeEntity{" +
                "empId='" + empId + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", division='" + division + '\'' +
                ", salary=" + salary +
                ", tpNo='" + tpNo + '\'' +
                ", email='" + email + '\'' +
                ", date=" + date +
                '}';
    }
}
