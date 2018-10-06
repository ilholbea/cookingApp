package mendix.cookingapp.utils;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    static public List<String> createList(String type) {
        if (type.equals("category")) {
            List<String> ingredients = new ArrayList<>();
            ingredients.add("Categories");
            return ingredients;
        } else {
            List<String> categories = new ArrayList<>();
            categories.add("Ingredients");
            return categories;
        }
    }
}
