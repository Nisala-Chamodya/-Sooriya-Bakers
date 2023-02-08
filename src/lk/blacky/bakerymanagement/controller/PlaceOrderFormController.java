package lk.blacky.bakerymanagement.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lk.blacky.bakerymanagement.dao.custom.PlaceOrderDAO;
import lk.blacky.bakerymanagement.dao.custom.impl.PlaceOrderDAOImpl;
import lk.blacky.bakerymanagement.db.DBConnection;
import lk.blacky.bakerymanagement.dto.CustomerDTO;
import lk.blacky.bakerymanagement.model.Order;
import lk.blacky.bakerymanagement.model.OrderModel;
import lk.blacky.bakerymanagement.model.ProductDetails;
import lk.blacky.bakerymanagement.util.CRUDUtil;
import lk.blacky.bakerymanagement.util.Navigation;
import lk.blacky.bakerymanagement.util.Routes;
import lk.blacky.bakerymanagement.view.tm.CartTm;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Optional;

public class PlaceOrderFormController {
    public AnchorPane pane;
    public Label lblTime;
    public JFXComboBox<String> cmbCustId;
    public JFXComboBox<String> cmbProductId;
    public JFXTextField txtOrderId;
    public JFXTextField txtOrderDate;
    public JFXTextField txtCustName;
    public JFXTextField txtNic;
    public JFXTextField txtAddress;
    public JFXTextField txtTpNo;
    public JFXTextField txtProductName;
    public JFXTextField txtPrice;
    public JFXTextField txtDescription;
    public JFXTextField txtAvailability;
    public JFXTextField txtQty;
    public TableView<CartTm> tblCart;
    public TableColumn colProductId;
    public TableColumn colName;
    public TableColumn colPrice;
    public TableColumn colDescription;
    public TableColumn colQty;
    public TableColumn colTotal;
    public TableColumn colOption;
    public Label txtTotal;
    public JFXTextField txtCashierName;
    /*dipendancy Injection*/
    public PlaceOrderDAO placeOrderDAO = new PlaceOrderDAOImpl();


    public void initialize() {
        colProductId.setCellValueFactory(new PropertyValueFactory<>("productId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        colOption.setCellValueFactory(new PropertyValueFactory<>("btn"));


        setDateAndTime();
        //setOrderId();
        setOrderDate();
        loadAllCustomerId();
        loadAllProductId();
        genarateOrderId();

        cmbCustId.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                setCustomerDetails();
            }

        });


        cmbProductId.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                setProductDetails();
            }

        });


    }

    private void genarateOrderId() {
        try {
            String lastOrderId = OrderModel.getLastOrderId();
            if (lastOrderId != null) {
                lastOrderId = lastOrderId.split("[A-Z]")[1];
                System.out.println(lastOrderId);
                lastOrderId = String.format("D%03d", (Integer.parseInt(lastOrderId) + 1));
                txtOrderId.setText(lastOrderId);
            } else {
                txtOrderId.setText("D001");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }


    private void loadAllProductId() {

//            Connection connection1 = DBConnection.getInstance().getConnection();
//            String sql = "SELECT product_id FROM product ";
//            PreparedStatement statement1 = connection1.prepareStatement(sql);
//            ResultSet resultSet = CRUDUtil.execute(sql);
//            ArrayList<String> productIdList = new ArrayList<>();
//            while (resultSet.next()) {
//                productIdList.add(resultSet.getString(1));
        try {
            ArrayList<String> list = placeOrderDAO.loadAllProductIds();
            ObservableList<String> obList = FXCollections.observableArrayList(list);
            cmbProductId.setItems(obList);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    private void loadAllCustomerId() {

           /* Connection connection1 = DBConnection.getInstance().getConnection();
            String sql = "SELECT cust_id FROM customer ";
            PreparedStatement statement1 = connection1.prepareStatement(sql);
            ResultSet resultSet = CRUDUtil.execute(sql);
            ArrayList<String> custIdList = new ArrayList<>();
            while (resultSet.next()) {

                custIdList.add(resultSet.getString(1));*/
        ArrayList<String> list = null;
        try {
            list = placeOrderDAO.loadAllCustomerIds();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ObservableList<String> obList = FXCollections.observableArrayList(list);
        cmbCustId.setItems(obList);

    }

    private void setOrderDate() {
        txtOrderDate.setText(String.valueOf(LocalDate.now()));


    }

  /* private void setOrderId() {
        try {
            Connection connection1 = DBConnection.getInstance().getConnection();
            String sql = "SELECT order_id FROM orders ORDER BY order_id DESC LIMIT 1";
            PreparedStatement statement1 = connection1.prepareStatement(sql);
            ResultSet set = CRUDUtil.execute(sql);
            if (set.next()) {
                String tempOrderId = set.getString(1);
                String[] array = tempOrderId.split("-");
                int tempNumber = Integer.parseInt(array[1]);
                int finalizeOrderId = tempNumber + 1;
                txtOrderId.setText("D-000" + finalizeOrderId);

            } else {
                txtOrderId.setText("D-0001");
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }*/


    private void setDateAndTime() {

        Timeline time = new Timeline(
                new KeyFrame(Duration.ZERO, e -> {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd      HH:mm:ss ");
                    lblTime.setText(LocalDateTime.now().format(formatter));
                }), new KeyFrame(Duration.seconds(1)));
        time.setCycleCount(Animation.INDEFINITE);
        time.play();

    }


    private void setCustomerDetails() {
        try {
            /*Connection connection1 = DBConnection.getInstance().getConnection();
            String sql = "SELECT * FROM customer WHERE cust_id=?";
            PreparedStatement statement1 = connection1.prepareStatement(sql);
            statement1.setObject(1, cmbCustId.getValue());
            ResultSet resultSet = statement1.executeQuery();*/
            ArrayList<CustomerDTO> customerDTOS = new ArrayList<>();
            customerDTOS = placeOrderDAO.setCustomerDetails(cmbCustId.getValue());
            CustomerDTO c = customerDTOS.get(0);

            txtCustName.setText(c.getName());
            txtNic.setText(c.getNic());
            txtAddress.setText(c.getAddress());
            txtTpNo.setText(c.getTpNo());


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void setProductDetails() {
        try {
            Connection connection1 = DBConnection.getInstance().getConnection();
            PreparedStatement statement1 = connection1.prepareStatement("SELECT * FROM product WHERE product_id=?");
            statement1.setObject(1, cmbProductId.getValue());
            ResultSet resultSet = statement1.executeQuery();
            if (resultSet.next()) {
                txtProductName.setText(resultSet.getString(2));
                txtPrice.setText(resultSet.getString(3));
                txtDescription.setText(resultSet.getString(4));
                txtAvailability.setText(resultSet.getString(5));


            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void backImgOnClickAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.CASHIERDASHBOARD, pane);

    }

    public void addCustomerImgOnClickAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.MANAGECUSTOMERWHITHCASHEIR, pane);
    }

    public void addProductImgOnClickAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.MANAGEPRODUCTWITHCASHIER, pane);
    }

    ObservableList<CartTm> obList = FXCollections.observableArrayList();

    public void btnAddToCartOnAction(ActionEvent actionEvent) {
        saveTransaction();

    }

    public void saveTransaction() {
        if (!checkQty((String) cmbProductId.getValue(), Integer.parseInt(txtQty.getText()))) {
            new Alert(Alert.AlertType.WARNING, "Invalid Qty ").show();
            return;
        }

        double unitPrice = Double.parseDouble(txtPrice.getText());
        int qty = Integer.parseInt(txtQty.getText());
        double total = unitPrice * qty;
        int availability = Integer.parseInt(txtAvailability.getText());
        Button btn = new Button("Delete");
        btn.setStyle("-fx-background-color : red");
        int row = isAlreadyExists(cmbProductId.getValue());


        if (row == -1) {

            CartTm tm = new CartTm(cmbProductId.getValue(), txtProductName.getText(), unitPrice,
                    txtDescription.getText(), qty, total, btn);
            obList.add(tm);
            tblCart.setItems(obList);


        } else {
            int tempQty = obList.get(row).getQty() + qty;
            double tempTotal = unitPrice * tempQty;

            if (!checkQty(cmbProductId.getValue(), tempQty)) {
                new Alert(Alert.AlertType.WARNING, "Invalid Qty ").show();
                return;
            }
            obList.get(row).setQty(tempQty);
            obList.get(row).setTotal(tempTotal);
            tblCart.refresh();
        }

        calculateTotal();
        clearFields();
        cmbProductId.requestFocus();

        btn.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure ?", ButtonType.YES, ButtonType.NO);
            Optional<ButtonType> buttonType = alert.showAndWait();

            if (buttonType.get() == ButtonType.YES) {
                for (CartTm tm : obList) {

                    if (tm.getProductId().equals(tm.getProductId())) {
                        obList.remove(tm);
                        calculateTotal();
                        tblCart.refresh();
                        return;
                    }

                }
            }

        });

    }

    private void clearFields() {
        txtProductName.clear();
        txtPrice.clear();
        txtDescription.clear();
        txtAvailability.clear();
        txtQty.clear();
    }

    private void calculateTotal() {
        double total = 0.00;
        for (CartTm tm : obList) {
            total += tm.getTotal();


        }
        txtTotal.setText(String.valueOf(total));

    }

    private int isAlreadyExists(String productId) {
        for (int i = 0; i < obList.size(); i++) {
            if (obList.get(i).getProductId().equals(productId)) {
                return i;
            }
        }

        return -1;

    }

    private boolean checkQty(String code, int qty) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT availability FROM product WHERE product_id=?");
            statement.setObject(1, code);

            ResultSet set = statement.executeQuery();
            if (set.next()) {
                int tempQty = set.getInt(1);
                if (tempQty >= qty) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void btnPlaceOrderOnAction(ActionEvent actionEvent) throws SQLException {

        if (obList.isEmpty()) return;
        ArrayList<ProductDetails> details = new ArrayList<>();
        for (CartTm tm : obList) {
            details.add(new ProductDetails(tm.getProductId(), tm.getPrice(), tm.getQty()));


        }
        Order order = new Order(txtOrderId.getText(), new Date(), Double.parseDouble(txtTotal.getText()),
                cmbCustId.getValue(), details);

        Connection con = null;

        try {
            con = DBConnection.getInstance().getConnection();
            con.setAutoCommit(false);
            PreparedStatement statement = con.prepareStatement("INSERT orders VALUES (?,?,?,?)");
            statement.setObject(1, order.getOrderId());
            statement.setObject(2, txtOrderDate.getText());
            statement.setObject(3, order.getTotalCost());
            statement.setObject(4, order.getCustomer());

            boolean isOrderSaved = statement.executeUpdate() > 0;

            if (isOrderSaved) {
                boolean isAllUpdated = manageQty(details);


                if (isAllUpdated) {

                    con.commit();
                    printInvoice();

                    new Alert(Alert.AlertType.CONFIRMATION, "Order Placed!").show();


                    clearAll();


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
            con.setAutoCommit(true);

        }


    }

    private void printInvoice() {

        String total = txtTotal.getText();

        try {

            JasperDesign jasdi = JRXmlLoader.load("C:\\Users\\NISALA CHAMODYA\\JaspersoftWorkspace\\BakeryJasperReportProject\\Invoice.jrxml");

            String sql = "SELECT * FROM  `order_details` WHERE order_id='" + txtOrderId.getText() + "'";
            JRDesignQuery newQuery = new JRDesignQuery();
            newQuery.setText(sql);
            jasdi.setQuery(newQuery);
            HashMap<String, Object> hm = new HashMap<>();
            hm.put("cashierName", txtCashierName.getText());
            hm.put("total", String.valueOf(total));


            JasperReport compileReport = JasperCompileManager.compileReport(jasdi);
            JasperPrint jasperPrint = JasperFillManager
                    .fillReport(compileReport, hm, DBConnection.getInstance().getConnection());
            //JasperPrintManager.printReport(jasperPrint,true);
            JasperViewer.viewReport(jasperPrint);


        } catch (Exception e) {
            e.printStackTrace();

        }


    }


    private void clearAll() {
        obList.clear();
        calculateTotal();
        txtProductName.clear();
        txtNic.clear();
        txtAddress.clear();
        txtTpNo.clear();


        //********combo box null karananawa***********
        cmbCustId.setValue(null);
        cmbProductId.setValue(null);

        //*******************************************

        clearFields();
        cmbCustId.requestFocus();
        //setOrderId();
        genarateOrderId();

    }

    private boolean manageQty(ArrayList<ProductDetails> details) {

        try {
            for (ProductDetails d : details) {
                Connection connection = DBConnection.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement("INSERT `order_details` VALUES (?,?,?,?)");
                statement.setObject(1, txtOrderId.getText());
                statement.setObject(2, d.getProductId());
                statement.setObject(3, d.getAvailability());
                statement.setObject(4, d.getUnitPrice());

                boolean isOrderDetailsSaved = statement.executeUpdate() > 0;
                //  System.out.println(isOrderDetailsSaved + "oder details");
                if (isOrderDetailsSaved) {
                    boolean isQtyUpdated = update(d);
                    System.out.println(isQtyUpdated);
                    if (!isQtyUpdated) {
                        return false;
                    } else {
                        return true;
                    }
                }


            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;

    }

    private boolean update(ProductDetails d) {

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
