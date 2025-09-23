package com.sample.storeapi.services;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.sample.storeapi.models.Product;

public interface ProductsService {

	Product AddProduct(Product prod);
	List<Product> AddProduct(List<Product> prod);
	Product UpdateProduct(Product prod); 
	void DeleteProduct(int id);
	List<Product> GetAllProducts();
	Product getProductById(int id);
//	public optional<Product> getProductById(int id);
	
}
