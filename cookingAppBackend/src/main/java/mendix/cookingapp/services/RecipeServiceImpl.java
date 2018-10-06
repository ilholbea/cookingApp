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

    RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<RecipeDTO> getAllRecipes() throws RecipeNotFoundException {
        List<RecipeDAO> dbRecipeList = recipeRepository.findAll();
        List<RecipeDTO> recipeList = new ArrayList<>();

        if (dbRecipeList == null || dbRecipeList.size() == 0) {
            throw new RecipeNotFoundException("No recipes have been found.");
        }
        for (RecipeDAO item : dbRecipeList) {
            recipeList.add(new RecipeDTO(item));
        }
        return recipeList;
    }

    public RecipeDTO getRecipeByName(String recipeName) throws RecipeNotFoundException {
        RecipeDAO dbRecipe = recipeRepository.findRecipeContainingName(recipeName);
        if (dbRecipe == null)
            throw new RecipeNotFoundException("A recipe with that name has not been found.");
        return new RecipeDTO(dbRecipe);
    }

    public RecipeDTO addRecipe(RecipeDTO newRecipe) throws RecipeNotFoundException {
        if (recipeRepository.findRecipeByName(newRecipe.getName()) == null) {
            RecipeDAO dbRecipe = recipeRepository.saveAndFlush(new RecipeDAO(newRecipe));
            return new RecipeDTO(dbRecipe);
        } else throw new RecipeNotFoundException("Recipe already exists.");
    }

    public RecipeDTO updateRecipe(RecipeDTO updateRecipe) throws RecipeNotFoundException {
        RecipeDAO dbRecipe = recipeRepository.findRecipeByName(updateRecipe.getName());
        if (dbRecipe != null) {
            BeanUtils.copyProperties(new RecipeDAO(updateRecipe), dbRecipe);
            dbRecipe.setName(updateRecipe.getName());
            return new RecipeDTO(recipeRepository.saveAndFlush(new RecipeDAO(updateRecipe)));
        } else throw new RecipeNotFoundException("A recipe with that name has not been found.");
    }

    public void deleteRecipe(String recipeName) throws RecipeNotFoundException {
        RecipeDAO dbRecipe = recipeRepository.findRecipeByName(recipeName);
        if (dbRecipe != null) {
            recipeRepository.delete(dbRecipe);
        } else throw new RecipeNotFoundException("A recipe with that name has not been found.");
    }
}
