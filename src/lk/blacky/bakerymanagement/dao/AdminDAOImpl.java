package lk.blacky.bakerymanagement.model;

import lk.blacky.bakerymanagement.to.Admin;
import lk.blacky.bakerymanagement.util.CRUDUtil;

import java.sql.SQLException;

public class AddminModel {
    public static boolean addAdmin(Admin admin) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO admin VALUES (?, ?)";
        return CRUDUtil.execute(sql, admin.getUserName(),admin.getPassword());

    }

    public static boolean updateAdmin(Admin admin) throws SQLException, ClassNotFoundException {

        String sql = "UPDATE admin SET password=? WHERE  user_name=? ";
        return CRUDUtil.execute(sql, admin.getPassword(),admin.getUserName());


    }
}


