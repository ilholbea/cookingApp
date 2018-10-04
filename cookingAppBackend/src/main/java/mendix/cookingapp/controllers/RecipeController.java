package mendix.cookingapp.controllers;

import mendix.cookingapp.entities.Recipe;
import mendix.cookingapp.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/getAll")
    public List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }
}
