package lk.blacky.bakerymanagement.dao.impl;

import lk.blacky.bakerymanagement.dao.custom.AdminDAO;
import lk.blacky.bakerymanagement.db.DBConnection;
import lk.blacky.bakerymanagement.to.Admin;
import lk.blacky.bakerymanagement.util.CRUDUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminDAOImpl implements AdminDAO  {
    public  boolean addAdmin(Admin admin)  {
        String sql = "INSERT INTO admin VALUES (?, ?)";
        try {
            return CRUDUtil.execute(sql, admin.getUserName(),admin.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
       return false;
    }

    public  boolean updateAdmin(Admin admin)  {

        String sql = "UPDATE admin SET password=? WHERE  user_name=? ";
        try {
            return CRUDUtil.execute(sql, admin.getPassword(),admin.getUserName());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

return false;
    }
    public ArrayList<Admin> checkAdminPassword() throws SQLException {

        ResultSet rs = null;
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            rs = connection.createStatement().executeQuery("SELECT * FROM admin");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Admin> allAdmin=new ArrayList<>();
         while (rs.next()){
             String userName=rs.getString(1);
             String password=rs.getString(2);
             allAdmin.add(new Admin(userName,password));

         }
         return allAdmin;



    }
}


