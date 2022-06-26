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

import it16306.assignment.Utils.HashUtil;
import it16306.assignment.beans.AccountModel;
import it16306.assignment.entities.Account;
import it16306.assignment.repository.AccountRepository;

@Controller
@RequestMapping("/admin/accounts")
public class AccountController {
	
	@Autowired
	private AccountRepository accRepo;

	@GetMapping("/create")
	public String create(@ModelAttribute("account") Account acc) {
		return "admin/accounts/create";
	}
	

	@PostMapping("/store")
	public String store(@Valid @ModelAttribute("account") AccountModel model, BindingResult result) {
		if (result.hasErrors()) {
			return "/admin/accounts/create";
		}
		Account acc = new Account();
		acc.setFullname(model.getFullname());
		acc.setUsername(model.getUsername());
		acc.setEmail(model.getEmail());
		acc.setPassword(model.getPassword());
		acc.setPhoto(model.getPhoto());
		acc.setAdmin(model.getAdmin());
		acc.setActivated(model.getActivated());
		String hashedPassword = HashUtil.hash(acc.getPassword());
		acc.setPassword(hashedPassword);
		this.accRepo.save(acc);
		return "redirect:/admin/accounts/index";
	}
	
	@GetMapping("index")
	public String index(
		Model model,
		@RequestParam(name="size", defaultValue="4") Integer size,
		@RequestParam(name="page", defaultValue="0") Integer page
	) {
		Pageable pageable = PageRequest.of(page, size);
		Page<Account> p = this.accRepo.findAll(pageable);
		model.addAttribute("data", p);
		return "admin/accounts/index";
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") Account account)
	{
		this.accRepo.delete(account);

		return "redirect:/admin/accounts/index";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(Model model, @PathVariable("id") Account account) {

		model.addAttribute("account", account);
		return "admin/accounts/edit";
	}
	
	@PostMapping("/update/{id}")
	public String update(@PathVariable("id") Account accountOld, AccountModel accountModel ) {
		Integer idInteger = accountOld.getId();
		String fullnameString = accountModel.getFullname();
		String usernameString = accountModel.getUsername();
		String emailString = accountModel.getEmail();
		String photoString = accountModel.getPhoto();
		String passwordString = accountModel.getPassword();
		Integer avaitedInt = accountModel.getActivated();
		Integer adminInteger = accountModel.getAdmin();
		Account account = new Account();
		account.setFullname(fullnameString);
		account.setUsername(usernameString);
		account.setEmail(emailString);
		account.setPhoto(photoString);
		account.setPassword(passwordString);
		account.setAdmin(adminInteger);
		account.setActivated(avaitedInt);
		account.setId(idInteger);
		this.accRepo.save(account);
		return "redirect:/admin/accounts/index";
	}
	
}
