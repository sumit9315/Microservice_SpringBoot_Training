package com.example.demo.Controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class Employees {
	
	@GetMapping("/greet")
	public String SayHi()
	{
		return "Hey User!";
	}
	
	@PostMapping("/add/{inp}")
//	public String GetInput(@RequestBody String inp)
	public String PostInputByPath(@PathVariable String inp)
	{
		return "Recieved Input:"+inp;
	}
	
	@PostMapping("/add/body/")
	public String PostInputViaBody(@RequestBody String inp)
//	public String GetInput(@PathVariable String inp)
	{
		return "Recieved Input:"+inp;
	}
	
	@PostMapping("/add/query/")
	public String PostInputViaQuery( @RequestParam String inp)
//	public String GetInput(@PathVariable String inp)
	{
		return "Recieved Input:"+inp;
	}
	
	@DeleteMapping("/delete/{id}")
	public String DeleteData(@PathVariable int id)
	{
		return "You Are Trying to Delete Record With Id:"+id;
	}
	
//	@PutMapping("update/{id}")
	@PutMapping("/update/{id}")
	public String UpdateData(@PathVariable int id,@RequestBody String val)
	{
		if(id!=0)
		{
			return "Updated Successfully";
		}
		return "Id is required";
	}
	
	
	
}
