package lk.blacky.bakerymanagement.dao;

import lk.blacky.bakerymanagement.dao.custom.CRUDDAO;
import lk.blacky.bakerymanagement.to.Customer;
import lk.blacky.bakerymanagement.util.CRUDUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

//customer dao
public class  CustomerDAOImpl implements CRUDDAO<Customer,String> {



      public CustomerDAOImpl(){}

    public CustomerDAOImpl(String text) {
    }

    public  boolean add(Customer customer) {
        String sql = "INSERT INTO Customer VALUES (?, ?, ?, ?,?)";
        try {
            return CRUDUtil.execute(sql, customer.getCustId(), customer.getName(), customer.getNic(), customer.getAddress(), customer.getTpNo());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public  boolean update(Customer customer) {
        String sql = "UPDATE Customer SET name=?,nic=?,address=?,tp_no=? WHERE  cust_id=? ";
        try {
            return CRUDUtil.execute(sql, customer.getName(), customer.getNic(), customer.getAddress(), customer.getTpNo(), customer.getCustId());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
return false;
    }

    public  Customer search(String custId) {

        String sql = "SELECT * FROM customer WHERE  cust_id=? ";
        ResultSet resultSet = null;
        try {
            resultSet = CRUDUtil.execute(sql, custId);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            if (resultSet.next()) {
                try {
                    return new Customer(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5));
                } catch (SQLException e) {
                    e.printStackTrace();
                }


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public  boolean delete(String custId) {
        String sql = "DELETE FROM customer WHERE cust_id=? ";
        try {
            return CRUDUtil.execute(sql, custId);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    return false;
    }




}