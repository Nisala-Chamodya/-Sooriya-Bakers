package lk.blacky.bakerymanagement.bo.custom.impl;

import lk.blacky.bakerymanagement.dao.DAOFactory;
import lk.blacky.bakerymanagement.dao.custom.CustomerDAO;
import lk.blacky.bakerymanagement.dto.CustomerDTO;
import lk.blacky.bakerymanagement.entity.CustomerEntity;

import java.sql.SQLException;

public class CustomerBOImpl implements CustomerBO {
    //dipendancy injection
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    public CustomerBOImpl() {
        super();
    }

    @Override
    public boolean addCustomer(CustomerDTO customer) throws SQLException, ClassNotFoundException {
        return customerDAO.add(new CustomerEntity(customer.getCustId(),customer.getName(),customer.getNic(),customer.getAddress(),customer.getTpNo()));
    }

    @Override
    public boolean updateCustomer(CustomerDTO customer) {
        return customerDAO.update(new CustomerEntity(customer.getCustId(),customer.getName(),customer.getNic(),customer.getAddress(),customer.getTpNo()));
    }

    @Override
    public CustomerDTO searchCustomer(String custId) {
        CustomerEntity search = customerDAO.search(custId);
        return new CustomerDTO(search.getCust_Id(),search.getName(),search.getNic(),search.getAddress(),search.getTpNo());
    }

    @Override
    public boolean deleteCustomer(String custId) {
        return
                customerDAO.delete(custId);
    }
}
