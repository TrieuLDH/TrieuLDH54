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

import it16306.assignment.beans.OrderDetailModel;
import it16306.assignment.beans.OrderModel;
import it16306.assignment.entities.Account;
import it16306.assignment.entities.Order;
import it16306.assignment.entities.OrderDetail;
import it16306.assignment.entities.Product;
import it16306.assignment.repository.AccountRepository;
import it16306.assignment.repository.OrderDetailRepository;
import it16306.assignment.repository.OrderRepository;
import it16306.assignment.repository.ProductRepository;

@Controller
@RequestMapping("/admin/orderDetail")
public class OrderDetailConstroller {
	
	@Autowired
	private OrderDetailRepository orderDeatilRepo;
	
	@Autowired
	private ProductRepository proRepo;

	@Autowired
	private AccountRepository accRepo;
	
	
	@Autowired
	private OrderRepository orderRepo;
	

	@GetMapping("/index")
	public String index(Model model, @RequestParam(name = "size", defaultValue = "6") Integer size,
			@RequestParam(name = "page", defaultValue = "0") Integer page,
			@ModelAttribute("orderDetail") OrderDetailModel orderDetail, @ModelAttribute("oder") OrderModel oder) {

		List<OrderDetail> listOd =this.orderDeatilRepo.finODetailbyOderId(0);
		if(listOd.size()>0) {
		model.addAttribute("dataOrder",listOd);
		double thanhtien =0;
		for (OrderDetail orderDetails : listOd) {
			thanhtien += orderDetails.getPrice();
		}
		model.addAttribute("thanhtien",thanhtien);
		}
		Pageable pageable = PageRequest.of(page, size);
		System.out.println(pageable);
		Page<Product> p = this.proRepo.findAll(pageable);
		model.addAttribute("data", p);
		return "admin/orderDetail/homeDetail";

	}
	
	@PostMapping("/store/{id}")
	public String store(
		@PathVariable("id") Product product,
		OrderDetail oderdetail
	) 
	{		
		OrderDetail check = this.orderDeatilRepo.findbyOrderdetail(0, product.getId());
		
		
		if(check == null) {
			OrderDetail od = new OrderDetail();
			od.setPrice(product.getPrice()*oderdetail.getQuantity());
			od.setQuantity(oderdetail.getQuantity());
			od.setProduct(product);
			od.setOrderId(0);
			
			this.orderDeatilRepo.save(od);
		}else {
			OrderDetail od = new OrderDetail();
			od.setPrice(product.getPrice()*oderdetail.getQuantity());
			od.setQuantity(check.getQuantity() + oderdetail.getQuantity());
			od.setProduct(product);
			od.setOrderId(0);
			od.setId(check.getId());
			
			this.orderDeatilRepo.save(od);
		}
		
		
		return "redirect:/admin/orderDetail/index";
	}
	
	@PostMapping("/update/{id}")
	public String update(
		@PathVariable("id") Product product,
		OrderDetail oderdetail
	) 
	{		
		OrderDetail check = this.orderDeatilRepo.findbyOrderdetail(0, product.getId());
		
			OrderDetail od = new OrderDetail();
			od.setPrice(product.getPrice()*oderdetail.getQuantity());
			od.setQuantity(oderdetail.getQuantity());
			od.setProduct(product);
			od.setOrderId(0);
			od.setId(check.getId());
			
			this.orderDeatilRepo.save(od);
		
		return "redirect:/admin/orderDetail/index";
	}
	
//	@GetMapping("/buy")
//	public String buy(
//			Model model,
//			@ModelAttribute("oder") OrderModel oder
//			) {
//		
//		List<OrderDetail> lod=this.orderDeatilRepo.finODetailbyOderId(0);
//		if(lod.size()>0) {
//		model.addAttribute("data",lod);
//		double thanhtien =0;
//		for (OrderDetail orderDetails : lod) {
//			thanhtien += orderDetails.getPrice();
//		}
//		model.addAttribute("thanhtien",thanhtien);
//		return "/admin/orderDetail/gio_hang";
//		}else {
//			return "redirect:/admin/orderDetail/index";
//		}
//	}
	
	@PostMapping("add")
	public String add(OrderModel oder) {
		List<OrderDetail> listOd =this.orderDeatilRepo.finODetailbyOderId(0);
		int idstr= this.orderRepo.finMaxIdOrder();
		int idadd = idstr+1;
		
		Account acc = this.accRepo.findbyid(1);
		
		Order o = new Order();
		o.setAddress(oder.getAddress());
		o.setAccount(acc);
		o.setCreatedDate(oder.getCreatedDate());
		
		
		for (OrderDetail orderDetails : listOd) {
			orderDetails.setOrderId(idadd);
			this.orderDeatilRepo.save(orderDetails);
		}
		this.orderRepo.save(o);
		return "redirect:/admin/orderDetail/index";
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") OrderDetail orderdetail)
	{
		this.orderDeatilRepo.delete(orderdetail);

		return "redirect:/admin/orderDetail/index";
	}
	
}
