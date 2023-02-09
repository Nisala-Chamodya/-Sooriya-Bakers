package lk.blacky.bakerymanagement.bo.custom.impl;

import lk.blacky.bakerymanagement.dao.DAOFactory;
import lk.blacky.bakerymanagement.dao.custom.CustomerDAO;
import lk.blacky.bakerymanagement.dto.CustomerDTO;

public class CustomerBOImpl implements CustomerBO {
    //dipendancy injection
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    public CustomerBOImpl() {
        super();
    }

    @Override
    public boolean addCustomer(CustomerDTO customer) {
        return customerDAO.add(new CustomerDTO(customer.getCustId(),customer.getName(),customer.getNic(),customer.getAddress(),customer.getTpNo()));
    }

    @Override
    public boolean updateCustomer(CustomerDTO customer) {
        return customerDAO.update(new CustomerDTO(customer.getCustId(),customer.getName(),customer.getNic(),customer.getAddress(),customer.getTpNo()));
    }

    @Override
    public CustomerDTO searchCustomer(String custId) {
        return customerDAO.search(custId);
    }

    @Override
    public boolean deleteCustomer(String custId) {
        return customerDAO.delete(custId);
    }
}
