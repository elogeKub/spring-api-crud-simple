package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repository;
	
	public Product saveProduct(Product product) {
		return repository.save(product);
		
	}
	
	public List<Product> saveProducts(List<Product> products) {
		return repository.saveAll(products);
		
	}
	 
	public List <Product> getAlls(){
	
		return repository.findAll();
	}
	
	public Product findProductByIdOne(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public String deleteProduct(int id) {
		String deleteMessage="data deleted success";
	  repository.deleteById(id) ;
	  return deleteMessage +id;
	}
	
	public Product updateData(Product product) {
		Product dataAllready=repository.findById(product.getId()).orElse(null);
		dataAllready.setName(product.getName());
		dataAllready.setPrice(product.getPrice());
		dataAllready.setQuantity(product.getQuantity());
		return repository.save(dataAllready);
	}
	public Product getproductByName(String name) {
		return repository.findByName(name);
	}
}
