package lk.blacky.bakerymanagement.bo.custom.impl;

import lk.blacky.bakerymanagement.dao.DAOFactory;
import lk.blacky.bakerymanagement.dao.custom.SupplierDAO;
import lk.blacky.bakerymanagement.dto.SupplierDTO;

public class SupplierBoImpl implements SupplierBo{
    //dipendancy injection
    SupplierDAO supplierDAO = (SupplierDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SUPPLIER);
    @Override
    public boolean AddSupplier(SupplierDTO supplier) {
        return supplierDAO.add(new SupplierDTO(supplier.getSupplierId(),supplier.getName(),supplier.getAddress(),supplier.getTpNo(),supplier.geteMail()));
    }

    @Override
    public SupplierDTO searchSupplier(String supplierId) {
        return supplierDAO.search(supplierId);
    }

    @Override
    public boolean deleteSupplier(String supplierId) {
        return supplierDAO.delete(supplierId);
    }

    @Override
    public boolean updateSupplier(SupplierDTO supplier) {
        return supplierDAO.update(new SupplierDTO(supplier.getSupplierId(),supplier.getName(),supplier.getAddress(),supplier.getTpNo(),supplier.geteMail()));
    }
}
