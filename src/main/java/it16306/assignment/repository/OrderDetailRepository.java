package it16306.assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it16306.assignment.entities.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer>{

	@Query(value = "SELECT acc FROM OrderDetail acc WHERE acc.orderId = :id AND acc.product.id = :idPro ") 
	public OrderDetail findbyOrderdetail(@Param("id") int id,@Param("idPro") int idPro);
	
	@Query(value = "SELECT acc FROM OrderDetail acc WHERE acc.orderId = :id ") 
	public List<OrderDetail> finODetailbyOderId(@Param("id") int id);
}
