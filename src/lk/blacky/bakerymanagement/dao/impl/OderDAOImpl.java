package lk.blacky.bakerymanagement.dao.impl;

import lk.blacky.bakerymanagement.dao.custom.OrderDAO;
import lk.blacky.bakerymanagement.dto.OrderDTO;
import lk.blacky.bakerymanagement.entity.OrderEntity;
import lk.blacky.bakerymanagement.util.CRUDUtil;

import java.sql.SQLException;

public class OderDAOImpl implements OrderDAO {

    @Override
    public boolean add(OrderEntity entity) throws SQLException, ClassNotFoundException {
        System.out.println(entity.getOrderID());
        return CRUDUtil.execute("INSERT orders VALUES (?,?,?,?)",
                entity.getOrderID(),
                entity.getDate(),
                entity.getTotalCost(),
                entity.getCustomerID());
    }

    @Override
    public boolean update(OrderEntity entity) {
        throw new UnsupportedOperationException("This Feature is not implemented yet");
    }

    @Override
    public OrderEntity search(String s) {
        throw new UnsupportedOperationException("This Feature is not implemented yet");
    }

    @Override
    public boolean delete(String s) {
        throw new UnsupportedOperationException("This Feature is not implemented yet");
    }
}
