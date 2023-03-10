package lk.blacky.bakerymanagement.bo.custom.impl;

import lk.blacky.bakerymanagement.dto.SupplierDTO;
import lk.blacky.bakerymanagement.to.Supplier;

import java.sql.SQLException;

public interface SupplierBo extends SuperBo{
    public  boolean AddSupplier(SupplierDTO supplier) throws SQLException, ClassNotFoundException;
    public  SupplierDTO searchSupplier(String supplierId);
    public  boolean deleteSupplier(String supplierId);
    public  boolean updateSupplier(SupplierDTO supplier);

}
