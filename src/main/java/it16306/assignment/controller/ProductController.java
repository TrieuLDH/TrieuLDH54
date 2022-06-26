package it16306.assignment.controller;



import java.util.Date;
import java.util.List;

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

import it16306.assignment.beans.ProductModel;
import it16306.assignment.entities.Category;
import it16306.assignment.entities.Product;
import it16306.assignment.repository.CategoryRepository;
import it16306.assignment.repository.ProductRepository;

@Controller
@RequestMapping("/admin/products")
public class ProductController {

	@Autowired
	private ProductRepository proRepo;
	
	
	@Autowired
	private CategoryRepository cateRepo;
	
	
	@GetMapping("/create")
	public String create(@ModelAttribute("product") Product pro, Model model) {
		List<Category> list = this.cateRepo.findAll();
		model.addAttribute("dsCate", list);
		return "/admin/products/create";
	}
	
	@PostMapping("/store")
	public String store(ProductModel model) {
		
		Product pro = new Product();
		pro.setName(model.getName());
		pro.setImage(model.getImage());
		pro.setPrice(model.getPrice());
		pro.setAvailable(model.getAvailable());

		int idStr = model.getCategory().getId();
		Category cate = this.cateRepo.findById(idStr).get();
		pro.setCategory(cate);
		
		pro.setCreatedDate(model.getCreatedDate());

		this.proRepo.save(pro);
		return "redirect:/admin/products/index";
	}
	
	@GetMapping("/index")
	public String index(
		Model model,
		@RequestParam(name="size", defaultValue="4") Integer size,
		@RequestParam(name="page", defaultValue="0") Integer page
	) {
		List<Product> pro = this.proRepo.findAll();
		model.addAttribute("dsPro",pro);
		Pageable pageable = PageRequest.of(page, size);
		Page<Product> p = this.proRepo.findAll(pageable);
		model.addAttribute("data", p);
		return "admin/products/index";
	}
	
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") Product pro)
	{
		this.proRepo.delete(pro);

		return "redirect:/admin/products/index";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(Model model, @PathVariable("id") Product product) {

		List<Category> cate = this.cateRepo.findAll();
		model.addAttribute("dsCate", cate);
		model.addAttribute("product", product);
		return "admin/products/edit";
	}
	
	
	@PostMapping("/update/{id}")
	public String update(@PathVariable("id") Product proOld, ProductModel proModel ) {
		Integer idStr = proOld.getId();
		String nameStr = proModel.getName();
		String imgStr = proModel.getImage();
		Double priceStr = proModel.getPrice();
		Integer avaiStr = proModel.getAvailable();
//		Date date = proOld.getCreatedDate();
//		System.out.println(date);
		Product pro = this.proRepo.findById(idStr).get();
		Category cate = proModel.getCategory();
		
		Product proNew = new Product();
		proNew.setId(idStr);
		proNew.setName(nameStr);
		proNew.setImage(imgStr);
		proNew.setPrice(priceStr);
		proNew.setAvailable(avaiStr);		
		proNew.setCategory(cate);		
		proNew.setCreatedDate(pro.getCreatedDate());

		this.proRepo.save(proNew);
		return "redirect:/admin/products/index";
	}
	
	
}
