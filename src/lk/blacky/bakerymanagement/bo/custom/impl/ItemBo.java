package lk.blacky.bakerymanagement.bo.custom.impl;

import lk.blacky.bakerymanagement.dto.ItemDTO;
import lk.blacky.bakerymanagement.to.Item;

import java.sql.SQLException;

public interface ItemBo extends SuperBo{
    public  boolean AddItem(ItemDTO item) throws SQLException, ClassNotFoundException;
    public  ItemDTO searchItem(String itemId);
    public  boolean updateItem(ItemDTO item);
    public  boolean deleteItem(String itemId);
}
