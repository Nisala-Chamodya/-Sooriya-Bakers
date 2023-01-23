package lk.blacky.bakerymanagement.model;

import lk.blacky.bakerymanagement.to.Recipe;
import lk.blacky.bakerymanagement.to.Stock;
import lk.blacky.bakerymanagement.util.CRUDUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StockModel {
    public static boolean addDetails(Stock stock) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO item_supplier VALUES (?, ?, ?,?)";
        return CRUDUtil.execute(sql, stock.getSupplierId(),
                stock.getItemId(), stock.getBrand(),stock.getAvailability());

    }

    public static boolean updateStockDetails(Stock stock) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE item_supplier SET item_id=?,brand=?,availability=?  WHERE  supplier_id=? ";
        return CRUDUtil.execute(sql, stock.getItemId(), stock.getBrand(), stock.getAvailability(),stock.getSupplierId());
    }

    public static Stock searchStockDetails(String supplierId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM item_supplier WHERE supplier_id=? ";
        ResultSet resultSet = CRUDUtil.execute(sql,supplierId);
        if (resultSet.next()) {
            return new Stock(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4)

            );





        }
        return null;



    }

    public static boolean deleteStockDetails(String supplierId) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM item_supplier WHERE supplier_id=? ";
        return CRUDUtil.execute(sql, supplierId);
    }
}
