package it16306.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it16306.assignment.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
