package mendix.cookingapp.services;

import mendix.cookingapp.entities.RecipeDAO;
import mendix.cookingapp.entities.RecipeDTO;
import mendix.cookingapp.exceptions.RecipeNotFoundException;
import mendix.cookingapp.repositories.RecipeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    private RecipeRepository recipeRepository;
    private static final String NOT_FOUND_MESSAGE = "A recipe with that name has not been found.";

    RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<RecipeDTO> getAllRecipes() {
        List<RecipeDAO> dbRecipeList = recipeRepository.findAll();
        List<RecipeDTO> recipeList = new ArrayList<>();

        if (dbRecipeList == null || dbRecipeList.isEmpty()) {
            throw new RecipeNotFoundException("No recipes have been found.");
        }
        for (RecipeDAO item : dbRecipeList) {
            recipeList.add(new RecipeDTO(item));
        }
        return recipeList;
    }


    public List<RecipeDTO> getAllRecipesByCategory(String category) {
        List<RecipeDAO> dbRecipeList = recipeRepository.findRecipeByCategory(category);
        List<RecipeDTO> recipeList = new ArrayList<>();

        if (dbRecipeList == null || dbRecipeList.isEmpty()) {
            throw new RecipeNotFoundException("No recipes have been found.");
        }
        for (RecipeDAO item : dbRecipeList) {
            recipeList.add(new RecipeDTO(item));
        }
        return recipeList;
    }

    public RecipeDTO getRecipeByName(String recipeName) {
        RecipeDAO dbRecipe = recipeRepository.findRecipeContainingName(recipeName);
        if (dbRecipe == null)
            throw new RecipeNotFoundException(NOT_FOUND_MESSAGE);
        return new RecipeDTO(dbRecipe);
    }

    public boolean addRecipe(RecipeDTO newRecipe) {
        if (recipeRepository.findRecipeByName(newRecipe.getName()) == null) {
            recipeRepository.saveAndFlush(new RecipeDAO(newRecipe));
            return true;
        } else throw new RecipeNotFoundException("Recipe already exists.");
    }

    public boolean updateRecipe(RecipeDTO updateRecipe) {
        RecipeDAO dbRecipe = recipeRepository.findRecipeByName(updateRecipe.getName());
        if (dbRecipe != null) {
            BeanUtils.copyProperties(new RecipeDAO(updateRecipe), dbRecipe);
            dbRecipe.setName(updateRecipe.getName());
            recipeRepository.saveAndFlush(new RecipeDAO(updateRecipe));
            return true;
        } else throw new RecipeNotFoundException(NOT_FOUND_MESSAGE);
    }

    public boolean deleteRecipe(String recipeName) {
        RecipeDAO dbRecipe = recipeRepository.findRecipeByName(recipeName);
        if (dbRecipe != null) {
            recipeRepository.delete(dbRecipe);
            return true;
        } else throw new RecipeNotFoundException(NOT_FOUND_MESSAGE);
    }
}
