package lk.blacky.bakerymanagement.dao;

import java.sql.SQLException;

public interface  CRUDDAO <T,ID> extends SuperDAO{
    boolean add(T dto) throws SQLException, ClassNotFoundException;
    boolean update(T dto);
    T search(ID id);
    boolean delete(ID id);
}
