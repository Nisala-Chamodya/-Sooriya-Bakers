package lk.blacky.bakerymanagement.dao;

import lk.blacky.bakerymanagement.db.DBConnection;
import lk.blacky.bakerymanagement.to.Admin;
import lk.blacky.bakerymanagement.util.CRUDUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminDAOImpl {
    public static boolean addAdmin(Admin admin) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO admin VALUES (?, ?)";
        return CRUDUtil.execute(sql, admin.getUserName(),admin.getPassword());

    }

    public static boolean updateAdmin(Admin admin) throws SQLException, ClassNotFoundException {

        String sql = "UPDATE admin SET password=? WHERE  user_name=? ";
        return CRUDUtil.execute(sql, admin.getPassword(),admin.getUserName());


    }
    public static ArrayList<Admin> checkAdminPassword() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
         ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM admin");
         ArrayList<Admin> allAdmin=new ArrayList<>();
         while (rs.next()){
             String userName=rs.getString(1);
             String password=rs.getString(2);
             allAdmin.add(new Admin(userName,password));

         }
         return allAdmin;



    }
}


