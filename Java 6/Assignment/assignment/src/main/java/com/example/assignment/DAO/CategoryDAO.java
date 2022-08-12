package com.example.assignment.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assignment.entity.Category;

public interface CategoryDAO extends JpaRepository<Category, String>{

}
