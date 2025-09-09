package com.sample;

import lombok.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	
	private int id;
	private String name;
	private double price;
	
	@Getter(value= AccessLevel.NONE)
	@Setter(value = AccessLevel.NONE)
//	@ToString.Exclude
	private String Category;
	
//	public int getId() { 
//		return id;
//	}
//	@Override
//	public String toString() {
//		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
//	} 
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public double getPrice() {
//		return price;
//	}
//	public void setPrice(double price) {
//		this.price = price;
//	}

}
