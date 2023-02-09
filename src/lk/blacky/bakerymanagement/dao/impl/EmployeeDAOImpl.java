package lk.blacky.bakerymanagement.dao.impl;

import lk.blacky.bakerymanagement.dao.custom.EmployeeDAO;
import lk.blacky.bakerymanagement.dto.EmployeeDTO;
import lk.blacky.bakerymanagement.util.CRUDUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAOImpl implements EmployeeDAO {

     public  boolean add(EmployeeDTO employee) {
        String sql = "INSERT INTO employee VALUES (?, ?, ?, ?,?,?,?,?)";
        try {
            return CRUDUtil.execute(sql, employee.getEmpId(), employee.getName(), employee.getGender(),
                    employee.getDivision(), employee.getSalary(),employee.getTpNo(),employee.getEmail(),employee.getDate());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
return false;
    }



    public  boolean update(EmployeeDTO employee) {
        String sql = "UPDATE employee SET name=?,gender=?,devition=?,salary=?,tp_no=?,e_mail=?,dob=? WHERE  emp_id=? ";
        try {
            return CRUDUtil.execute(sql, employee.getName(), employee.getGender(),

                    employee.getDivision(), employee.getSalary(),employee.getTpNo(),
                    employee.getEmail(),employee.getDate(),employee.getEmpId());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;

    }







    public EmployeeDTO search(String empId) {
        String sql = "SELECT * FROM employee WHERE  emp_id=? ";
        ResultSet resultSet = null;
        try {
            resultSet = CRUDUtil.execute(sql, empId);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            if (resultSet.next()) {
                return new EmployeeDTO(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getDouble(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8)



                        );





            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



    public  boolean delete(String empId)  {

        String sql = "DELETE FROM employee WHERE emp_id=? ";
        try {
            return CRUDUtil.execute(sql, empId);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
return false;
    }
}
