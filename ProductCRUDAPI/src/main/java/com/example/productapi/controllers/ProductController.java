package com.example.productapi.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.productapi.models.Product;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	//creating a static database or repository or products of product type
	//List<Product> product is a class which represent Model of product 
//	Products is a variable that will contains model of product class which is of a list type
	private static List<Product> Products= new ArrayList<>();
	
	static {
//		sortcut ctrl+alt+downarrow to copy
		
//		Making a new product of Product class from Model Product using new keyword
//		new Product(1, "Product-1", 5000, "Electronics")
//		and than adding it to Products list.
//		Products.add()
		Products.add(new Product(1, "Product-1", 5000, "Electronics"));
		Products.add(new Product(2, "Product-2", 6500, "Mobiles"));
		Products.add(new Product(3, "Product-3", 4200, "Mobiles"));
		Products.add(new Product(4, "Product-4", 3120, "Electronics"));
		Products.add(new Product(5, "Product-5", 9220, "Automobiles"));
		Products.add(new Product(6, "Product-6", 8250, "Automobiles"));
	}
	
//	@GetMapping
//	public List<Product>getAllProducts()
//	{
////		returning entire list as return type of function is List of Product
//		return Products;
//	}
	
	@GetMapping
	public ResponseEntity<List<Product>>getAllProducts()
	{
//		returning entire list as return type of function is List of Product
//		return ResponseEntity.ok(Products);
		return ResponseEntity.status(HttpStatus.OK).body(Products);
		
	}
	
//	@GetMapping("/{id}")
//	public Product getProductById(@PathVariable int id)
//	{
//		//3 Make an object of product class so that i can store the object retreived from list 
//		Product prod= new Product();
////1		loop through product list
//		for(Product product:Products)
//		{
//			//2 getId() is getter method formed by lombok and I am accessing that using Product object
//			if(product.getId()==id)
//			{
////				4 product found so assign to object
//				prod=product;
////				5 break as product found so no need to check again in list
//				break;
//			}
//		}
////		6 if product id doesn't match than return an empty product with 
////		defaut value as 0 or nullfor int and string property.
//		return prod;
////		output of this line for requested get method on http://localhost:8080/products/40
////		as product with id 40 is not present in list of product above 
////		{
////		    "id": 0,
////		    "name": null,
////		    "price": 0.0,
////		    "category": null
////		
//////		}
////	}
		
		@GetMapping("/{id}")
		public ResponseEntity <Product> getProductById(@PathVariable int id)
		{
			//3 Make an object of product class so that i can store the object retreived from list 
			Product prod= new Product();
	//1		loop through product list
			for(Product product:Products)
			{
				
				if(product.getId()==id)
				{

					prod=product;

					break;
				}
			}
			if(prod.getId()!=0)
			{
//				return ResponseEntity.ok(prod);
//				when returning some data in response than use .body(T)
				return ResponseEntity.status(HttpStatus.OK).body(prod);
			}
			else
			{
//				when not returning some data in response than use .build()
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}

		}
		
		@PostMapping
		public ResponseEntity<Product>AddProduct(@RequestBody Product product)
		{
			product.setId(Products.size()+1);
			Products.add(product);
			
//			return ResponseEntity.ok(product);
			return ResponseEntity.status(HttpStatus.CREATED).body(product);
			
		}
		
		@PutMapping("/{id}")
		public ResponseEntity<String>UpdateProduct(@PathVariable int id,@RequestBody Product Inproduct)
		{
			for(Product product:Products) 
			{
				if(product.getId()==id)
				{
					product.setName(Inproduct.getName());
					product.setPrice(Inproduct.getPrice());
					product.setCategory(Inproduct.getCategory());
					return ResponseEntity.status(HttpStatus.OK).body("Product Details updated Succesfully");
				}
			}
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Product matched with given Id");
		}
		

		@PatchMapping("/{id}")
		public ResponseEntity<String>UpdateAllProduct(@PathVariable int id,@RequestBody Product Inproduct)
		{
			for(Product product:Products) 
			{
				if(product.getId()==id)
				{
					product.setName(Inproduct.getName());
					product.setPrice(Inproduct.getPrice());
					product.setCategory(Inproduct.getCategory());
					return ResponseEntity.status(HttpStatus.OK).body("Product Details updated Succesfully");
				}
			}
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Product matched with given Id");
		}
		
		@DeleteMapping("/{id}")
		public ResponseEntity<String>DeleteProduct(@PathVariable int id)
		{
			if(Products.removeIf(prod->prod.getId()==id)) 
			{
				return ResponseEntity.status(HttpStatus.OK).body("Product id"+ " "+ id +" Deleted Succesfully");
			}
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Product Found with Given Id"+id);
		}
		
		
		
		
}

