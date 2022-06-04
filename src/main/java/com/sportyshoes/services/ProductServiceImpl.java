package com.sportyshoes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sportyshoes.dao.ProductDao;
import com.sportyshoes.models.Product;
import com.sportyshoes.exception.SportyShoesNotFoundException;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;

	@Override
	public Product getProductById(Long productId) {
		return productDao.getById(productId);
	}

	@Override
	public List<Product> getAllProducts() {
		return productDao.findAll();
	}

	@Override
	public Product getProductByName(String productName) {
		return productDao.findByName(productName).get();
	}

	@Override
	public Product addProduct(Product product) {
		return productDao.save(product);
	}

	@Override
	public void deleteProductById(Long productId) {
		Product product = productDao.findById(productId).orElse(null);
		productDao.delete(product);
	}

	@Override
	public Product updateProductByVendor(Long productId, String vendor) {
		Product product = productDao.findById(productId)
				.orElseThrow(() -> new SportyShoesNotFoundException("Product not found on this id :: " + productId));
		product.setVendor(vendor);
		return productDao.save(product);
	}

	@Override
	public Product updateProductByMsrp(Long productId, Double msrp) {
		Product product = productDao.findById(productId)
				.orElseThrow(() -> new SportyShoesNotFoundException("Product not found on this id :: " + productId));
		product.setMsrp(msrp);
		return productDao.save(product);
	}

	@Override
	public Product updateProductByQualityInStock(Long productId, Boolean quantityInStock) {
		Product product = productDao.findById(productId)
				.orElseThrow(() -> new SportyShoesNotFoundException("Product not found on this id :: " + productId));
		product.setInStock(quantityInStock);
		return productDao.save(product);
	}

	@Override
	public Product updateProductByName(Long productId, String name) {
		Product product = productDao.findById(productId)
				.orElseThrow(() -> new SportyShoesNotFoundException("Product not found on this id :: " + productId));
		product.setName(name);
		return productDao.save(product);
	}

}