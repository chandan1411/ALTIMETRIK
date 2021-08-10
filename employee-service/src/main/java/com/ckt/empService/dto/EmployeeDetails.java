package com.ckt.empService.dto;

import org.springframework.stereotype.Component;

@Component
public class EmployeeDetails {
	private Integer employeeId;
	private String name;
	private String designation;
	private String department;
	
	EmployeeDetails(){
		
	}

	public EmployeeDetails(Integer employeeId, String name, String designation, String department) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.designation = designation;
		this.department = department;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
