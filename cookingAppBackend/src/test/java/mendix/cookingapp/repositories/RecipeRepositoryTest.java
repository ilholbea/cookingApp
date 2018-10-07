package mendix.cookingapp.repositories;

import mendix.cookingapp.entities.RecipeDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class RecipeRepositoryTest {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void findAll() {
        RecipeDAO firstRecipe = new RecipeDAO("Recipe1", "Description1", "Ingredient1", "Category1","steps");
        entityManager.persist(firstRecipe);
        entityManager.flush();
        List<RecipeDAO> recipeList = recipeRepository.findAll();
        assertThat(recipeList.size()).isNotEqualTo(0);
    }

    @Test
    public void findRecipeByName() {
        RecipeDAO firstRecipe = new RecipeDAO("Recipe1", "Description1", "Ingredient1", "Category1","steps");
        entityManager.persist(firstRecipe);
        entityManager.flush();
        assertThat(recipeRepository.findRecipeByName("Recipe1")).isNotNull();
    }

    @Test
    public void findRecipesByName() {
        RecipeDAO firstRecipe = new RecipeDAO("Recipe1", "Description1", "Ingredient1", "Salad","steps");
        entityManager.persist(firstRecipe);
        entityManager.flush();
        assertThat(recipeRepository.findRecipeByCategory("Recipe1")).isNotNull();
    }

    @Test
    public void containsRecipeName() {
        RecipeDAO firstRecipe = new RecipeDAO("Recipe1", "Description1", "Ingredient1", "Category1","steps");
        entityManager.persist(firstRecipe);
        entityManager.flush();
        assertThat(recipeRepository.findRecipeContainingName("1")).isNotNull();
    }


}
