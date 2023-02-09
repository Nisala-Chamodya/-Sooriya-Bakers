package lk.blacky.bakerymanagement.dao.impl;

import lk.blacky.bakerymanagement.dao.custom.SupplierDAO;
import lk.blacky.bakerymanagement.dto.SupplierDTO;
import lk.blacky.bakerymanagement.util.CRUDUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SupplierDAOImpl implements SupplierDAO {

    public  boolean add(SupplierDTO supplier) {
        String sql = "INSERT INTO supplier VALUES (?, ?, ?, ?,?)";
        try {
            return CRUDUtil.execute(sql, supplier.getSupplierId(), supplier.getName(), supplier.getAddress(),
                    supplier.getTpNo(), supplier.geteMail());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public  SupplierDTO search(String supplierId) {
        String sql = "SELECT * FROM supplier WHERE  supplier_id=? ";
        ResultSet resultSet = null;
        try {
            resultSet = CRUDUtil.execute(sql, supplierId);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            if (resultSet.next()) {
                return new SupplierDTO(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5) );





            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public  boolean delete(String supplierId) {

        String sql = "DELETE FROM supplier WHERE supplier_id=? ";
        try {
            return CRUDUtil.execute(sql, supplierId);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }


    public  boolean update(SupplierDTO supplier)  {

        String sql = "UPDATE supplier SET name=?,address=?,tp_no=?,e_mail=? WHERE  supplier_id=? ";
        try {
            return CRUDUtil.execute(sql, supplier.getName(), supplier.getAddress(), supplier.getTpNo(),
                    supplier.geteMail(), supplier.getSupplierId());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    return false;
    }
}
