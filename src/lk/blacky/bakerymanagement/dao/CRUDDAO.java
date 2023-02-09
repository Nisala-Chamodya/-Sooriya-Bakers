package lk.blacky.bakerymanagement.dao;

public interface  CRUDDAO <T,ID> extends SuperDAO{
    boolean add(T dto);
    boolean update(T dto);
    T search(ID id);
    boolean delete(ID id);
}
