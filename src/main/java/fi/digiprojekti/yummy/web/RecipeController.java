package fi.digiprojekti.yummy.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.digiprojekti.yummy.domain.MainRepository;
import fi.digiprojekti.yummy.domain.RecipeRepository;
import fi.digiprojekti.yummy.domain.RegimenRepository;
import fi.digiprojekti.yummy.domain.Recipe;

@Controller
public class RecipeController {
	
	@Autowired
	private RecipeRepository recipeRepository;
	
	@Autowired
	private RegimenRepository regimenRepository;
	
	@Autowired
	private MainRepository mainRepository;
	
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

}
