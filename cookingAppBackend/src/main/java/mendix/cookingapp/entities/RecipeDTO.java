package mendix.cookingapp.entities;

public class RecipeDTO {

    private String name;

    private String description;

    private String ingredients;

    private String categories;

    public RecipeDTO() {
    }

    public RecipeDTO(String name, String description, String ingredients, String categories) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.categories = categories;
    }

    public RecipeDTO(RecipeDAO recipeDAO) {
        this.name = recipeDAO.getName();
        this.description = recipeDAO.getDescription();
        this.ingredients = recipeDAO.getIngredients();
        this.categories = recipeDAO.getCategories();
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
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
