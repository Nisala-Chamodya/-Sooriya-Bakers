package lk.blacky.bakerymanagement.bo.custom.impl;

import lk.blacky.bakerymanagement.dao.DAOFactory;
import lk.blacky.bakerymanagement.dao.custom.ProductDAO;
import lk.blacky.bakerymanagement.dao.custom.RecipeDAO;
import lk.blacky.bakerymanagement.dto.RecipeDTO;
import lk.blacky.bakerymanagement.to.Product;
import lk.blacky.bakerymanagement.to.Recipe;

public class RecipeBOImpl implements RecipeBo{
    //dipendancy injection
        RecipeDAO recipeDAO = (RecipeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.RECIPE);
    @Override
    public boolean addRecipe(RecipeDTO recipe) {
        return recipeDAO.addRecipe(new Recipe(recipe.getRecipeId(),recipe.getFoodName(),recipe.getDescription()));
    }

    @Override
    public Recipe searchRecipe(String recipeId) {
        return recipeDAO.searchRecipe(recipeId);
    }

    @Override
    public boolean updateRecipe(RecipeDTO recipe) {
        return recipeDAO.updateRecipe(new Recipe(recipe.getRecipeId(),recipe.getFoodName(),recipe.getDescription()));
    }

    @Override
    public boolean deleteRecipe(String recipeId) {
        return recipeDAO.deleteRecipe(recipeId);
    }
}
