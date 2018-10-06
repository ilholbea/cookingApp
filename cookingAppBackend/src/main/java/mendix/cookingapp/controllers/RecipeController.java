package mendix.cookingapp.controllers;

import mendix.cookingapp.entities.RecipeDTO;
import mendix.cookingapp.exceptions.RecipeNotFoundException;
import mendix.cookingapp.services.RecipeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RecipeController {

    final private RecipeServiceImpl recipeService;

    @Autowired
    public RecipeController(RecipeServiceImpl recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipes")
    public ResponseEntity getAllRecipes() {
        try {
            return new ResponseEntity<>(recipeService.getAllRecipes(), HttpStatus.OK);
        } catch (RecipeNotFoundException exception) {
            return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
        }

    }


    @GetMapping("/recipes/{name}")
    public ResponseEntity getRecipeByName(@PathVariable("name") String recipeName) {
        try {
            return new ResponseEntity<>(recipeService.getRecipeByName(recipeName), HttpStatus.OK);
        } catch (RecipeNotFoundException exception) {
            return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/recipes")
    public ResponseEntity addRecipe(@RequestBody RecipeDTO recipe) {
        RecipeDTO createdRecipe;
        try {
            createdRecipe = recipeService.addRecipe(recipe);
        } catch (Exception exception) {
            return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
