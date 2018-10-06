package mendix.cookingapp.exceptions;

public class RecipeNotFoundException extends RuntimeException {
    private String message;

    public RecipeNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}


