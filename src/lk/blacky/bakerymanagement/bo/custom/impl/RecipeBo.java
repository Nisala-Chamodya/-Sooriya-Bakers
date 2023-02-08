package lk.blacky.bakerymanagement.bo.custom.impl;

import lk.blacky.bakerymanagement.dto.RecipeDTO;
import lk.blacky.bakerymanagement.to.Recipe;

public interface RecipeBo extends SuperBo{
    public  boolean addRecipe(RecipeDTO recipe);
    public  Recipe searchRecipe(String recipeId);
    public  boolean updateRecipe(RecipeDTO recipe);
    public  boolean deleteRecipe(String recipeId);

}
