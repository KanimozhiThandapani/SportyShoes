package com.sportyshoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.models.Product;
import com.sportyshoes.services.ProductService;

@RestController()
@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@PostMapping("/add")
	public Product createUser(@RequestBody Product product) {
	return productService.addProduct(product);
	}

	@GetMapping("/{productId}")
	public Product getProductById(@PathVariable Long productId) {
	return productService.getProductById(productId);
	}

	@GetMapping("/all")
	public List<Product> getAllProducts() {
	return productService.getAllProducts();
	}

	@GetMapping("/search")
	public Product getProductByName(@RequestParam String name) {
	return productService.getProductByName(name);
	}
	
	@PatchMapping("/{productId}/update/name")
	public Product updateProductByName(@PathVariable Long productId,String name) {
	return productService.updateProductByName(productId,name);
	}
	
	@PatchMapping("/{productId}/update/msrp")
	public Product updateProductByMsrp(@PathVariable Long productId,  Double msrp) {
	return productService.updateProductByMsrp(productId, msrp);
	}
	
	@PatchMapping("/{productId}/update/quantityInStock")
	public Product updateProductByQualityInStock(@PathVariable Long productId ,Boolean stock) {
	return productService.updateProductByQualityInStock(productId, stock);
	}
	
	@PatchMapping("/{productId}/update/productVendor")
	public Product updateProductByVendor(@PathVariable Long productId , String vendor) {
	return productService.updateProductByVendor(productId,vendor);
	}

	@DeleteMapping("/{productId}")
	public void deleteProductById(@PathVariable Long productId) {
	productService.deleteProductById(productId);
	}

}