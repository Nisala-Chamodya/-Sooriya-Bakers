package lk.blacky.bakerymanagement.dao.custom;

import lk.blacky.bakerymanagement.to.Customer;

public interface CustomerDAO  {

      boolean AddCustomer(Customer customer);
      boolean updateCustomer(Customer customer);
      Customer searchCustomer(String custId);
      boolean deleteCustomer(String custId);


}





