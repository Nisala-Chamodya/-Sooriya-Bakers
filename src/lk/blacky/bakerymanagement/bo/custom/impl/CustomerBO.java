package lk.blacky.bakerymanagement.bo.custom.impl;

import lk.blacky.bakerymanagement.dto.CustomerDTO;
import lk.blacky.bakerymanagement.entity.CustomerEntity;
import lk.blacky.bakerymanagement.to.Customer;

import java.sql.SQLException;

public interface CustomerBO extends  SuperBo{

    boolean addCustomer(CustomerDTO customer) throws SQLException, ClassNotFoundException;
    boolean updateCustomer(CustomerDTO customer);
    CustomerDTO searchCustomer(String custId);
    boolean deleteCustomer(String custId);
}
