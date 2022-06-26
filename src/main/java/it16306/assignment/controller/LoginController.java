package it16306.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import it16306.assignment.repository.AccountRepository;

@Controller
@RequestMapping("/admin/Logins")
public class LoginController {
	
	@Autowired
	private AccountRepository accRepo;
	
	@GetMapping("/login")
	public String login(@ModelAttribute("account") Model model) {
		return "admin/Logins/login";
	}

}
