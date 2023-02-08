package lk.blacky.bakerymanagement.dto;

public class RecipeDTO {
   private String recipeId;
    private   String foodName;
    private   String description;

    public RecipeDTO() {
    }

    public RecipeDTO(String recipeId, String foodName, String description) {
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

    @Override
    public String toString() {
        return "RecipeDTO{" +
                "recipeId='" + recipeId + '\'' +
                ", foodName='" + foodName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
