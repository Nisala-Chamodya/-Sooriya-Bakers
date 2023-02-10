package lk.blacky.bakerymanagement.bo.custom.impl;

import lk.blacky.bakerymanagement.dao.DAOFactory;
import lk.blacky.bakerymanagement.dao.custom.ItemDAO;
import lk.blacky.bakerymanagement.dto.ItemDTO;
import lk.blacky.bakerymanagement.entity.ItemEntity;

import java.sql.SQLException;

public class ItemBOImpl implements ItemBo {
    //dependancy Injection
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);
    @Override
    public boolean AddItem(ItemDTO item) throws SQLException, ClassNotFoundException {
        return itemDAO.add(new ItemEntity(item.getItemId(),item.getBrand(),item.getDescription(),item.getAvailability()));
    }

    @Override
    public ItemDTO searchItem(String itemId) {
        ItemEntity search = itemDAO.search(itemId);

        return  new ItemDTO(search.getItemId(),search.getBrand(),search.getDescription(),search.getAvailability());
    }

    @Override
    public boolean updateItem(ItemDTO item) {
        return itemDAO.update(new ItemEntity(item.getItemId(),item.getBrand(),item.getDescription(),item.getAvailability()));
    }

    @Override
    public boolean deleteItem(String itemId) {
        return itemDAO.delete(itemId);
    }
}
