package it16306.assignment.homecontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it16306.assignment.Utils.HashUtil;
import it16306.assignment.entities.Account;
import it16306.assignment.repository.AccountRepository;

@Controller
public class HomeController {
	
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private AccountRepository accountRepo;

	@GetMapping("/login")
	public String getLoginForm() {
		return "/admin/Logins/login";
	}
	
	@PostMapping("/login")
	public String login(
		@RequestParam("email") String email,
		@RequestParam("password") String password
	) {
		Account entity = this.accountRepo.findByEmail(email);
		HttpSession session = request.getSession();
		if (entity == null) {
			session.setAttribute("error", "Sai email hoặc mật khẩu");
			return "/admin/Logins/login";
		}

		boolean checkPwd = HashUtil.verify(password, entity.getPassword());
		if (!checkPwd) {
			session.setAttribute("error", "Sai email hoặc mật khẩu");
			return "/admin/Logins/login";
		}
		
		session.setAttribute("account", entity);
		return "redirect:/layout";
	}
	
	
	@GetMapping("layout")
	public String index() {
		return "admin/layout";
	}
	
	
}
