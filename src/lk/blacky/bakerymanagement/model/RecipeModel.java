package lk.blacky.bakerymanagement.model;

import lk.blacky.bakerymanagement.to.Product;
import lk.blacky.bakerymanagement.to.Recipe;
import lk.blacky.bakerymanagement.util.CRUDUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RecipeModel {

    public static boolean addRecipe(Recipe recipe) throws SQLException, ClassNotFoundException {

        String sql = "INSERT INTO recipe VALUES (?, ?, ?)";
        return CRUDUtil.execute(sql, recipe.getRecipeId(),
                recipe.getFoodName(), recipe.getDescription());
    }

    public static Recipe searchRecipe(String recipeId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM recipe WHERE  recipe_id=? ";
        ResultSet resultSet = CRUDUtil.execute(sql,recipeId);
        if (resultSet.next()) {
            return new Recipe(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3)

                    );





        }
        return null;
    }

    public static boolean updateRecipe(Recipe recipe) throws SQLException, ClassNotFoundException {

        String sql = "UPDATE recipe SET name=?,description=? WHERE  recipe_id=? ";
        return CRUDUtil.execute(sql, recipe.getFoodName(), recipe.getDescription(), recipe.getRecipeId());
    }

    public static boolean deleteRecipe(String recipeId) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM recipe WHERE recipe_id=? ";
        return CRUDUtil.execute(sql, recipeId);

    }
}
