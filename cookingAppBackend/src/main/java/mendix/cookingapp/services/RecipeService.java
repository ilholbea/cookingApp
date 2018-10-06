package mendix.cookingapp.services;

import mendix.cookingapp.entities.RecipeDTO;
import mendix.cookingapp.exceptions.RecipeNotFoundException;

import java.util.List;

public interface RecipeService {

    List<RecipeDTO> getAllRecipes() throws RecipeNotFoundException;

    RecipeDTO getRecipeByName(String recipeName) throws RecipeNotFoundException;

    RecipeDTO addRecipe(RecipeDTO newRecipe) throws RecipeNotFoundException;

    RecipeDTO updateRecipe(RecipeDTO updateRecipe) throws RecipeNotFoundException;

    void deleteRecipe(String recipeName) throws RecipeNotFoundException;
}

