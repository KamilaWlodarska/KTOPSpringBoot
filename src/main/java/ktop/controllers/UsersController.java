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

import ktop.models.Users;
import ktop.services.UsersService;

@Controller
public class UsersController {
	
	@Autowired
	private UsersService service;

	public UsersController() {}
	
	@RequestMapping("users")
	public String viewUsersList(Model model)
	{
		List<Users> users = service.findAll();
		model.addAttribute("users", users);
		return "users";
	}
	
	@RequestMapping("/add_user")
	public String showFormNewUser(Model model) {
		Users nu = new Users();
		model.addAttribute("users", nu);
		return "add_user";
	}
	
	@PostMapping(value="/save_user")
	public String saveUser(@ModelAttribute("users") Users users) {
		service.save(users);
		return "redirect:/users";
	}
	
	@RequestMapping("/edit_user/{id}")
	public ModelAndView showEditForUser(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("edit_user");
		Optional<Users> eu = service.findById(id);
		mav.addObject("users", eu);
		return mav;
	}
	
	@RequestMapping("/delete_user/{id}")
	public String deleteUser(@PathVariable(name = "id") Long id) {
		service.deleteById(id);
		return "redirect:/users";
	}
}