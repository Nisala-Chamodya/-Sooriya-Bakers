package lk.blacky.bakerymanagement.dao.custom;

import lk.blacky.bakerymanagement.to.Item;

public interface ItemDAO {
    public  boolean AddItem(Item item);
    public  Item searchItem(String itemId);
    public  boolean updateItem(Item item);
    public  boolean deleteItem(String itemId);
}
