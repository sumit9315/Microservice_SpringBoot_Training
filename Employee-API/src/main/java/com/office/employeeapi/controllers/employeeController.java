package com.office.employeeapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.office.employeeapi.models.AddressResponse;
import com.office.employeeapi.models.Employee;
import com.office.employeeapi.models.EmployeeResponse;
import com.office.employeeapi.services.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class employeeController {
	
	@Autowired
	EmployeeService serv;
	
	@Autowired
	RestTemplate rest; //it is an http client which will make an API call..It consume API and get the result inside my API
	
	@Value("${address.api.base-url}")
	private String baseURL;
	
	@Autowired
	private EurekaClient eurekaClient;
	
	@GetMapping("/{id}")
//	public ResponseEntity<Employee> getEmployeeByid(@PathVariable int id)
	public ResponseEntity<EmployeeResponse> getEmployeeByid(@PathVariable int id)
	{
		List<InstanceInfo> instnaces=eurekaClient.getApplication("Address-API").getInstances();
		
//		for(InstanceInfo instance : instnaces)
//		{
//			System.out.println(instance);
//		}
		
//		String url=baseURL+"/api/address/"+id;// forming url using concatination as id is coming for employee api will also be passed to address api
		String url=instnaces.get(0).getHomePageUrl()+"api/address/"+id;
		AddressResponse addressResponse=rest.getForObject(url, AddressResponse.class);//calling other api endpoint
	
		System.out.println(addressResponse);
		
		Employee emp =serv.getEmployeeById(id);
		EmployeeResponse employeeRes=new EmployeeResponse();
		employeeRes.setId(emp.getId());
		employeeRes.setName(emp.getName());
		employeeRes.setAge(emp.getAge());
		employeeRes.setEmail(emp.getEmail());
		employeeRes.setAddress(addressResponse);
		
//		return serv.getEmployeeById(id);
		return ResponseEntity.ok(employeeRes);
	}

}
