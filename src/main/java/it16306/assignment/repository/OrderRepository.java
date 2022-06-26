package it16306.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it16306.assignment.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{
	@Query(value = "SELECT Max(acc.id) FROM Order acc ") 
	public int finMaxIdOrder();
}
