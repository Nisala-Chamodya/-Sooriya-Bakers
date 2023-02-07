package lk.blacky.bakerymanagement.dao.custom.impl;

import lk.blacky.bakerymanagement.to.Supplier;

public interface SupplierDAO {
    public  boolean AddSupplier(Supplier supplier);
    public  Supplier searchSupplier(String supplierId);
    public  boolean deleteSupplier(String supplierId);
    public  boolean updateSupplier(Supplier supplier);

}
