package lk.blacky.bakerymanagement.dao.custom.impl;

import lk.blacky.bakerymanagement.to.Customer;

public interface CRUDDAO {
    boolean Add(Customer customer);
    boolean update(Customer customer);
    Customer search(String custId);
    boolean delete(String custId);
}
