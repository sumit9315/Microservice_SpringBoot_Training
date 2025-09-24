package com.example.productapi.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
//import org.mockito.internal.matchers.GreaterThan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.greaterThan;

@WebMvcTest(ProductController.class)
public class ProductsControllerTest {
	
	@Autowired
	private MockMvc mockmvc;
	
	@Test
	void testDefaultProduct()throws Exception{
		mockmvc.perform(get("/products")).andExpect(status().isOk()).andExpect(jsonPath("$.length()",greaterThan(5)));

	}
}
