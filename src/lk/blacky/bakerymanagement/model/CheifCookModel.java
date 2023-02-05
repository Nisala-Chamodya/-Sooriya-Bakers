package lk.blacky.bakerymanagement.model;

import lk.blacky.bakerymanagement.to.CheifCook;
import lk.blacky.bakerymanagement.util.CRUDUtil;

import java.sql.SQLException;

public class CheifCookModel {
    public static boolean addCheifCook(CheifCook cheifCook) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO cheif_cook VALUES (?, ?)";
        return CRUDUtil.execute(sql, cheifCook.getUserName(),cheifCook.getPassword());
    }

    public static boolean updateCheifCook(CheifCook cheifCook) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE cheif_cook SET password=? WHERE  user_name=? ";
        return CRUDUtil.execute(sql, cheifCook.getPassword(),cheifCook.getUserName());
    }
}
