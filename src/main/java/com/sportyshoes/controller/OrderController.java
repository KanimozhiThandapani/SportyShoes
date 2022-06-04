package com.sportyshoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.services.OrderService;
import com.sportyshoes.models.Order;
import com.sportyshoes.models.Product;

@RestController()
@RequestMapping("/api/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/all/sorted")
	public List<Order> sortOrder(@RequestParam(name="key") String key,@RequestParam(name="ordering") String ordering) {
		return orderService.sortOrder(key,ordering);
	}
	
	
	@GetMapping("/{userId}")
	public List<Order> getAllOrderByUserId(@PathVariable Long userId) {
	  return orderService.getAllOrderByUserId(userId);
	}
	
//	  @GetMapping("all/{userId}") public List<Order>
//	  getAllOrderByUserId(@PathVariable(name="userId") Long userId) { return
//	  orderService.getAllOrderByUserId(userId); }
	  
	  @GetMapping("all/{productId}") public List<Order>
	  getAllOrderByProductId(@PathVariable(name="productId") Long productId) { return
	  orderService.getAllOrderByProductId(productId); }
	 
	

}