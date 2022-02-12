package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	EmployeeService ser;
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> FetchAll(){
		return new ResponseEntity<List<Employee>>(ser.getAllEmployee(),HttpStatus.OK);
		
	}
	@PostMapping("/save")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(ser.saveEmployee(employee),HttpStatus.CREATED);
	}
	@DeleteMapping("/deleteall")
	public void deleteAll(){
		ser.deleteAll();
	}
	@GetMapping("/")
	public String home() {
		return "Welcome home";
	}

}
