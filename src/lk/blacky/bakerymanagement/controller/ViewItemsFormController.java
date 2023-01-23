package lk.blacky.bakerymanagement.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.blacky.bakerymanagement.db.DBConnection;
import lk.blacky.bakerymanagement.util.Navigation;
import lk.blacky.bakerymanagement.util.Routes;
import lk.blacky.bakerymanagement.view.tm.CustomerTm;
import lk.blacky.bakerymanagement.view.tm.ItemTm;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class ViewItemsFormController {
    public AnchorPane pane;
    public TableView <ItemTm>tblItem;
    public TableColumn colItemId;
    public TableColumn colBrand;
    public TableColumn colDescription;
    public TableColumn colAvailability;
    public TableColumn colOption;
    public JFXTextField txtSearch;
    private  String searchText="";

    public void initialize(){
        colItemId.setCellValueFactory(new PropertyValueFactory<>("itemId"));
        colBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colAvailability.setCellValueFactory(new PropertyValueFactory<>("availability"));
        colOption.setCellValueFactory(new PropertyValueFactory<>("btn"));
        searchItem(searchText);

        txtSearch.textProperty()
                .addListener((observable, oldValue, newValue) -> {
                    searchText=newValue;
                    searchItem(searchText);

                });

    }

    private void searchItem(String text) {
        try {
            String searchText="%"+text+"%";

            ObservableList<ItemTm> tmList= FXCollections.observableArrayList();

            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT  * FROM item WHERE item_id LIKE ? || brand  LIKE ?");
            statement.setObject(1,searchText);
            statement.setObject(2,searchText);
            ResultSet set = statement.executeQuery();
            while (set.next()){
                Button btn = new Button("Delete");
                btn.setStyle("-fx-background-color : red");


                ItemTm tm=new ItemTm(
                        set.getString(1),
                        set.getString(2),
                        set.getString(3),
                        set.getInt(4),

                        btn
                );
                tmList.add(tm);
                btn.setOnAction(event -> {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you Shuar delete this Item ? ",
                            ButtonType.YES, ButtonType.NO);

                    Optional<ButtonType> buttonType = alert.showAndWait();
                    if (buttonType.get() == ButtonType.YES) {


                        try {

                            Connection connection1 = DBConnection.getInstance().getConnection();
                            PreparedStatement statement1 = connection1.prepareStatement("DELETE FROM item WHERE  item_id=?");
                            statement1.setObject(1,tm.getItemId());


                            if (  statement1.executeUpdate() >0 ) {
                                searchItem(searchText);
                                new Alert(Alert.AlertType.INFORMATION, "Item Deleted!!").show();

                            } else {
                                new Alert(Alert.AlertType.WARNING, "Try Again !!!").show();
                            }


                        } catch (ClassNotFoundException | SQLException e) {
                            e.printStackTrace();
                        }







                    }



                });
            }
            tblItem.setItems(tmList );

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public void backImgOnClickAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.MANAGEITEMS,pane);

    }
}
