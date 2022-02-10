package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000")
public class ProductController {
	@Autowired
	private ProductService service;
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		return service.saveProduct(product);
	}
	
	@PostMapping("/addProducts")
	public List <Product> addProducts(@RequestBody List<Product> products) {
		return service.saveProducts(products);
	}
	
	
   @GetMapping("/fetchProducts")
	public List <Product> findAllProduct(){
		return service.getAlls();
	}
   @DeleteMapping("/delete/{id}")
   public String deleteDta(@PathVariable int id) {
	   return service.deleteProduct(id);
   }
   @GetMapping("/oneProduct/{id}")
   public Product getOneProduct(@PathVariable int id) {
	   return service.findProductByIdOne(id);
   }
   @PutMapping("/update")
   public Product update(@RequestBody Product product) {
	   return service.updateData(product);
   }
	@GetMapping("/oneProductByNmae/{name}")
   public Product getdataByname(@PathVariable String name) {
		return service.getproductByName(name);
	   
   }

}
