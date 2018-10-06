package mendix.cookingapp.controllers;

import mendix.cookingapp.entities.RecipeDTO;
import mendix.cookingapp.exceptions.RecipeNotFoundException;
import mendix.cookingapp.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("recipes")
    public ResponseEntity getAllRecipes() {
        try {
            return new ResponseEntity<>(recipeService.getAllRecipes(), HttpStatus.OK);
        } catch (RecipeNotFoundException exception) {
            return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
        } catch (Exception exception) {
            return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("recipes/{name}")
    public ResponseEntity getRecipeByName(@PathVariable("name") String recipeName) {
        try {
            return new ResponseEntity<>(recipeService.getRecipeByName(recipeName), HttpStatus.OK);
        } catch (RecipeNotFoundException exception) {
            return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("recipes")
    public ResponseEntity addRecipe(@RequestBody RecipeDTO newRecipe) {
        try {
            return new ResponseEntity(recipeService.addRecipe(newRecipe), HttpStatus.CREATED);
        } catch (RecipeNotFoundException exception) {
            return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping("recipes")
    public ResponseEntity updateRecipe(@RequestBody RecipeDTO updatedRecipe) {
        try {
            return new ResponseEntity(recipeService.updateRecipe(updatedRecipe), HttpStatus.OK);
        } catch (RecipeNotFoundException exception) {
            return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("recipes/{name}")
    public ResponseEntity deleteRecipe(@PathVariable("name") String recipeName) {
        try {
            return new ResponseEntity(recipeService.deleteRecipe(recipeName), HttpStatus.OK);
        } catch (RecipeNotFoundException exception) {
            return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
