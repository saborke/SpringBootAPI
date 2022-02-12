package com.example.demo.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeService {
	@Autowired
	EmployeeRepository repo;
	@Autowired
	EntityManager entityManager;
	public Employee saveEmployee(Employee employee) {
		return repo.save(employee);
	}
	public List<Employee> getAllEmployee(){
		return repo.findAll();
	}
	public void deleteAll() {
	entityManager.createNativeQuery("drop table employeetable").executeUpdate();
	}
	public Employee getEmpId(int id) {
		return repo.findById((long) id).orElse(new Employee());
	}

}
