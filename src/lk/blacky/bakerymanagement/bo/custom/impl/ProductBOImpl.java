package lk.blacky.bakerymanagement.bo.custom.impl;

import lk.blacky.bakerymanagement.dao.DAOFactory;
import lk.blacky.bakerymanagement.dao.custom.CustomerDAO;
import lk.blacky.bakerymanagement.dao.custom.ProductDAO;
import lk.blacky.bakerymanagement.dto.ProductDto;
import lk.blacky.bakerymanagement.to.Customer;
import lk.blacky.bakerymanagement.to.Product;

public class ProductBOImpl  implements  ProductBO{
    //dipendancy injection
    ProductDAO productDAO = (ProductDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PRODUCT);
    @Override
    public boolean AddProduct(ProductDto product) {
        return productDAO.AddProduct(new Product(product.getProductId(),product.getProductName(),product.getPrice(),product.getDescription(),product.getAvailability()));
    }

    @Override
    public Product searchProduct(String ProductId) {
        return productDAO.searchProduct(ProductId);
    }

    @Override
    public boolean updateProduct(ProductDto product) {
        return productDAO.updateProduct(new Product(product.getProductId(),product.getProductName(),product.getPrice(),product.getDescription(),product.getAvailability()));
    }

    @Override
    public boolean deleteProduct(String productId) {
        return productDAO.deleteProduct(productId);
    }
}
