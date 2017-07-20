package com.howtodoinjava.demo.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.howtodoinjava.demo.model.Employee;

@RestController
public class EmployeeController {
	
	@RequestMapping("/")
    public List<Employee> getEmployees() 
    {
		List<Employee> employeesList = new ArrayList<Employee>();
		employeesList.add(new Employee(1,"lokesh","gupta","howtodoinjava@gmail.com"));
		return employeesList;
    }
	
	@RequestMapping(value="/employee/{id}/name/{name}", method = RequestMethod.POST)
	public ResponseEntity<Employee> getEmployees(@PathVariable("id") Long id, @PathVariable("name") String name,@RequestBody Map<String,Employee> employee) {
		
		System.out.println("id: "+id+"name: "+ name +"employee: "+employee);
		
		return null;
	}
	
	
	@RequestMapping(value="/string/{id}/name/{name}", method = RequestMethod.POST)
	public ResponseEntity<Employee> getString(@PathVariable("id") Long id, @PathVariable("name") String name,HttpServletRequest httpServletRequest) {
		StringBuilder buffer = new StringBuilder();
		try {
        ServletInputStream sis = httpServletRequest.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(sis));
        String line;
        while((line = reader.readLine()) != null){
            buffer.append(line);
        }
		}catch(IOException e) {
			
		}
		System.out.println("id: "+id+" name: "+ name +" String: "+buffer.toString());
		
		return null;
	}

}
