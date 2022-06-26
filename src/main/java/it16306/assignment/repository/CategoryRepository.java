package it16306.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it16306.assignment.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
//	@Query(value = "SELECT acc FROM Category acc WHERE acc.id = :id ") 
//	public Category fincatebyid(@Param("id")  int id);
}
