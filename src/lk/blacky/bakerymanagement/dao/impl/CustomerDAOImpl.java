package lk.blacky.bakerymanagement.dao.impl;

import lk.blacky.bakerymanagement.dao.custom.CustomerDAO;
import lk.blacky.bakerymanagement.dto.CustomerDTO;
import lk.blacky.bakerymanagement.entity.CustomEntity;
import lk.blacky.bakerymanagement.entity.CustomerEntity;
import lk.blacky.bakerymanagement.util.CRUDUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

//customer dao
public class  CustomerDAOImpl implements CustomerDAO {




      public CustomerDAOImpl(){}

    public CustomerDAOImpl(String text) {
    }

    public  boolean add(CustomerEntity customer) {
        String sql = "INSERT INTO Customer VALUES (?, ?, ?, ?,?)";
        try {
            return CRUDUtil.execute(sql, customer.getCust_Id(), customer.getName(), customer.getNic(), customer.getAddress(), customer.getTpNo());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override


    public  boolean update(CustomerEntity customer) {
        String sql = "UPDATE Customer SET name=?,nic=?,address=?,tp_no=? WHERE  cust_id=? ";
        try {
            return CRUDUtil.execute(sql, customer.getName(), customer.getNic(), customer.getAddress(), customer.getTpNo(), customer.getCust_Id());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
return false;
    }

    public  CustomerEntity search(String custId) {

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
                    return new CustomerEntity(
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