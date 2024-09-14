package com.aiet.ecommerce_application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aiet.ecommerce_application.model.Product;
import com.aiet.ecommerce_application.repository.ProductRepository;

@Service
public class ProducService {
	
	
	private ProductRepository productRepository;

	@Autowired
	public ProducService(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}
	
	//get all products
	public List<Product> getAllProducts(){
		
		return productRepository.findAll();
	}
	
	//get product by id
	public Product getProductById(Long id) {
		
		return productRepository.findById(id).orElseThrow(() -> 
		new RuntimeException("Product not found"));
	}
	
	//add product to the database
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}
	
	//get the expensive product
	public List<Product> getExpensiveProduct(double price){
		
		return productRepository.findByPriceGreaterThan(price);
	}
	
	//delete the product by id 
	public void deleteProduct(Long id) {
		 productRepository.deleteById(id);
	}
	
	
	

}
