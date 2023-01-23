package lk.blacky.bakerymanagement.model;

import lk.blacky.bakerymanagement.to.Customer;
import lk.blacky.bakerymanagement.to.Item;
import lk.blacky.bakerymanagement.util.CRUDUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemModel {
    public static boolean AddItem(Item item) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO item VALUES (?, ?, ?, ?)";
        return CRUDUtil.execute(sql, item.getItemId(), item.getBrand(), item.getDescription(), item.getAvailability());
    }

    public static Item searchItem(String itemId) throws SQLException, ClassNotFoundException {

        String sql = "SELECT * FROM item WHERE  item_id=? ";
        ResultSet resultSet = CRUDUtil.execute(sql, itemId);
        if (resultSet.next()) {
            return new Item(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4)
                     );





        }
        return null;
    }

    public static boolean updateItem(Item item) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE item SET brand=?,description=?,availabilty=? WHERE  item_id=? ";
        return CRUDUtil.execute(sql, item.getBrand(), item.getDescription(), item.getAvailability(), item.getItemId());

    }

    public static boolean deleteItem(String itemId) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM item WHERE item_id=? ";
        return CRUDUtil.execute(sql, itemId);

    }
}
