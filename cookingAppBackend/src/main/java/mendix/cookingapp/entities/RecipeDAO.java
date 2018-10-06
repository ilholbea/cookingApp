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

    public RecipeDAO() {
    }

    public RecipeDAO(String name, String description, String ingredients, String categories) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.categories = categories;
    }

    public RecipeDAO(RecipeDTO recipeDTO) {
        this.name = recipeDTO.getName();
        this.description = recipeDTO.getDescription();
        this.ingredients = String.join(",", recipeDTO.getIngredients());
        this.categories = String.join(",", recipeDTO.getCategories());
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
                '}';
    }
}
