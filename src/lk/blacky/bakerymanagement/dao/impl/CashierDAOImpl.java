package lk.blacky.bakerymanagement.dao.impl;

import lk.blacky.bakerymanagement.dao.custom.CashierDAO;
import lk.blacky.bakerymanagement.to.Cashier;
import lk.blacky.bakerymanagement.util.CRUDUtil;

import java.sql.SQLException;

public class CashierDAOImpl implements CashierDAO {
    public  boolean addCashier(Cashier cashier) {
        String sql = "INSERT INTO cashier VALUES (?, ?)";
        try {
            return CRUDUtil.execute(sql, cashier.getUserName(),cashier.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public  boolean updateCashier(Cashier cashier)  {
        String sql = "UPDATE cashier SET password=? WHERE  user_name=? ";
        try {
            return CRUDUtil.execute(sql, cashier.getPassword(),cashier.getUserName());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
