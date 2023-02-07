package lk.blacky.bakerymanagement.dao.custom.impl;

import lk.blacky.bakerymanagement.to.Customer;
import lk.blacky.bakerymanagement.to.Employee;

public interface  CRUDDAO <T,ID>{
    boolean add(T dto);
    boolean update(T dto);
    T search(ID id);
    boolean delete(ID id);
}
