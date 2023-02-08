package lk.blacky.bakerymanagement.bo.custom.impl;

import lk.blacky.bakerymanagement.dao.DAOFactory;
import lk.blacky.bakerymanagement.dao.custom.CustomerDAO;
import lk.blacky.bakerymanagement.dto.CustomerDTO;
import lk.blacky.bakerymanagement.to.Customer;
import rex.utils.S;

public class CustomerBOImpl implements CustomerBO {
    //dipendancy injection
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    public CustomerBOImpl() {
        super();
    }

    @Override
    public boolean addCustomer(CustomerDTO customer) {
        return customerDAO.AddCustomer(new Customer(customer.getCustId(),customer.getName(),customer.getNic(),customer.getAddress(),customer.getTpNo()));
    }

    @Override
    public boolean updateCustomer(CustomerDTO customer) {
        return customerDAO.updateCustomer(new Customer(customer.getCustId(),customer.getName(),customer.getNic(),customer.getAddress(),customer.getTpNo()));
    }

    @Override
    public Customer searchCustomer(String custId) {
        return customerDAO.searchCustomer(custId);
    }

    @Override
    public boolean deleteCustomer(String custId) {
        return customerDAO.deleteCustomer(custId);
    }
}
