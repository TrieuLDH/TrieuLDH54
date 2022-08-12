package com.example.assignment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.assignment.DAO.CategoryDAO;
import com.example.assignment.entity.Category;
import com.example.assignment.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	CategoryDAO cdao;
	
	
	@Override
	public List<Category> findAll(){
		return cdao.findAll();
	}
}
