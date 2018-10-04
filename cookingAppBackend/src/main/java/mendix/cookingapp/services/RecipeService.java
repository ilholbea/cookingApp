package mendix.cookingapp.services;

import mendix.cookingapp.entities.Recipe;
import mendix.cookingapp.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    RecipeRepository recipeRepository;

    RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }


    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }


}
