package mendix.cookingapp.services;

import mendix.cookingapp.entities.RecipeDAO;
import mendix.cookingapp.entities.RecipeDTO;
import mendix.cookingapp.exceptions.RecipeNotFoundException;
import mendix.cookingapp.repositories.RecipeRepository;
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
        List<RecipeDAO> recipeDAOList = recipeRepository.findAll();
        List<RecipeDTO> recipeList = new ArrayList<>();

        if (recipeDAOList == null || recipeDAOList.size() == 0) {
            throw new RecipeNotFoundException("No recipes have been found.");
        }
        for (RecipeDAO item : recipeDAOList) {
            recipeList.add(new RecipeDTO(item));
        }
        return recipeList;
    }

    public RecipeDTO getRecipeByName(String recipeName) throws RecipeNotFoundException {
        RecipeDAO recipeDAO = recipeRepository.findRecipeByName(recipeName);
        if (recipeDAO == null)
            throw new RecipeNotFoundException("A recipe with that name has not been found.");
        return new RecipeDTO(recipeDAO);
    }

    public RecipeDTO addRecipe(RecipeDTO recipeDTO) {
        RecipeDAO recipeDAO = recipeRepository.saveAndFlush(new RecipeDAO(recipeDTO));
        return new RecipeDTO(recipeDAO);
    }

}
