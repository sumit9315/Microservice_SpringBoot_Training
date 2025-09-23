package com.sample.storeapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.storeapi.models.Product;
import com.sample.storeapi.repos.ProductsRepo;


@Service
public class ProductServiceImpl implements ProductsService {

//	ProductsRepo repo =new ProductsRepo();
	
	//using DI
	@Autowired
	ProductsRepo repo;
	
//	or
	
//	private final ProductsRepo repo;
	
	
	@Override
	public Product AddProduct(Product prod) {
		return repo.save(prod);
	}
	
	@Override
	public List<Product> AddProduct(List<Product> prod){
		return repo.saveAll(prod);
	}
	@Override
	public Product UpdateProduct(Product prod) {
		return repo.save(prod);
	}

	@Override
	public void DeleteProduct(int id) {
		repo.deleteById(id);

	}

	@Override
	public List<Product> GetAllProducts() {
		return repo.findAll();
		}

	@Override
	public Product getProductById(int id) {
		return repo.findById(id).get();
		}
//	@Override
//	public optional<Product> getProductById(int id) {
//		return repo.findById(id);
//		}
}
