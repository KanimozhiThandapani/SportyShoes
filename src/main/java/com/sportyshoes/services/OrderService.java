package com.sportyshoes.services;

import java.util.List;
import com.sportyshoes.models.Order;


public interface OrderService {

	Order placeOrder(Long userId, Long productId);

	List<Order> sortOrder(String key,String ordering);

	List<Order> getAllOrderByUserId(Long userId);
	
	
	List<Order> getAllOrderByProductId(Long productId);
}