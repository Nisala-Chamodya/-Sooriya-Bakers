package lk.blacky.bakerymanagement.bo.custom.impl;

import lk.blacky.bakerymanagement.dto.ProductDto;
import lk.blacky.bakerymanagement.to.Product;

public interface ProductBO extends  SuperBo{
    public  boolean AddProduct(ProductDto product);
    public  Product searchProduct(String ProductId);

    public  boolean updateProduct(ProductDto product);
    public  boolean deleteProduct(String productId);

}
