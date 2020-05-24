package mdiaz.springboot.mdrecipes.services;

import java.util.Set;

import mdiaz.springboot.mdrecipes.domain.Recipe;

public interface RecipeService {
	Set<Recipe> getRecipes();
}
