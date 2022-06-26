package it16306.assignment.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it16306.assignment.beans.OrderModel;
import it16306.assignment.entities.Account;
import it16306.assignment.entities.Order;
import it16306.assignment.repository.AccountRepository;
import it16306.assignment.repository.OrderRepository;

@Controller
@RequestMapping("/admin/order")
public class OrderController {

	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private AccountRepository accrepo;
	
	
	@GetMapping("/create")
	public String create(@ModelAttribute("order") Order order, Model model) {
		List<Account> acc = this.accrepo.findAll();
		model.addAttribute("dsAcc",acc);
		return "/admin/order/create";
	}
	
	
	@PostMapping("/store")
	public String store(OrderModel model) {
		Order order = new Order();
		order.setCreatedDate(model.getCreatedDate());
		order.setAddress(model.getAddress());
		int idStr = model.getAccount().getId();
		Account acc = this.accrepo.findById(idStr).get();
		order.setAccount(acc);
		this.orderRepo.save(order);
		return "redirect:/admin/order/index";
	}
	
	@GetMapping("index")
	public String index(
		Model model,
		@RequestParam(name="size", defaultValue="4") Integer size,
		@RequestParam(name="page", defaultValue="0") Integer page
	) {
		Pageable pageable = PageRequest.of(page, size);
		Page<Order> or = this.orderRepo.findAll(pageable);
		model.addAttribute("data", or);
		return "admin/order/index";
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") Order ord)
	{
		this.orderRepo.delete(ord);

		return "redirect:/admin/order/index";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(Model model, @PathVariable("id") Order ord) {

		List<Account> acc = this.accrepo.findAll();
		model.addAttribute("dsAcc", acc);
		model.addAttribute("order", ord);
		return "admin/order/edit";
	}
	
	@PostMapping("/update/{id}")
	public String update(@PathVariable("id") Order orderOld, OrderModel orderModel ) {
		Integer idInteger = orderOld.getId();
		String addStr = orderModel.getAddress();
		Date dateStr = orderModel.getCreatedDate();
		Account account = orderModel.getAccount();
		Order orNew = new Order();
		orNew.setId(idInteger);
		orNew.setAddress(addStr);
		orNew.setCreatedDate(dateStr);
		orNew.setAccount(account);
		this.orderRepo.save(orNew);
		return "redirect:/admin/order/index";
	}
}
