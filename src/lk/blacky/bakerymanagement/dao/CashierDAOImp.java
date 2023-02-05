package lk.blacky.bakerymanagement.dao;

import lk.blacky.bakerymanagement.to.Cashier;
import lk.blacky.bakerymanagement.util.CRUDUtil;

import java.sql.SQLException;

public class CashierDAOImp {
    public static boolean addCashier(Cashier cashier) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO cashier VALUES (?, ?)";
        return CRUDUtil.execute(sql, cashier.getUserName(),cashier.getPassword());
    }

    public static boolean updateCashier(Cashier cashier) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE cashier SET password=? WHERE  user_name=? ";
        return CRUDUtil.execute(sql, cashier.getPassword(),cashier.getUserName());
    }
}
