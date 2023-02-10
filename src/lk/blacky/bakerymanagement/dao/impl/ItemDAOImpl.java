package lk.blacky.bakerymanagement.dao.impl;

import lk.blacky.bakerymanagement.dao.custom.ItemDAO;
import lk.blacky.bakerymanagement.dto.ItemDTO;
import lk.blacky.bakerymanagement.entity.ItemEntity;
import lk.blacky.bakerymanagement.util.CRUDUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemDAOImpl implements ItemDAO {
       public  boolean add(ItemEntity item) {
        String sql = "INSERT INTO item VALUES (?, ?, ?, ?)";
       try {
            return CRUDUtil.execute(sql, item.getItemId(), item.getBrand(), item.getDescription(), item.getAvailability());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ItemEntity search(String itemId) {

     String sql = "SELECT * FROM item WHERE  item_id=? ";
       ResultSet resultSet = null;
        try {
            resultSet = CRUDUtil.execute(sql, itemId);
       } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            if (resultSet.next()) {
                return new ItemEntity(
                        resultSet.getString(1),
                       resultSet.getString(2),
                     resultSet.getString(3),
                     resultSet.getInt(4)
                         );



           }
       } catch (SQLException e) {
            e.printStackTrace(); }
        return null;
   }

    public  boolean update(ItemEntity item) {String sql = "UPDATE item SET brand=?,description=?,availabilty=? WHERE  item_id=? ";
        try {
            return CRUDUtil.execute(sql, item.getBrand(), item.getDescription(), item.getAvailability(), item.getItemId());
       } catch (SQLException e) {
           e.printStackTrace();
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
        }
        return false;
    }
   public  boolean delete(String itemId)  {
        String sql = "DELETE FROM item WHERE item_id=? ";
      try {
         return CRUDUtil.execute(sql, itemId);
       } catch (SQLException e) {
           e.printStackTrace();
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
       }
        return false;
   }
}
