package com.sample.storeapi.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sample.storeapi.models.Product;

//creating  repo to work with db withoutout implementing any crud operation
//public interface EmployeesRepo extends JpaRepository<T, ID> T-template(Database  Entity to work on),data type of Id on which primary key
public interface ProductsRepo extends JpaRepository<Product, Integer>{

	
//	ProductsRepo pro= new ProductsRepo();
//	pro.countBy(); jparepository provides all inbuilt databse method like count by ,find all etc
//	pro.
	
//	@Query("Select pr.name from Products pr where :category")
//	List<Product>findByProductwithCategory(String category);
}
