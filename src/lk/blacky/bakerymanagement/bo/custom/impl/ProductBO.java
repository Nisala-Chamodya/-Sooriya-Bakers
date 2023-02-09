package lk.blacky.bakerymanagement.bo.custom.impl;

import lk.blacky.bakerymanagement.dto.ProductDTO;
import lk.blacky.bakerymanagement.to.Product;

public interface ProductBO extends  SuperBo{
    public  boolean AddProduct(ProductDTO product);
    public  ProductDTO searchProduct(String ProductId);

    public  boolean updateProduct(ProductDTO product);
    public  boolean deleteProduct(String productId);

}
