package lk.blacky.bakerymanagement.bo.custom.impl;

import lk.blacky.bakerymanagement.dto.ItemDTO;
import lk.blacky.bakerymanagement.to.Item;

public interface ItemBo extends SuperBo{
    public  boolean AddItem(ItemDTO item);
    public  ItemDTO searchItem(String itemId);
    public  boolean updateItem(ItemDTO item);
    public  boolean deleteItem(String itemId);
}
