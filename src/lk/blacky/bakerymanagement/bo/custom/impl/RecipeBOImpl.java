package lk.blacky.bakerymanagement.bo.custom.impl;

import lk.blacky.bakerymanagement.dao.DAOFactory;
import lk.blacky.bakerymanagement.dao.custom.RecipeDAO;
import lk.blacky.bakerymanagement.dto.RecipeDTO;

public class RecipeBOImpl implements RecipeBo{
    //dipendancy injection
        RecipeDAO recipeDAO = (RecipeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.RECIPE);
    @Override
    public boolean addRecipe(RecipeDTO recipe) {
        return recipeDAO.add(new RecipeDTO(recipe.getRecipeId(),recipe.getFoodName(),recipe.getDescription()));
    }

    @Override
    public RecipeDTO searchRecipe(String recipeId) {
        return recipeDAO.search(recipeId);
    }

    @Override
    public boolean updateRecipe(RecipeDTO recipe) {
        return recipeDAO.update(new RecipeDTO(recipe.getRecipeId(),recipe.getFoodName(),recipe.getDescription()));
    }

    @Override
    public boolean deleteRecipe(String recipeId) {
        return recipeDAO.delete(recipeId);
    }
}
