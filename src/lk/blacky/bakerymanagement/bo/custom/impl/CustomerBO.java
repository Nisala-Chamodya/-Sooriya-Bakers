package lk.blacky.bakerymanagement.bo.custom.impl;

import lk.blacky.bakerymanagement.dto.CustomerDTO;
import lk.blacky.bakerymanagement.to.Customer;

public interface CustomerBO extends  SuperBo{

    boolean addCustomer(CustomerDTO customer);
    boolean updateCustomer(CustomerDTO customer);
    CustomerDTO searchCustomer(String custId);
    boolean deleteCustomer(String custId);
}
