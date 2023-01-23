package lk.blacky.bakerymanagement.model;

import lk.blacky.bakerymanagement.to.Customer;
import lk.blacky.bakerymanagement.util.CRUDUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerModel {

    public static boolean AddCustomer(Customer customer) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO Customer VALUES (?, ?, ?, ?,?)";
        return CRUDUtil.execute(sql, customer.getCustId(), customer.getName(), customer.getNic(), customer.getAddress(), customer.getTpNo());
    }

    public static boolean updateCustomer(Customer customer) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE Customer SET name=?,nic=?,address=?,tp_no=? WHERE  cust_id=? ";
        return CRUDUtil.execute(sql, customer.getName(), customer.getNic(), customer.getAddress(), customer.getTpNo(), customer.getCustId());

    }

    public static Customer searchCustomer(String custId) throws SQLException, ClassNotFoundException {

        String sql = "SELECT * FROM customer WHERE  cust_id=? ";
        ResultSet resultSet = CRUDUtil.execute(sql, custId);
        if (resultSet.next()) {
            return new Customer(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5) );





        }
        return null;
    }

    public static boolean deleteCustomer(String custId) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM customer WHERE cust_id=? ";
        return CRUDUtil.execute(sql, custId);
    }
}