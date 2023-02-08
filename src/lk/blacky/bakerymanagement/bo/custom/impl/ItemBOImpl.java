package lk.blacky.bakerymanagement.bo.custom.impl;

import lk.blacky.bakerymanagement.dao.DAOFactory;
import lk.blacky.bakerymanagement.dao.custom.CustomerDAO;
import lk.blacky.bakerymanagement.dao.custom.ItemDAO;
import lk.blacky.bakerymanagement.dto.ItemDTO;
import lk.blacky.bakerymanagement.to.Customer;
import lk.blacky.bakerymanagement.to.Item;

public class ItemBOImpl implements ItemBo {
    //dependancy Injection
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);
    @Override
    public boolean AddItem(ItemDTO item) {
        return itemDAO.AddItem(new Item(item.getItemId(),item.getBrand(),item.getDescription(),item.getAvailability()));
    }

    @Override
    public Item searchItem(String itemId) {
        return  itemDAO.searchItem(itemId);
    }

    @Override
    public boolean updateItem(ItemDTO item) {
        return itemDAO.updateItem(new Item(item.getItemId(),item.getBrand(),item.getDescription(),item.getAvailability()));
    }

    @Override
    public boolean deleteItem(String itemId) {
        return itemDAO.deleteItem(itemId);
    }
}
