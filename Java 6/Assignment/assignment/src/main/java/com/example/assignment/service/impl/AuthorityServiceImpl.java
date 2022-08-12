package com.example.assignment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.assignment.DAO.AccountDAO;
import com.example.assignment.DAO.AuthorityDAO;
import com.example.assignment.entity.Account;
import com.example.assignment.entity.Authority;
import com.example.assignment.service.AuthorityService;

@Service
public class AuthorityServiceImpl implements AuthorityService{
	
	@Autowired
	AuthorityDAO dao;
	
	@Autowired
	AccountDAO acdao;

	
	public List<Authority> findAuthoritiesOfAdministrators() {
		List<Account> accounts = acdao.getAdministrators();
		return dao.authoritiesOf(accounts);
	}

	
	public Authority create(Authority auth) {
		return dao.save(auth);
	}
	
	public void delete(Integer id) {
		dao.deleteById(id);
	}


	
	public List<Authority> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
