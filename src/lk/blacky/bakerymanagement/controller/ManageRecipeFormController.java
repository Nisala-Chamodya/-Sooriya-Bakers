package lk.blacky.bakerymanagement.controller;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.blacky.bakerymanagement.model.ProductModel;
import lk.blacky.bakerymanagement.model.RecipeModel;
import lk.blacky.bakerymanagement.to.Product;
import lk.blacky.bakerymanagement.to.Recipe;
import lk.blacky.bakerymanagement.util.Navigation;
import lk.blacky.bakerymanagement.util.Routes;

import java.io.IOException;
import java.sql.SQLException;

import static lk.blacky.bakerymanagement.util.Validator.*;

public class ManageRecipeFormController {
    public AnchorPane pane;
    public JFXTextField txtRecipeId;
    public JFXTextField txtName;
    public JFXTextArea txtDescription;

    public void backImgClickOnAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.CHEIFCOOKDASHBOARD,pane);
    }

    public void btnViewRecipeOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.VIEWRECIPE,pane);

    }

    public void btnAddRecipeOnAction(ActionEvent actionEvent) {
        if (isRecipeIdMatcher(txtRecipeId.getText())) {
            if (isNameMatch(txtName.getText())){
            String recipeId = txtRecipeId.getText();
            String foodName = txtName.getText();
            String description = txtDescription.getText();


            Recipe recipe = new Recipe(recipeId, foodName, description);


            try {
                boolean isAdded = RecipeModel.addRecipe(recipe);
                if (isAdded) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Recipe Added!").show();
                } else {
                    new Alert(Alert.AlertType.WARNING, "Something happened!").show();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


            }else {
                new Alert(Alert.AlertType.ERROR, "Pleace Insert Valid Name").show();
                txtName.setStyle("-jfx-unfocus-color : red");
            }


        }else {
            new Alert(Alert.AlertType.ERROR, "Please check the Valid Recipe_Id.\n (R-001) Like That").show();
            txtRecipeId.setStyle("-jfx-unfocus-color : red");
        }
    }

    public void btnClearRecipeOnAction(ActionEvent actionEvent) {
        txtRecipeId.clear();
        txtName.clear();
        txtDescription.clear();

    }

    public void btnSearchRecipeOnAction(ActionEvent actionEvent) {
        try {
            Recipe recipe= RecipeModel.searchRecipe(txtRecipeId.getText());
            if (recipe==null){
                new Alert(Alert.AlertType.INFORMATION,"Recipe Not Found").show();
            }else {
                txtName.setText(recipe.getFoodName());
                txtDescription.setText(recipe.getDescription());


            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    public void btnUpdateRecipeOnAction(ActionEvent actionEvent) {
        if (isRecipeIdMatcher(txtRecipeId.getText())) {
            if (isNameMatch(txtName.getText())) {
                String recipeId = txtRecipeId.getText();
                String foodName = txtName.getText();
                String description = txtDescription.getText();


                Recipe recipe = new Recipe(recipeId, foodName, description);

                try {
                    boolean isUpdated = RecipeModel.updateRecipe(recipe);
                    if (isUpdated) {
                        new Alert(Alert.AlertType.INFORMATION, "Recipe Updated Successfully").show();
                    } else {
                        new Alert(Alert.AlertType.WARNING, "Something happened!").show();
                    }


                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }else {
                new Alert(Alert.AlertType.ERROR, "Pleace Insert Valid Name").show();
                txtName.setStyle("-jfx-unfocus-color : red");
            }
        }else {
            new Alert(Alert.AlertType.ERROR, "Please check the Valid Recipe_Id.\n (R-001) Like That").show();
            txtRecipeId.setStyle("-jfx-unfocus-color : red");
        }

    }

    public void btnDeleteRecipeOnAction(ActionEvent actionEvent) {
        try {
            boolean isDeleted=   RecipeModel.deleteRecipe(txtRecipeId.getText());
            if (isDeleted){
                new Alert(Alert.AlertType.INFORMATION,"Recipe  Deleted Successfully!").show();


            }else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
