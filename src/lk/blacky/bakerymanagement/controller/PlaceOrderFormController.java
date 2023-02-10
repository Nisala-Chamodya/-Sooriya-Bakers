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
import lk.blacky.bakerymanagement.bo.custom.impl.PlaceOrderBOImpl;
import lk.blacky.bakerymanagement.bo.custom.impl.PlaceOrderBo;
import lk.blacky.bakerymanagement.dao.custom.PlaceOrderDAO;
import lk.blacky.bakerymanagement.dao.impl.PlaceOrderDAOImpl;
import lk.blacky.bakerymanagement.db.DBConnection;
import lk.blacky.bakerymanagement.dto.CustomerDTO;
import lk.blacky.bakerymanagement.dto.OrderDTO;
import lk.blacky.bakerymanagement.dto.ProductDTO;
import lk.blacky.bakerymanagement.model.Order;
import lk.blacky.bakerymanagement.model.OrderModel;
import lk.blacky.bakerymanagement.model.ProductDetails;
import lk.blacky.bakerymanagement.util.Navigation;
import lk.blacky.bakerymanagement.util.Routes;
import lk.blacky.bakerymanagement.view.tm.CartTm;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
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
    public PlaceOrderBo placeOrderBo = new PlaceOrderBOImpl();


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
                try {
                    setProductDetails();
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
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

    private void setProductDetails() throws SQLException, ClassNotFoundException {
        try {
//            Connection connection1 = DBConnection.getInstance().getConnection();
//            PreparedStatement statement1 = connection1.prepareStatement("SELECT * FROM product WHERE product_id=?");
//            statement1.setObject(1, cmbProductId.getValue());
//            ResultSet resultSet = statement1.executeQuery();
            ArrayList<ProductDTO> productDTOS = new ArrayList<>();
            productDTOS = placeOrderDAO.setProductDetails(cmbProductId.getValue());
            ProductDTO p = productDTOS.get(0);

            txtProductName.setText(p.getProductName());
            txtPrice.setText(String.valueOf(p.getPrice()));
            txtDescription.setText(p.getDescription());
            txtAvailability.setText(String.valueOf(p.getAvailability()));


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

    static ObservableList<CartTm> obList = FXCollections.observableArrayList();

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
        OrderDTO orderDTO = new OrderDTO(
                txtOrderId.getText(),
                String.valueOf(LocalDate.now()),
                Double.parseDouble(txtTotal.getText()),
                cmbCustId.getValue().toString()

        );


        placeOrderBo.equals(orderDTO);

        boolean b = placeOrderBo.saveOrder(orderDTO, obList);
        if (b) {
            printInvoice();
            new Alert(Alert.AlertType.CONFIRMATION, "Order Placed!").show();
            clearAll();
        }


    }

    public void printInvoice() {

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


    public void clearAll() {
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


}
