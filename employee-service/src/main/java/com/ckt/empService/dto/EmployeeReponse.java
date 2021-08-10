package com.ckt.empService.dto;

import org.springframework.stereotype.Component;

@Component
public class EmployeeReponse {
private ResponseHeader responseHeader;
private EmployeeDetails employeeDetails;

public EmployeeReponse() {
	
}

public EmployeeReponse(EmployeeDetails employeeDetails, ResponseHeader responseHeader) {
	super();
	this.responseHeader = responseHeader;
	this.employeeDetails = employeeDetails;
}

public EmployeeDetails getEmployeeDetails() {
	return employeeDetails;
}

public void setEmployeeDetails(EmployeeDetails employeeDetails) {
	this.employeeDetails = employeeDetails;
}

public ResponseHeader getResponseHeader() {
	return responseHeader;
}

public void setResponseHeader(ResponseHeader responseHeader) {
	this.responseHeader = responseHeader;
}

}
