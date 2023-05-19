package ktop.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ktop.models.Homes;
import ktop.services.HomesService;

@Controller
public class HomesController {
	
	@Autowired
	private HomesService service;

	public HomesController() {}
	
	@RequestMapping("homes")
	public String viewHomesList(Model model)
	{
		List<Homes> homes = service.findAll();
		model.addAttribute("homes", homes);
		return "homes";
	}
	
	@RequestMapping("/add_home")
	public String showFormNewHome(Model model) {
		Homes nh = new Homes();
		model.addAttribute("homes", nh);
		return "add_home";
	}
	
	@PostMapping(value="/save_home")
	public String saveHome(@ModelAttribute("homes") Homes homes) {
		service.save(homes);
		return "redirect:/homes";
	}
	
	@RequestMapping("/edit_home/{id}")
	public ModelAndView showEditFormHome(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("edit_home");
		Optional<Homes> eh = service.findById(id);
		mav.addObject("homes", eh);
		return mav;
	}
	
	@RequestMapping("/delete_home/{id}")
	public String deleteHome(@PathVariable(name = "id") Long id) {
		service.deleteById(id);
		return "redirect:/homes";
	}
}