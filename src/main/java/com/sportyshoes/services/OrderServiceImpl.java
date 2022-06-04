package com.sportyshoes.services;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sportyshoes.dao.OrderDao;
import com.sportyshoes.dao.ProductDao;
import com.sportyshoes.dao.UserDao;
import com.sportyshoes.models.Order;
import com.sportyshoes.models.User;
import com.sportyshoes.models.Product;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private ProductDao productDao;

	@Override
	public Order placeOrder(Long userId, Long productId) {
		User user = userDao.findById(userId).get();
		Product product = productDao.findById(productId).get();
		Order order = new Order();
		order.setUser(user);
		order.setProduct(product);
		order.setOrderDate(new Date());
		return orderDao.save(order);
	}

	@Override
	public List<Order> sortOrder(String key, String ordering) {
		if (key.equals("orderDate") && ordering.equalsIgnoreCase("ASC")) {
			return orderDao.findAllByOrderByOrderDate();

		} else if (key.equalsIgnoreCase("orderDate") && ordering.equalsIgnoreCase("DESC")) {
			return orderDao.findAllByOrderByOrderDateDesc();

		} else if (key.equalsIgnoreCase("orderId") && ordering.equalsIgnoreCase("ASC")) {
			return orderDao.findAllByOrderById();

		} else if (key.equalsIgnoreCase("orderId") && ordering.equalsIgnoreCase("DESC")) {
			return orderDao.findAllByOrderByIdDesc();
		} else {
			return orderDao.findAll();
		}
	}

	@Override
	public List<Order> getAllOrderByUserId(Long userId) {
		return orderDao.getAllOrderByUserId(userId);
	}

	@Override
	public List<Order> getAllOrderByProductId(Long productId) {
		return orderDao.getAllOrderByProductId(productId);
	}

	

}