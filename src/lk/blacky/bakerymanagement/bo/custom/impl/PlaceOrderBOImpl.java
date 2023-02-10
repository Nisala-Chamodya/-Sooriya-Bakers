package lk.blacky.bakerymanagement.bo.custom.impl;

import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import lk.blacky.bakerymanagement.dao.DAOFactory;
import lk.blacky.bakerymanagement.dao.custom.OrderDAO;
import lk.blacky.bakerymanagement.dao.custom.OrderDetailsDAO;
import lk.blacky.bakerymanagement.dao.impl.OrderDetailsDAOImpl;
import lk.blacky.bakerymanagement.db.DBConnection;
import lk.blacky.bakerymanagement.dto.OrderDTO;
import lk.blacky.bakerymanagement.entity.OrderDetailsEntity;
import lk.blacky.bakerymanagement.entity.OrderEntity;
import lk.blacky.bakerymanagement.model.Order;
import lk.blacky.bakerymanagement.model.ProductDetails;
import lk.blacky.bakerymanagement.util.CRUDUtil;
import lk.blacky.bakerymanagement.view.tm.CartTm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class PlaceOrderBOImpl implements PlaceOrderBo {
    OrderDAO orderDAO = (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER);


    public boolean saveOrder(OrderDTO dto, ObservableList<CartTm> obList) {
        ArrayList<ProductDetails> details = new ArrayList<>();
        for (CartTm tm : obList) {
            details.add(new ProductDetails(tm.getProductId(), tm.getPrice(), tm.getQty()));


        }
        Order order = new Order(dto.getOrderID(), new Date(), Double.parseDouble(String.valueOf(dto.getTotalCost())),
                dto.getCustomerID(), details);

        Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();
            con.setAutoCommit(false);
            boolean isOrderSaved = orderDAO.add(new OrderEntity(
                    order.getOrderId(),
                    order.getDate().toString(),
                    order.getTotalCost(),
                    order.getCustomer()

            ));

            if (isOrderSaved) {
                boolean isAllUpdated = manageQty(details, order.getOrderId());

                if (isAllUpdated) {
                    con.commit();
                    return true;
                } else {
                    con.rollback();
                    con.setAutoCommit(true);

                    new Alert(Alert.AlertType.ERROR, "Is All Updated Failed").show();

                }

            } else {
                con.rollback();
                con.setAutoCommit(true);


                new Alert(Alert.AlertType.ERROR, "Order Not Saved");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;

    }

    public boolean manageQty(ArrayList<ProductDetails> details, String orderId) {

        try {
            for (ProductDetails d : details) {
                System.out.println(orderId);
                OrderDetailsDAO orderDetailsDAO=new OrderDetailsDAOImpl();
                OrderDetailsEntity odd=new OrderDetailsEntity();
                boolean isOrderDetailsSaved = orderDetailsDAO.add(new OrderDetailsEntity(
                        odd.getOrderID(),
                        odd.getProductID(),
                        odd.getAvailability(),
                        odd.getUnitPrice()

                ));
                if (isOrderDetailsSaved) {
                    boolean isQtyUpdated = update(d);
                    System.out.println(isQtyUpdated);
                    return isQtyUpdated;
                }


            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;

    }

    private static boolean update(ProductDetails d) {

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE product SET availability=(availability-?) WHERE product_id=?");
            statement.setObject(1, d.getAvailability());
            statement.setObject(2, d.getProductId());

            boolean b = statement.executeUpdate() > 0;
            if (b) {
                return true;
            } else {
                new Alert(Alert.AlertType.ERROR, "Data update erro");
                return false;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


}
