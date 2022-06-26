package it16306.assignment.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
public class ShopingController {

//	public String homeDetail() {
//		
//	}
	
}
