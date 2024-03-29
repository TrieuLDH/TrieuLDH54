package com.example.assignment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.assignment.DAO.RoleDAO;
import com.example.assignment.entity.Role;
import com.example.assignment.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleDAO rdao;

	
	public List<Role> findAll() {
		return rdao.findAll();
	}
	
	
}
