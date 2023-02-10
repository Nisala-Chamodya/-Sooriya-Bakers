package lk.blacky.bakerymanagement.bo.custom.impl;

import lk.blacky.bakerymanagement.dao.DAOFactory;
import lk.blacky.bakerymanagement.dao.custom.ProductDAO;
import lk.blacky.bakerymanagement.dto.ProductDTO;
import lk.blacky.bakerymanagement.entity.ProductEntity;

import java.sql.SQLException;

public class ProductBOImpl  implements  ProductBO{
    //dipendancy injection
    ProductDAO productDAO = (ProductDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PRODUCT);
    @Override
    public boolean AddProduct(ProductDTO product) throws SQLException, ClassNotFoundException {
        return productDAO.add(new ProductEntity(product.getProductId(),product.getProductName(),product.getPrice(),product.getDescription(),product.getAvailability()));
    }

    @Override
    public ProductDTO searchProduct(String ProductId) {

        ProductEntity search = productDAO.search(ProductId);
        return new ProductDTO(search.getProductId(),search.getProductName(),search.getPrice(),search.getDescription(),search.getAvailability());
    }

    @Override
    public boolean updateProduct(ProductDTO product) {
        return productDAO.update(new ProductEntity(product.getProductId(),product.getProductName(),product.getPrice(),product.getDescription(),product.getAvailability()));
    }

    @Override
    public boolean deleteProduct(String productId) {
        return productDAO.delete(productId);
    }
}
