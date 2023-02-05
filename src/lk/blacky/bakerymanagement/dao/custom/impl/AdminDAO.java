package lk.blacky.bakerymanagement.dao.custom.impl;

import lk.blacky.bakerymanagement.db.DBConnection;
import lk.blacky.bakerymanagement.to.Admin;
import lk.blacky.bakerymanagement.util.CRUDUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface AdminDAO {


    public  boolean addAdmin(Admin admin) ;

    public  boolean updateAdmin(Admin admin) ;





    public  ArrayList<Admin> checkAdminPassword() throws SQLException, ClassNotFoundException;











    }

