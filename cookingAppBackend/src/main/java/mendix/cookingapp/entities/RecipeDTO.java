package mendix.cookingapp.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecipeDTO {

    private String name;

    private String description;

    private List<String> ingredients;

    private List<String> categories;

    public RecipeDTO() {
    }

    public RecipeDTO(String name, String description, List<String> ingredients, List<String> categories) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.categories = categories;
    }

    public RecipeDTO(RecipeDAO recipeDAO) {
        this.name = recipeDAO.getName();
        this.description = recipeDAO.getDescription();
        this.ingredients = new ArrayList<>(Arrays.asList(recipeDAO.getIngredients()));
        this.categories = new ArrayList<>(Arrays.asList(recipeDAO.getCategories()));
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "RecipeDTO{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ingredients=" + ingredients +
                ", categories=" + categories +
                '}';
    }
}
