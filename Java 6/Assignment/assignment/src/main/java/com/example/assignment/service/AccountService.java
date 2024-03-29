package com.example.assignment.service;

import java.util.List;

import com.example.assignment.entity.Account;

public interface AccountService {
	
	public Account findById(String username);

	public List<Account> getAdministrators();

	public List<Account> findAll();
}
