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
import ktop.models.ProductsCategory;
import ktop.services.HomesService;
import ktop.services.ProductsCategoryService;

@Controller
public class ProductsCategoryController {

	@Autowired
	private ProductsCategoryService service;
	@Autowired
	private HomesService serviceHome;
	
	public ProductsCategoryController() {}
	
	@RequestMapping("products_category")
	public String viewPCatList(Model model) {
		List<ProductsCategory> pcat = service.findAll();
		model.addAttribute("products_category", pcat);
		return "products_category";
	}
	
	@RequestMapping("products_category_sort")
	public String viewPCatListSort(Model model) {
		List<ProductsCategory> pcatsort = service.findAllSort();
		model.addAttribute("pcatsort", pcatsort);
		return "products_category_sort";
	}
	
	@RequestMapping("/add_product_category")
	public String showFormNewPCat(Model model) {
		ProductsCategory npc = new ProductsCategory();
		model.addAttribute("products_category", npc);
		List<Homes> h = serviceHome.findAll();
		model.addAttribute("home", h);
		return "add_product_category";
	}
	
	@PostMapping(value="/save_product_category")
	public String savePCat(@ModelAttribute("products_category") ProductsCategory pcat) {
		service.save(pcat);
		return "redirect:/products_category";
	}
	
	@RequestMapping("/edit_product_category/{id}")
	public ModelAndView showEditFormPCat(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("edit_product_category");
		Optional<ProductsCategory> epc = service.findById(id);
		mav.addObject("products_category", epc);
		return mav;
	}
	
	@RequestMapping("/delete_product_category/{id}")
	public String deletePCat(@PathVariable(name = "id") Long id) {
		service.deleteById(id);
		return "redirect:/products_category";
	}
}