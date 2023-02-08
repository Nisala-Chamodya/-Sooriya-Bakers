package lk.blacky.bakerymanagement.dao;

import lk.blacky.bakerymanagement.dao.custom.CheifCookDAO;
import lk.blacky.bakerymanagement.to.CheifCook;
import lk.blacky.bakerymanagement.util.CRUDUtil;

import java.sql.SQLException;

public class CheifCookDAOImpl implements CheifCookDAO {
    public  boolean addCheifCook(CheifCook cheifCook) {
        String sql = "INSERT INTO cheif_cook VALUES (?, ?)";
        try {
            return CRUDUtil.execute(sql, cheifCook.getUserName(),cheifCook.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public  boolean updateCheifCook(CheifCook cheifCook) {
        String sql = "UPDATE cheif_cook SET password=? WHERE  user_name=? ";
        try {
            return CRUDUtil.execute(sql, cheifCook.getPassword(),cheifCook.getUserName());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }
        return false;
    }

}
