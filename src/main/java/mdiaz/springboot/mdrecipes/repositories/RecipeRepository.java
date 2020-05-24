package mdiaz.springboot.mdrecipes.repositories;

import org.springframework.data.repository.CrudRepository;

import mdiaz.springboot.mdrecipes.domain.Recipe;

public interface RecipeRepository extends  CrudRepository<Recipe, Long>{

}
