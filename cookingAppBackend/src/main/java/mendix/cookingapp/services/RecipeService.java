package mendix.cookingapp.services;

import mendix.cookingapp.entities.RecipeDTO;

import java.util.List;

public interface RecipeService {

    List<RecipeDTO> getAllRecipes();

    List<RecipeDTO> getAllRecipesByCategory(String category);

    RecipeDTO getRecipeByName(String recipeName);

    boolean addRecipe(RecipeDTO newRecipe);

    boolean updateRecipe(RecipeDTO updateRecipe);

    boolean deleteRecipe(String recipeName);
}

