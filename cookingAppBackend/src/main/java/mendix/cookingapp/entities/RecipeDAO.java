package mendix.cookingapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RECIPE")
public class RecipeDAO {

    @Id
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "ingredients")
    private String ingredients;

    @Column(name = "categories")
    private String categories;

    @Column(name = "steps")
    private String steps;

    public RecipeDAO() {
    }

    public RecipeDAO(String name, String description, String ingredients, String categories, String steps) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.categories = categories;
        this.steps = steps;
    }

    public RecipeDAO(RecipeDTO recipeDTO) {
        this.name = recipeDTO.getName();
        this.description = recipeDTO.getDescription();
        this.ingredients = recipeDTO.getIngredients();
        this.categories = recipeDTO.getCategories();
        this.steps =  recipeDTO.getSteps();
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
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

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "RecipeDAO{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", categories='" + categories + '\'' +
                ", steps='" + steps + '\'' +
                '}';
    }
}
