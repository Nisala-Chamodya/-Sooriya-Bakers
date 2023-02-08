package lk.blacky.bakerymanagement.bo.custom.impl;

import lk.blacky.bakerymanagement.dao.DAOFactory;
import lk.blacky.bakerymanagement.dao.custom.CustomerDAO;
import lk.blacky.bakerymanagement.dao.custom.SupplierDAO;
import lk.blacky.bakerymanagement.dto.SupplierDTO;
import lk.blacky.bakerymanagement.to.Customer;
import lk.blacky.bakerymanagement.to.Supplier;

public class SupplierBoImpl implements SupplierBo{
    //dipendancy injection
    SupplierDAO supplierDAO = (SupplierDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SUPPLIER);
    @Override
    public boolean AddSupplier(SupplierDTO supplier) {
        return supplierDAO.AddSupplier(new Supplier(supplier.getSupplierId(),supplier.getName(),supplier.getAddress(),supplier.getTpNo(),supplier.geteMail()));
    }

    @Override
    public Supplier searchSupplier(String supplierId) {
        return supplierDAO.searchSupplier(supplierId);
    }

    @Override
    public boolean deleteSupplier(String supplierId) {
        return supplierDAO.deleteSupplier(supplierId);
    }

    @Override
    public boolean updateSupplier(SupplierDTO supplier) {
        return supplierDAO.updateSupplier(new Supplier(supplier.getSupplierId(),supplier.getName(),supplier.getAddress(),supplier.getTpNo(),supplier.geteMail()));
    }
}
