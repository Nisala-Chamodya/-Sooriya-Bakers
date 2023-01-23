package lk.blacky.bakerymanagement.to;

public class Recipe {
    String recipeId;
    String foodName;
    String description;

    public Recipe() {
    }

    public Recipe(String recipeId, String foodName, String description) {
        this.recipeId = recipeId;
        this.foodName = foodName;
        this.description = description;
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
}
