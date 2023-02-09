package lk.blacky.bakerymanagement.dao.impl;

import lk.blacky.bakerymanagement.dao.custom.PlaceOrderDAO;
import lk.blacky.bakerymanagement.dto.CustomerDTO;
import lk.blacky.bakerymanagement.dto.ProductDTO;
import lk.blacky.bakerymanagement.util.CRUDUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlaceOrderDAOImpl implements PlaceOrderDAO {
    public ArrayList<String> loadAllProductIds() throws SQLException, ClassNotFoundException {
        ArrayList<String> productIdList = new ArrayList<>();
        ResultSet rst = CRUDUtil.execute("SELECT product_id FROM product ");
        while (rst.next()){
            productIdList.add(rst.getString(1));
        }
        return productIdList;


    }
    public ArrayList<String> loadAllCustomerIds() throws SQLException, ClassNotFoundException {
        ArrayList<String>  customerIdList=new ArrayList<>();
        ResultSet rst=CRUDUtil.execute("SELECT cust_id FROM customer ");
        while (rst.next()){
            customerIdList.add(rst.getString(1));
        }

        return customerIdList;

    }



    public ArrayList<CustomerDTO > setCustomerDetails(String custId) throws ClassNotFoundException, SQLException {
        ArrayList<CustomerDTO> setCustomerDetails=new ArrayList<>();
        ResultSet rst = CRUDUtil.execute("SELECT * FROM customer WHERE cust_id=?", custId);
        while (rst.next()){
            setCustomerDetails.add(
                    new CustomerDTO(
                            rst.getString(1),
                            rst.getString(2),
                            rst.getString(3),
                            rst.getString(4),
                            rst.getString(5)



                    ));
        }
     return setCustomerDetails;

    }




    public ArrayList<ProductDTO>  setProductDetails(String productId) throws SQLException, ClassNotFoundException {
        ArrayList<ProductDTO> setProductDetails=new ArrayList<>();
        ResultSet rst=CRUDUtil.execute("SELECT * FROM product WHERE product_id=?",productId);
        while (rst.next()){
            setProductDetails.add(
                    new ProductDTO(
                            rst.getString(1),
                            rst.getString(2),
                            rst.getString(3),
                            rst.getString(4),
                            rst.getString(5)


            ) );
        }
        return setProductDetails;
    }

    @Override
    public ArrayList<ProductDTO> checkQTYDetails(String productId) throws SQLException, ClassNotFoundException {
        ArrayList<ProductDTO> checkQTY=new ArrayList<>();
        ResultSet rst=CRUDUtil.execute("SELECT availability FROM product WHERE product_id=? ",productId);
        while (rst.next()){
            checkQTY.add(
                    new ProductDTO(
                            rst.getString(1),
                            rst.getString(2),
                            rst.getString(3),
                            rst.getString(4),
                            rst.getString(5)


                    ) );
        }
        return checkQTY;
    }


}
