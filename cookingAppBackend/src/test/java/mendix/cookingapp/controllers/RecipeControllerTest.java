package mendix.cookingapp.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import mendix.cookingapp.entities.RecipeDTO;
import mendix.cookingapp.services.RecipeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RecipeControllerTest {

    @Autowired
    private RecipeController recipeController;

    @MockBean
    private RecipeService recipeServiceMock;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getAllRecipes() throws Exception {

        given(recipeServiceMock.getAllRecipes()).willReturn(Arrays.asList(new RecipeDTO("Recipe1", "Description1", "ingredient", "category","steps1=")));

        mvc.perform(get("/api/recipes")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is("Recipe1")));
    }

    @Test
    public void getAllRecipesByCategory() throws Exception {

        given(recipeServiceMock.getAllRecipesByCategory("gory")).willReturn(Arrays.asList(new RecipeDTO("Recipe1", "Description1", "ingredient", "category","steps1=")));

        mvc.perform(get("/api/recipes/category/gory")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is("Recipe1")))
                .andExpect(jsonPath("$[0].categories",is("category")));
    }




    @Test
    public void getRecipeByName() throws Exception {
        given(recipeServiceMock.getRecipeByName("Recipe1")).willReturn(new RecipeDTO("Recipe1", "Description1", "ingredient", "category","steps"));
        mvc.perform(get("/api/recipes/Recipe1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Recipe1")));
    }


    @Test
    public void addRecipe() throws Exception {
        RecipeDTO newRecipe = new RecipeDTO("Recipe1", "Description1", "ingredient", "category","steps");
        given(recipeServiceMock.addRecipe(newRecipe)).willReturn(true);
        mvc.perform(post("/api/recipes/")
                .content(objectMapper.writeValueAsBytes(newRecipe))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void updateRecipe() throws Exception {
        RecipeDTO updatedRecipe = new RecipeDTO("Recipe1", "Description1", "ingredient", "category","steps");
        given(recipeServiceMock.updateRecipe(updatedRecipe)).willReturn(true);
        mvc.perform(put("/api/recipes/")
                .content(objectMapper.writeValueAsBytes(updatedRecipe))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteRecipe() throws Exception {
        given(recipeServiceMock.deleteRecipe("Recipe1")).willReturn(true);
        mvc.perform(delete("/api/recipes/Recipe1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


}
