package mendix.cookingapp.repositories;


import mendix.cookingapp.entities.RecipeDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<RecipeDAO, String> {

    @Query("select recipe from RecipeDAO recipe where recipe.name like %:recipeName%")
    RecipeDAO findRecipeByName(@Param("recipeName") String recipeName);
}
