package fi.digiprojekti.yummy.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.digiprojekti.yummy.domain.MainRepository;
import fi.digiprojekti.yummy.domain.Recipe;
import fi.digiprojekti.yummy.domain.RecipeRepository;
import fi.digiprojekti.yummy.domain.RegimenRepository;

@Controller
public class RecipeController {
	
	@Autowired
	private RecipeRepository recipeRepository;
	
	@Autowired
	private RegimenRepository regimenRepository;
	
	@Autowired
	private MainRepository mainRepository;
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/*")
	public String showFrontpage() {
		return "frontpage";
	}
	
	@RequestMapping(value = "/recipes")
	public String recipeList(Model model) {
		model.addAttribute("recipes", recipeRepository.findAll());
		return "recipes";
	}
	
	@RequestMapping(value = "/recipes/{id}", method = RequestMethod.GET)
	public String searchRecipeShow(@PathVariable("id") Long Id, Model model) {
		model.addAttribute("recipes", recipeRepository.findById(Id).get());
		model.addAttribute("regimens", regimenRepository.findAll());
		model.addAttribute("mains", mainRepository.findAll());
		return "showrecipe";
	}
	
	@RequestMapping(value = "/showrecipe/{id}", method = RequestMethod.GET)
	public String recipeShow(@PathVariable("id") Long Id, Model model) {
		model.addAttribute("recipes", recipeRepository.findById(Id).get());
		model.addAttribute("regimens", regimenRepository.findAll());
		model.addAttribute("mains", mainRepository.findAll());
		return "showrecipe";
	}
	
	@RequestMapping(value = "/addrecipe")
	public String recipeAdd(Model model) {
		model.addAttribute("recipe", new Recipe());
		model.addAttribute("regimens", regimenRepository.findAll());
		model.addAttribute("mains", mainRepository.findAll());
		return "addrecipe";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String recipeSave(@Valid Recipe recipe, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("regimens", regimenRepository.findAll());
			model.addAttribute("mains", mainRepository.findAll());
			return "addrecipe";
		}
		
		recipeRepository.save(recipe);
		return "redirect:recipes";
	}
	
	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "/modifyrecipe/{id}", method = RequestMethod.GET)
	public String recipeEdit(@PathVariable("id") Long editId, Model model) {
		model.addAttribute("modifyRecipe", recipeRepository.findById(editId).get());
		model.addAttribute("regimens", regimenRepository.findAll());
		model.addAttribute("mains", mainRepository.findAll());
		return "modifyrecipe";
	}
	
	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET) //Takes the id
	public String recipeDelete(@PathVariable("id") Long delId, Model model) { //Saves the id
		recipeRepository.deleteById(delId); //Deletes row according to saved id from repository
		return "redirect:../recipes"; //Re-routes back to recipe list after deletion
	}

}
