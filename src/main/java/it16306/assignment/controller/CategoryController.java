package it16306.assignment.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it16306.assignment.beans.CategoryModel;
import it16306.assignment.entities.Category;
import it16306.assignment.repository.CategoryRepository;

@Controller
@RequestMapping("/admin/categories")
public class CategoryController {

	@Autowired
	private CategoryRepository cateRepo;
	
	
	
	@GetMapping("/create")
	public String create(@ModelAttribute("cate") Category acc) {
		return "admin/categories/create";
	}
	
	@PostMapping("/store")
	public String store(@Valid @ModelAttribute("cate") CategoryModel model, BindingResult result) {
		if (result.hasErrors()) {
			return "admin/categories/create";
		}
		Category cate = new Category();
		cate.setName(model.getName());
		this.cateRepo.save(cate);
		return "redirect:/admin/categories/index";
	}
	
	@GetMapping("index")
	public String index(
		Model model,
		@RequestParam(name="size", defaultValue="4") Integer size,
		@RequestParam(name="page", defaultValue="0") Integer page
	) {
		Pageable pageable = PageRequest.of(page, size);
		Page<Category> p = this.cateRepo.findAll(pageable);
		model.addAttribute("data", p);
		return "admin/categories/index";
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") Category cate)
	{
		this.cateRepo.delete(cate);
		return "redirect:/admin/categories/index";
	}
	
	
	
	@GetMapping("/edit/{id}")
	public String edit(Model model, @PathVariable("id") Category cate) {

		model.addAttribute("cate", cate);
		return "admin/categories/edit";
	}
	
	@PostMapping("/update/{id}")
	public String update(@PathVariable("id") Category cateOld, CategoryModel cateModel ) {
		Integer idInteger = cateOld.getId();
		String nameStr = cateModel.getName();
		Category category = new Category();
		category.setId(idInteger);
		category.setName(nameStr);
		this.cateRepo.save(category);
		return "redirect:/admin/categories/index";
	}
}
