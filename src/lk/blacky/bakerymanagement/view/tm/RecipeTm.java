package lk.blacky.bakerymanagement.view.tm;

import javafx.scene.control.Button;

public class RecipeTm {
    private String recipeId;
    private String foodName;
    private  String description;
    private Button btn;

    public RecipeTm() {
    }

    public RecipeTm(String recipeId, String foodName, String description, Button btn) {
        this.recipeId = recipeId;
        this.foodName = foodName;
        this.description = description;
        this.btn = btn;
    }

    public String getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(String recipeId) {
        this.recipeId = recipeId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
}
