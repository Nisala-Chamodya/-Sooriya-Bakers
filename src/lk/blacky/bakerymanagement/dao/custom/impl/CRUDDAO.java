package lk.blacky.bakerymanagement.dao.custom.impl;

import lk.blacky.bakerymanagement.to.Customer;

public interface CRUDDAO <T,ID>{
    boolean Add(T dto);
    boolean update(T dto);
    Customer search(ID id);
    boolean delete(ID id);
}
