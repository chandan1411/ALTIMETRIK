package com.ckt.empService.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEES")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="EMPLOYEE_ID")
	private Integer empId;
	@Column(name="EMPLOYEE_NAME")
	private String empName;
	@Column(name="JOB")
	private String role;
	@Column(name="DEPARTMENT_ID")
	private String dept;
	
	public Employee() {
		
	}
	public Employee(Integer empId, String empName, String role,String dept) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.role = role;
		this.dept = dept;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}

}
