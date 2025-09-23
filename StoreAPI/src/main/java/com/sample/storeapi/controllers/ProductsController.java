package com.sample.storeapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sample.storeapi.StoreApiApplication;
import com.sample.storeapi.models.Product;
import com.sample.storeapi.services.ProductsService;

@RestController
@RequestMapping("/products")
public class ProductsController {

    private final StoreApiApplication storeApiApplication;
	
	@Autowired
	ProductsService serv;

    ProductsController(StoreApiApplication storeApiApplication) {
        this.storeApiApplication = storeApiApplication;
    }//created an object of service interface using DI
	
	@PostMapping
	public ResponseEntity<Product> AddProduct(@RequestBody Product prod)
	{
		return ResponseEntity.ok(serv.AddProduct(prod)) ;//called method of interface which call implementaion in return and impletion is connected to rep and repo is connected to model
	}

	@PostMapping("/add")
	public ResponseEntity<List<Product>> AddProduct(@RequestBody List<Product> prod)
	{
		return ResponseEntity.ok(serv.AddProduct(prod)) ;//called method of interface which call implementaion in return and impletion is connected to rep and repo is connected to model
	}
	@PutMapping("/{id}")
	public ResponseEntity<Product>UpdateProduct(@PathVariable int id,@RequestBody Product prod)
	{
		prod.setId(id);
		try{
//			if(prod.getId()==id)
			{
			return ResponseEntity.ok(serv.UpdateProduct(prod));
			}
//			else
//			{
//				 return ResponseEntity.notFound().build();
//			}
			

		}
		catch(Exception ex)
		{
			 return ResponseEntity.notFound().build();
//			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> GetAll()
	{
		return ResponseEntity.ok(serv.GetAllProducts());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> GetById(@PathVariable int id)
	{
		try {
			Product prod = serv.getProductById(id);
			return ResponseEntity.ok(prod);
//			return ResponseEntity.ok(serv.getProductById(id));
		}
		catch(Exception ex)
		{
			return ResponseEntity.notFound().build();		
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> DeleteProduct(@PathVariable int id)
	{
		try {
			
			Product prod =serv.getProductById(id);
			if(prod.getId()==id)
			{
			serv.DeleteProduct(id);
			return ResponseEntity.ok("Deleted Successfully!");
			}
			else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No data found for given Id");
			}
		}
		catch(Exception ex)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No data found for given Id");
		}
	}
}
