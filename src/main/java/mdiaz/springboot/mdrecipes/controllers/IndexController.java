package mdiaz.springboot.mdrecipes.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import mdiaz.springboot.mdrecipes.domain.Category;
import mdiaz.springboot.mdrecipes.domain.UnitOfMesure;
import mdiaz.springboot.mdrecipes.repositories.CategoryRepository;
import mdiaz.springboot.mdrecipes.repositories.UnitOfMesureRepository;
import mdiaz.springboot.mdrecipes.services.RecipeService;

@Controller
public class IndexController {
	
	private final RecipeService recipeService;

	public IndexController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}


	@RequestMapping({"", "/", "/index"})
	public String getIndexPage(Model model) {
		model.addAttribute("recipes", recipeService.getRecipes());
		
		return "index";
	}
}
