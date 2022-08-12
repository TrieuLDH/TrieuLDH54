package com.example.assignment.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.assignment.DAO.OrderDAO;
import com.example.assignment.DAO.OrderDetailDAO;
import com.example.assignment.entity.Order;
import com.example.assignment.entity.OrderDetail;
import com.example.assignment.service.OrderService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import aj.org.objectweb.asm.TypeReference;

@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	OrderDAO odao;

	@Autowired
	OrderDetailDAO ddao;
	
	
	@Override
	public Order create(JsonNode orderData) {
		ObjectMapper mapper = new ObjectMapper();
		
		Order order = mapper.convertValue(orderData, Order.class);
		odao.save(order);
		
		com.fasterxml.jackson.core.type.TypeReference<List<OrderDetail>> type = new com.fasterxml.jackson.core.type.TypeReference<List<OrderDetail>>(){};
		List<OrderDetail> details = mapper.convertValue(orderData.get("orderDetails"), type)
				.stream().peek(d -> d.setOrder(order)).collect(Collectors.toList());
		ddao.saveAll(details);
		return order;
	}


	@Override
	public Order findById(Long id) {
		// TODO Auto-generated method stub
		
		return odao.findById(id).get();
	}


	@Override
	public List<Order> findByUsername(String username) {
		// TODO Auto-generated method stub
		return odao.findByUsername(username);
	}
}
