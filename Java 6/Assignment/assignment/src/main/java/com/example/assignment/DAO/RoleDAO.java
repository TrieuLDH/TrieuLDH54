package com.example.assignment.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assignment.entity.Role;

public interface RoleDAO extends JpaRepository<Role, String>{

}
