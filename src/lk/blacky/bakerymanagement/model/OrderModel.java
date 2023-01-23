package lk.blacky.bakerymanagement.model;

import lk.blacky.bakerymanagement.db.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrderModel {
    public static String getLastOrderId() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT order_id FROM orders ORDER BY order_id DESC LIMIT 1");
        return rst.next() ? rst.getString("order_id") : null;
    }
}
