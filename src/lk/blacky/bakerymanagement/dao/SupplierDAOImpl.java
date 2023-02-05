package lk.blacky.bakerymanagement.dao;

import lk.blacky.bakerymanagement.to.Supplier;
import lk.blacky.bakerymanagement.util.CRUDUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SupplierDAOImpl {

    public static boolean AddSupplier(Supplier supplier) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO supplier VALUES (?, ?, ?, ?,?)";
        return CRUDUtil.execute(sql, supplier.getSupplierId(), supplier.getName(), supplier.getAddress(),
                supplier.getTpNo(), supplier.geteMail());
    }

    public static Supplier searchSupplier(String supplierId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM supplier WHERE  supplier_id=? ";
        ResultSet resultSet = CRUDUtil.execute(sql, supplierId);
        if (resultSet.next()) {
            return new Supplier(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5) );





        }
        return null;
    }

    public static boolean deleteSupplier(String supplierId) throws SQLException, ClassNotFoundException {

        String sql = "DELETE FROM supplier WHERE supplier_id=? ";
        return CRUDUtil.execute(sql, supplierId);
    }

    public static boolean updateSupplier(Supplier supplier) throws SQLException, ClassNotFoundException {

        String sql = "UPDATE supplier SET name=?,address=?,tp_no=?,e_mail=? WHERE  supplier_id=? ";
        return CRUDUtil.execute(sql, supplier.getName(), supplier.getAddress(), supplier.getTpNo(),
                supplier.geteMail(), supplier.getSupplierId());
    }
}
