package lk.blacky.bakerymanagement.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.blacky.bakerymanagement.db.DBConnection;
import lk.blacky.bakerymanagement.util.Navigation;
import lk.blacky.bakerymanagement.util.Routes;
import lk.blacky.bakerymanagement.view.tm.CustomerTm;
import lk.blacky.bakerymanagement.view.tm.RecipeTm;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Optional;

public class ViewRecipeFormController {
    public AnchorPane pane;
    public TableView<RecipeTm> tblRecipe;
    public TableColumn colRecipeId;
    public TableColumn colName;
    public TableColumn colDescription;
    public TableColumn colOption;
    public JFXTextField txtSearch;
    public JFXTextField txtChiefCookName;
    private  String searchText="";



    public void initialize(){
        colRecipeId.setCellValueFactory(new PropertyValueFactory<>("recipeId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("foodName"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colOption.setCellValueFactory(new PropertyValueFactory<>("btn"));
        searchRecipe(searchText);

        txtSearch.textProperty()
                .addListener((observable, oldValue, newValue) -> {
                    searchText=newValue;
                    searchRecipe(searchText);

                });
    }

    private void searchRecipe(String text) {
        try {
            String searchText="%"+text+"%";

            ObservableList<RecipeTm> tmList= FXCollections.observableArrayList();

            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT  * FROM recipe WHERE recipe_id LIKE ? || name  LIKE ?");
            statement.setObject(1,searchText);
            statement.setObject(2,searchText);
            ResultSet set = statement.executeQuery();
            while (set.next()){
                Button btn = new Button("Delete");
                btn.setStyle("-fx-background-color : red");


                RecipeTm tm=new RecipeTm(
                        set.getString(1),
                        set.getString(2),
                        set.getString(3),
                        btn

                );
                tmList.add(tm);

                btn.setOnAction(event -> {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you Shuar delete this Recipe ? ",
                            ButtonType.YES, ButtonType.NO);

                    Optional<ButtonType> buttonType = alert.showAndWait();
                    if (buttonType.get() == ButtonType.YES) {


                        try {

                            Connection connection1 = DBConnection.getInstance().getConnection();
                            PreparedStatement statement1 = connection1.prepareStatement("DELETE FROM recipe WHERE  recipe_id=?");
                            statement1.setObject(1,tm.getRecipeId());


                            if (  statement1.executeUpdate() >0 ) {
                                searchRecipe(searchText);
                                new Alert(Alert.AlertType.INFORMATION, "Recipe Deleted!!").show();

                            } else {
                                new Alert(Alert.AlertType.WARNING, "Try Again !!!").show();
                            }


                        } catch (ClassNotFoundException | SQLException e) {
                            e.printStackTrace();
                        }







                    }










                });


                tblRecipe.setItems(tmList );
            }




        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void backImgOnClickAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.MANAGERECIPE,pane);
    }

    public void btnPrintResipeOnAction(ActionEvent actionEvent) {
        HashMap<String,Object> hm=new HashMap<>();
        hm.put("name",txtChiefCookName.getText());
        InputStream inputStream = this.getClass().getResourceAsStream("/lk/blacky/bakerymanagement/report/Recipe.jrxml");
        try {
            JasperReport compileReport = JasperCompileManager.compileReport(inputStream);
            JasperPrint jasperPrint=  JasperFillManager
                    .fillReport(compileReport,hm, DBConnection.getInstance().getConnection());
            //JasperPrintManager.printReport(jasperPrint,true);
            JasperViewer.viewReport(jasperPrint);
        } catch (JRException | ClassNotFoundException | SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
}
