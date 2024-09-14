package com.aiet.ecommerce_application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aiet.ecommerce_application.model.Product;
import com.aiet.ecommerce_application.service.ProducService;

@RestController
@RequestMapping("api/products")
public class ProductController {
	
	private ProducService producService;

	@Autowired
	public ProductController(ProducService producService) {
		super();
		this.producService = producService;
	}
	
	@GetMapping
	public List<Product> getAllProducts(){
		return producService.getAllProducts();
	}
	
	@PostMapping
	public Product addProduct(@RequestBody Product product) {
		return producService.addProduct(product);
	}
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable Long id) {
		return producService.getProductById(id);
	}
	
	@GetMapping("/expensive")
	public List<Product> getExpensiveProduct(@RequestParam double price){
		return producService.getExpensiveProduct(price);
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable Long id) {
		producService.deleteProduct(id);
	}
	
	
	

}
