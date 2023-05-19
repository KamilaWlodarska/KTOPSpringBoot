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

import ktop.models.Products;
import ktop.models.ProductsCategory;
import ktop.services.ProductsCategoryService;
import ktop.services.ProductsService;

@Controller
public class ProductsController {

	@Autowired
	private ProductsService service;
	@Autowired
	private ProductsCategoryService servicePCat;
	
	public ProductsController() {}
	
	@RequestMapping("products")
	public String viewProductsList(Model model)
	{
		List<Products> products = service.findAll();
		model.addAttribute("products", products);
		return "products";
	}
	
	@RequestMapping("products_sort")
	public String viewProductListSort(Model model) {
		List<Products> productsort = service.findAllSort();
		model.addAttribute("productsort", productsort);
		return "products_sort";
	}
	
	@RequestMapping("/add_product")
	public String showFormNewProduct(Model model) {
		Products np = new Products();
		model.addAttribute("products", np);
		List<ProductsCategory> pcat = servicePCat.findAll();
		model.addAttribute("pcat", pcat);
		return "add_product";
	}
	
	@PostMapping(value="/save_product")
	public String saveProduct(@ModelAttribute("products") Products products) {
		service.save(products);
		return "redirect:/products";
	}
	
	@RequestMapping("/edit_product/{id}")
	public ModelAndView showEditFormProduct(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("edit_product");
		Optional<Products> ep = service.findById(id);
		mav.addObject("products", ep);
		return mav;
	}
	
	@RequestMapping("/delete_product/{id}")
	public String deletePCat(@PathVariable(name = "id") Long id) {
		service.deleteById(id);
		return "redirect:/products";
	}
}