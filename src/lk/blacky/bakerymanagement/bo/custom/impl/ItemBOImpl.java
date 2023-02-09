package lk.blacky.bakerymanagement.bo.custom.impl;

import lk.blacky.bakerymanagement.dao.DAOFactory;
import lk.blacky.bakerymanagement.dao.custom.ItemDAO;
import lk.blacky.bakerymanagement.dto.ItemDTO;

public class ItemBOImpl implements ItemBo {
    //dependancy Injection
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);
    @Override
    public boolean AddItem(ItemDTO item) {
        return itemDAO.add(new ItemDTO(item.getItemId(),item.getBrand(),item.getDescription(),item.getAvailability()));
    }

    @Override
    public ItemDTO searchItem(String itemId) {
        return  itemDAO.search(itemId);
    }

    @Override
    public boolean updateItem(ItemDTO item) {
        return itemDAO.update(new ItemDTO(item.getItemId(),item.getBrand(),item.getDescription(),item.getAvailability()));
    }

    @Override
    public boolean deleteItem(String itemId) {
        return itemDAO.delete(itemId);
    }
}
