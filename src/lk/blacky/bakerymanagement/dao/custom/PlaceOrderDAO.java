package lk.blacky.bakerymanagement.dao.custom;

import lk.blacky.bakerymanagement.dto.CustomerDTO;
import lk.blacky.bakerymanagement.dto.ProductDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PlaceOrderDAO {
    public ArrayList<String> loadAllProductIds() throws SQLException, ClassNotFoundException;

    ArrayList<String> loadAllCustomerIds() throws SQLException, ClassNotFoundException;

    ArrayList <CustomerDTO> setCustomerDetails(String value) throws ClassNotFoundException, SQLException;

    ArrayList <ProductDTO> setProductDetails(String value) throws SQLException, ClassNotFoundException;

    ArrayList<ProductDTO> checkQTYDetails(String value) throws SQLException, ClassNotFoundException;



}
