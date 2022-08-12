package com.example.assignment.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assignment.entity.OrderDetail;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long>{

}
