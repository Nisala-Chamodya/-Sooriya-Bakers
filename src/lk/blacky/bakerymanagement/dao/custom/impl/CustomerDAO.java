package lk.blacky.bakerymanagement.dao.custom.impl;

import lk.blacky.bakerymanagement.to.Customer;

public interface CustomerDAO {

    public  boolean AddCustomer(Customer customer);
    public  boolean updateCustomer(Customer customer);
    public  Customer searchCustomer(String custId);
    public  boolean deleteCustomer(String custId);






}
