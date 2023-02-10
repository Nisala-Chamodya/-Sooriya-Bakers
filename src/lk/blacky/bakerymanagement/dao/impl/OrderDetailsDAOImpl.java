package lk.blacky.bakerymanagement.dao.impl;

import lk.blacky.bakerymanagement.dao.custom.OrderDetailsDAO;
import lk.blacky.bakerymanagement.db.DBConnection;
import lk.blacky.bakerymanagement.entity.OrderDetailsEntity;
import lk.blacky.bakerymanagement.util.CRUDUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderDetailsDAOImpl implements OrderDetailsDAO {
    @Override
    public boolean add(OrderDetailsEntity dto) throws SQLException, ClassNotFoundException {
        CRUDUtil.execute("INSERT `order_details` VALUES (?,?,?,?)",
                dto.getOrderID(),
                dto.getProductID(),
                dto.getAvailability(),
                dto.getUnitPrice());
        return true;

    }

    @Override
    public boolean update(OrderDetailsEntity dto) {
        throw new UnsupportedOperationException("This feature is not implemented yet");
    }

    @Override
    public OrderDetailsEntity search(String s) {
        throw new UnsupportedOperationException("This feature is not implemented yet");
    }

    @Override
    public boolean delete(String s) {
        throw new UnsupportedOperationException("This feature is not implemented yet");
    }
}
