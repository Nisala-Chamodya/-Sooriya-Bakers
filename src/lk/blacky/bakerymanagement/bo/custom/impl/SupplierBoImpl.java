package lk.blacky.bakerymanagement.bo.custom.impl;

import lk.blacky.bakerymanagement.dao.DAOFactory;
import lk.blacky.bakerymanagement.dao.custom.SupplierDAO;
import lk.blacky.bakerymanagement.dto.SupplierDTO;
import lk.blacky.bakerymanagement.entity.SupplierEntity;

import java.sql.SQLException;

public class SupplierBoImpl implements SupplierBo{
    //dipendancy injection
    SupplierDAO supplierDAO = (SupplierDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SUPPLIER);
    @Override
    public boolean AddSupplier(SupplierDTO supplier) throws SQLException, ClassNotFoundException {
        return supplierDAO.add(new SupplierEntity(supplier.getSupplierId(),supplier.getName(),supplier.getAddress(),supplier.getTpNo(),supplier.geteMail()));
    }

    @Override
    public SupplierDTO searchSupplier(String supplierId) {
        SupplierEntity search = supplierDAO.search(supplierId);

        return new SupplierDTO(search.getSupplierId(),search.getName(),search.getAddress(),search.getTpNo(),search.getEmail());
    }

    @Override
    public boolean deleteSupplier(String supplierId) {
        return supplierDAO.delete(supplierId);
    }

    @Override
    public boolean updateSupplier(SupplierDTO supplier) {
        return supplierDAO.update(new SupplierEntity(supplier.getSupplierId(),supplier.getName(),supplier.getAddress(),supplier.getTpNo(),supplier.geteMail()));
    }
}
