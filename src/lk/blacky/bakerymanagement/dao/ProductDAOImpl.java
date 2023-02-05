package lk.blacky.bakerymanagement.dao;

import lk.blacky.bakerymanagement.to.Product;
import lk.blacky.bakerymanagement.util.CRUDUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDAOImpl {
    public static boolean AddProduct(Product product) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO product VALUES (?, ?, ?, ?,?)";
        return CRUDUtil.execute(sql, product.getProductId(),
                product.getProductName(), product.getPrice(), product.getDescription(), product.getAvailability());
    }

    public static Product searchProduct(String ProductId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM product WHERE  product_id=? ";
        ResultSet resultSet = CRUDUtil.execute(sql, ProductId);
        if (resultSet.next()) {
            return new Product(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getString(4),
                    resultSet.getInt(5) );





        }
        return null;
    }

    public static boolean updateProduct(Product product) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE product SET name=?,price=?,discription=?,availability=? WHERE  product_id=? ";
        return CRUDUtil.execute(sql, product.getProductName(), product.getPrice(), product.getDescription(), product.getAvailability(), product.getProductId());

    }

    public static boolean deleteProduct(String productId) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM product WHERE product_id=? ";
        return CRUDUtil.execute(sql, productId);
    }
}
