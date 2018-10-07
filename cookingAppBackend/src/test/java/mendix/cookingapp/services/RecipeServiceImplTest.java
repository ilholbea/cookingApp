package mendix.cookingapp.services;

import mendix.cookingapp.entities.RecipeDAO;
import mendix.cookingapp.entities.RecipeDTO;
import mendix.cookingapp.repositories.RecipeRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RecipeServiceImplTest {


    private RecipeServiceImpl recipeService;

    @Mock
    private RecipeRepository recipeRepositoryMock;

    @Before
    public void before() {
        recipeService = new RecipeServiceImpl(recipeRepositoryMock);
    }

    @Test
    public void getAllRecipes() {
        RecipeDTO expectedRecipe = new RecipeDTO("Recipe", "Description", "ingredient", "category");
        Mockito.when(recipeRepositoryMock.findAll())
                .thenReturn(Arrays.asList(new RecipeDAO("Recipe", "Description", "Ingredients", "Categories")));
        List<RecipeDTO> recipeList = recipeService.getAllRecipes();

        Assert.assertEquals(1, recipeList.size());
        Assert.assertTrue(recipeList.get(0).getName().equals(expectedRecipe.getName()));
    }


    @Test
    public void getRecipeByName() {
        RecipeDTO expectedRecipe = new RecipeDTO("Recipe", "Description", "ingredient", "category");
        Mockito.when(recipeRepositoryMock.findRecipeContainingName("Recipe"))
                .thenReturn(new RecipeDAO("Recipe", "Description", "Ingredients", "Categories"));
        RecipeDTO foundRecipe = recipeService.getRecipeByName("Recipe");
        Assert.assertTrue(foundRecipe.getName().equals(expectedRecipe.getName()));
    }


    @Test
    public void addRecipe() {
        RecipeDTO newRecipe = new RecipeDTO("Recipe", "Description", "ingredient", "category");
        Mockito.when(recipeRepositoryMock.saveAndFlush(new RecipeDAO(newRecipe)))
                .thenReturn(new RecipeDAO(newRecipe));
        Assert.assertTrue(recipeService.addRecipe(newRecipe));
    }


    @Test
    public void updateRecipe() {
        RecipeDTO updatedRecipe = new RecipeDTO("Recipe", "Description", "ingredient", "category");
        Mockito.when(recipeRepositoryMock.saveAndFlush(new RecipeDAO(updatedRecipe)))
                .thenReturn(new RecipeDAO(updatedRecipe));
        Assert.assertTrue(recipeService.addRecipe(updatedRecipe));
    }

}
