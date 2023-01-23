package lk.blacky.bakerymanagement.model;

import lk.blacky.bakerymanagement.to.Customer;
import lk.blacky.bakerymanagement.to.Employee;
import lk.blacky.bakerymanagement.util.CRUDUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeModel {
    public static boolean addEmployee(Employee employee) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO employee VALUES (?, ?, ?, ?,?,?,?,?)";
        return CRUDUtil.execute(sql, employee.getEmpId(), employee.getName(), employee.getGender(),
                employee.getDivision(), employee.getSalary(),employee.getTpNo(),employee.getEmail(),employee.getDate());

    }

    public static Employee searchEmployee(String empId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM employee WHERE  emp_id=? ";
        ResultSet resultSet = CRUDUtil.execute(sql, empId);
        if (resultSet.next()) {
            return new Employee(
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
        return null;
    }

    public static boolean updateEmployee(Employee employee) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE employee SET name=?,gender=?,devition=?,salary=?,tp_no=?,e_mail=?,dob=? WHERE  emp_id=? ";
        return CRUDUtil.execute(sql, employee.getName(), employee.getGender(),

                employee.getDivision(), employee.getSalary(),employee.getTpNo(),
                employee.getEmail(),employee.getDate(),employee.getEmpId());

    }

    public static boolean deleteEmployee(String empId) throws SQLException, ClassNotFoundException {

        String sql = "DELETE FROM employee WHERE emp_id=? ";
        return CRUDUtil.execute(sql, empId);

    }
}
