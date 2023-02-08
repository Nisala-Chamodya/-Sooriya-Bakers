package lk.blacky.bakerymanagement.dao.custom;

import lk.blacky.bakerymanagement.to.Recipe;

public interface RecipeDAO {
    public  boolean addRecipe(Recipe recipe);
    public  Recipe searchRecipe(String recipeId);
    public  boolean updateRecipe(Recipe recipe);
    public  boolean deleteRecipe(String recipeId);
}
