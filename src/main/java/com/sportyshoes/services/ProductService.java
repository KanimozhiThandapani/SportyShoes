package com.sportyshoes.services;

import java.util.List;

import com.sportyshoes.models.Product;

public interface ProductService {
	
	public Product getProductById(Long productId);

	public List<Product> getAllProducts();

	public Product getProductByName(String userName);

	public Product addProduct(Product product);

	public void deleteProductById(Long productId);

	public Product updateProductByVendor(Long productId, String vendor);

	public Product updateProductByQualityInStock(Long productId, Boolean quantityInStock);

	 public Product updateProductByMsrp(Long productId, Double msrp);

	public Product updateProductByName(Long productId,String name);
	

}
