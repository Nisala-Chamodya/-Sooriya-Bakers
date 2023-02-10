package lk.blacky.bakerymanagement.dao.impl;

import lk.blacky.bakerymanagement.dao.custom.RecipeDAO;
import lk.blacky.bakerymanagement.dto.RecipeDTO;
import lk.blacky.bakerymanagement.entity.RecipeEntity;
import lk.blacky.bakerymanagement.util.CRUDUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RecipeDAOImpl implements RecipeDAO {

    public  boolean add(RecipeEntity recipe) {

        String sql = "INSERT INTO recipe VALUES (?, ?, ?)";
        try {
            return CRUDUtil.execute(sql, recipe.getRecipeId(),
                    recipe.getFoodName(), recipe.getDescription());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public  RecipeEntity search(String recipeId) {
        String sql = "SELECT * FROM recipe WHERE  recipe_id=? ";
        ResultSet resultSet = null;
        try {
            resultSet = CRUDUtil.execute(sql,recipeId);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            if (resultSet.next()) {
                return new RecipeEntity(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3)

                        );





            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public  boolean update(RecipeEntity recipe) {

        String sql = "UPDATE recipe SET name=?,description=? WHERE  recipe_id=? ";
        try {
            return CRUDUtil.execute(sql, recipe.getFoodName(), recipe.getDescription(), recipe.getRecipeId());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public  boolean delete(String recipeId) {
        String sql = "DELETE FROM recipe WHERE recipe_id=? ";
        try {
            return CRUDUtil.execute(sql, recipeId);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
return false;
    }

}
