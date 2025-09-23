
//This file represents table in database
package com.example.productapi.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

//This is Table name
public class Product {
	//These fields represent table column in database
	private int id;
	private String name;
	private double price;
	private String category;

}
