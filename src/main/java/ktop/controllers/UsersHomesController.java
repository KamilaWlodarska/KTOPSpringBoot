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
import ktop.models.Users;
import ktop.models.UsersHomes;
import ktop.services.HomesService;
import ktop.services.UsersHomesService;
import ktop.services.UsersService;

@Controller
public class UsersHomesController {

	@Autowired
	private UsersHomesService service;
	@Autowired
	private UsersService serviceUser;
	@Autowired
	private HomesService serviceHome;

	public UsersHomesController() {}
	
	@RequestMapping("users_homes")
	public String viewUsersHomesList(Model model)
	{
		List<UsersHomes> users_homes = service.findAll();
		model.addAttribute("users_homes", users_homes);
		return "users_homes";
	}
	
	@RequestMapping("/add_user_home")
	public String showFormNewUserHome(Model model) {
		UsersHomes nuh = new UsersHomes();
		model.addAttribute("users_homes", nuh);
		List<Users> u = serviceUser.findAll();
		model.addAttribute("user", u);
		List<Homes> h = serviceHome.findAll();
		model.addAttribute("home", h);
		return "add_user_home";
	}
	
	@PostMapping(value="/save_user_home")
	public String saveUserHome(@ModelAttribute("users_homes") UsersHomes users_homes) {
		service.save(users_homes);
		return "redirect:/users_homes";
	}
	
	@RequestMapping("/edit_user_home/{id}")
	public ModelAndView showEditForUserHome(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("edit_user_home");
		Optional<UsersHomes> euh = service.findById(id);
		mav.addObject("users_homes", euh);
		return mav;
	}
	
	@RequestMapping("/delete_user_home/{id}")
	public String deleteUserHome(@PathVariable(name = "id") Long id) {
		service.deleteById(id);
		return "redirect:/users_homes";
	}
}