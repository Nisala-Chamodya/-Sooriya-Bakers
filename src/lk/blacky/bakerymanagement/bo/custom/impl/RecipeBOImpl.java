package lk.blacky.bakerymanagement.bo.custom.impl;

import lk.blacky.bakerymanagement.dao.DAOFactory;
import lk.blacky.bakerymanagement.dao.custom.RecipeDAO;
import lk.blacky.bakerymanagement.dto.RecipeDTO;
import lk.blacky.bakerymanagement.entity.RecipeEntity;

import java.sql.SQLException;

public class RecipeBOImpl implements RecipeBo{
    //dipendancy injection
        RecipeDAO recipeDAO = (RecipeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.RECIPE);
    @Override
    public boolean addRecipe(RecipeDTO recipe) throws SQLException, ClassNotFoundException {
        return recipeDAO.add(new RecipeEntity(recipe.getRecipeId(),recipe.getFoodName(),recipe.getDescription()));
    }

    @Override
    public RecipeDTO searchRecipe(String recipeId) {

        RecipeEntity search = recipeDAO.search(recipeId);
        return new RecipeDTO(search.getRecipeId(),search.getFoodName(),search.getDescription());

    }

    @Override
    public boolean updateRecipe(RecipeDTO recipe) {
        return recipeDAO.update(new RecipeEntity(recipe.getRecipeId(),recipe.getFoodName(),recipe.getDescription()));
    }

    @Override
    public boolean deleteRecipe(String recipeId) {
        return recipeDAO.delete(recipeId);
    }
}
