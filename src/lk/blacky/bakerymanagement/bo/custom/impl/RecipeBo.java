package lk.blacky.bakerymanagement.bo.custom.impl;

import lk.blacky.bakerymanagement.dto.RecipeDTO;
import lk.blacky.bakerymanagement.to.Recipe;

import java.sql.SQLException;

public interface RecipeBo extends SuperBo{
    public  boolean addRecipe(RecipeDTO recipe) throws SQLException, ClassNotFoundException;
    public  RecipeDTO searchRecipe(String recipeId);
    public  boolean updateRecipe(RecipeDTO recipe);
    public  boolean deleteRecipe(String recipeId);

}
