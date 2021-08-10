package com.ckt.empService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ckt.empService.entity.Employee;
import com.ckt.empService.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;

	//@Autowired
	//private RestTemplate restTemplate;

	public Employee saveEmployee(Employee emp) {
		return empRepo.save(emp);
	}
	
	public Employee findEmployeeById(Integer id) {
		return empRepo.getById(id);
	}
	
	public List<Employee> getEmployeeAll() {
		return empRepo.findAll();
	}
	

}
