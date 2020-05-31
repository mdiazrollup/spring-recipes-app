package mdiaz.springboot.mdrecipes.controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import mdiaz.springboot.mdrecipes.domain.Recipe;
import mdiaz.springboot.mdrecipes.services.RecipeService;

public class IndexControllerTest {
	
	@Mock
	RecipeService recipeService;
	
	@Mock
	Model model;
	
	IndexController controller;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		controller = new IndexController(recipeService);
	}
	
	@Test
	public void getIndexPage() throws Exception {
		
		//given
		Set<Recipe> recipes=new HashSet<>();
		Recipe recipe1 = new Recipe();
		recipe1.setId(1L);
		recipes.add(recipe1);
		
		Recipe recipe2 = new Recipe();
		recipe1.setId(2L);
		recipes.add(recipe2);
		
		when(recipeService.getRecipes()).thenReturn(recipes);
		
		ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);
		
		//when
		String viewName = controller.getIndexPage(model);
		
		//then
		assertEquals("index", viewName);
		verify(recipeService,times(1)).getRecipes();
		verify(model, times(1)).addAttribute(eq("recipes"),argumentCaptor.capture());
		Set<Recipe> setInController = argumentCaptor.getValue();
		assertEquals(2, setInController.size());
	}
	
	@Test
	public void testMockMVC() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		mockMvc.perform(get("/")).
		andExpect(status().isOk()).
		andExpect(view().name("index"));
	}

}
