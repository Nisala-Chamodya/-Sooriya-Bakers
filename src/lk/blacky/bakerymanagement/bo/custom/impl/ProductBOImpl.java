package lk.blacky.bakerymanagement.bo.custom.impl;

import lk.blacky.bakerymanagement.dao.DAOFactory;
import lk.blacky.bakerymanagement.dao.custom.ProductDAO;
import lk.blacky.bakerymanagement.dto.ProductDTO;

public class ProductBOImpl  implements  ProductBO{
    //dipendancy injection
    ProductDAO productDAO = (ProductDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PRODUCT);
    @Override
    public boolean AddProduct(ProductDTO product) {
        return productDAO.add(new ProductDTO(product.getProductId(),product.getProductName(),product.getPrice(),product.getDescription(),product.getAvailability()));
    }

    @Override
    public ProductDTO searchProduct(String ProductId) {
        return productDAO.search(ProductId);
    }

    @Override
    public boolean updateProduct(ProductDTO product) {
        return productDAO.update(new ProductDTO(product.getProductId(),product.getProductName(),product.getPrice(),product.getDescription(),product.getAvailability()));
    }

    @Override
    public boolean deleteProduct(String productId) {
        return productDAO.delete(productId);
    }
}
