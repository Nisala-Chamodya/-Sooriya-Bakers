package lk.blacky.bakerymanagement.dao;

import lk.blacky.bakerymanagement.dao.custom.impl.CRUDDAO;
import lk.blacky.bakerymanagement.dao.custom.impl.ProductDAO;
import lk.blacky.bakerymanagement.to.Employee;
import lk.blacky.bakerymanagement.to.Product;
import lk.blacky.bakerymanagement.util.CRUDUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDAOImpl implements CRUDDAO<Product,String> {

    public boolean add(Product product) {
        String sql = "INSERT INTO product VALUES (?, ?, ?, ?,?)";
        try {
            return CRUDUtil.execute(sql, product.getProductId(),
                    product.getProductName(), product.getPrice(), product.getDescription(), product.getAvailability());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Product search(String ProductId) {
        String sql = "SELECT * FROM product WHERE  product_id=? ";
        ResultSet resultSet = null;
        try {
            resultSet = CRUDUtil.execute(sql, ProductId);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            if (resultSet.next()) {
                return new Product(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getDouble(3),
                        resultSet.getString(4),
                        resultSet.getInt(5));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean update(Product product) {
        String sql = "UPDATE product SET name=?,price=?,discription=?,availability=? WHERE  product_id=? ";
        try {
            return CRUDUtil.execute(sql, product.getProductName(), product.getPrice(), product.getDescription(), product.getAvailability(), product.getProductId());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;

    }

    public boolean delete(String productId) {
        String sql = "DELETE FROM product WHERE product_id=? ";
        try {
            return CRUDUtil.execute(sql, productId);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }





}
