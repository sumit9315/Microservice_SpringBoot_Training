package com.sample.storeapi.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

//if products table is their in db, it will create connection with db otherwise it will create new table in db
@Table(name="Products")
@Entity//this explain Products is a data base entity and this class should map to this table
public class Product {
//	@Column(name="id")
//	private int Pid;
	
	@Id //primary key of table and it is manadatory to have
	@GeneratedValue(strategy = GenerationType.IDENTITY )//SQL generated auto incremented column so java /system will skip insertion of value for this column
	private int id;
	private String name;
	private String category;
	private float price;
//	as db doesn't have column db will skip this and ignore
//	private string sample;
	
//	@Transient
//	private String transcationTime;
	
}
