package lk.blacky.bakerymanagement.dao.custom;

import lk.blacky.bakerymanagement.to.Product;

public interface ProductDAO {

    public  boolean AddProduct(Product product);
    public  Product searchProduct(String ProductId);

    public  boolean updateProduct(Product product);
    public  boolean deleteProduct(String productId);




}
