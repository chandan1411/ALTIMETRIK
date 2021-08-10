package com.ckt.empService.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ckt.empService.dto.EmployeeDetails;
import com.ckt.empService.dto.EmployeeReponse;
import com.ckt.empService.dto.ResponseHeader;
import com.ckt.empService.entity.Employee;
import com.ckt.empService.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/employee-service/profile")
@Api(value = "Employee Services")
//@Slf4j
public class EmployeeProfileController {
	private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(EmployeeProfileController.class);
	@Autowired
	private EmployeeService empService;

	@Autowired
	private EmployeeReponse employeeReponse;

	@PostMapping("/createe")
	@ApiOperation(value = "Employee record created successfully", notes = "Employee record created successfully", response = Employee.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Employee record created successfully", response = Employee.class),
							@ApiResponse(code = 400, message = "Invalid data(Bad Request)"),
							@ApiResponse(code = 404, message = "Resource Not Found"), })
	public Employee saveEmployee(@RequestBody Employee employee) {
		logger.info("EmployeeProfileController - saveEmployee() execution started! ");
		return empService.saveEmployee(employee);
	}

	@GetMapping("/get/{id}")
	@ApiOperation(value = "Retrieve Employee details based on ID", notes = "Retrieve Employee details based on ID", response = EmployeeReponse.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Employee details found Successfully", response = EmployeeReponse.class),
							@ApiResponse(code = 400, message = "Invalid data(Bad Request)"),
							@ApiResponse(code = 404, message = "Resource Not Found"), })
	public EmployeeReponse findEmployeeById(/*@RequestHeader(name = "X-CLIENT-NAME", required = true) String clientName,*/@PathVariable("id") Integer id) {
		logger.info("EmployeeProfileController - findEmployeeById() execution started! :::");
		Employee employee = empService.findEmployeeById(id);
		if (Optional.ofNullable(employee).isPresent()) {
			System.out.println("Inside If::"+employee.getEmpName());
			employeeReponse.setResponseHeader(new ResponseHeader("response", "SUCCESS", "Success"));
			employeeReponse.setEmployeeDetails(new EmployeeDetails(employee.getEmpId(), employee.getEmpName(), employee.getRole(),employee.getDept()));
		} else {
			employeeReponse.setResponseHeader(
					new ResponseHeader("response", "FAIL", "Employee Details not found foir given ID"));
		}
		return employeeReponse;
	}

	@GetMapping("/get")
	@ApiOperation(value = "Retrieve All Employee details based on ID", notes = "Retrieve All Employee details", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Employee details found Successfully", response = List.class),
							@ApiResponse(code = 400, message = "Invalid data(Bad Request)"),
							@ApiResponse(code = 404, message = "Resource Not Found"), })
	public List<Employee> getEmployeeAll() {
		logger.info("EmployeeProfileController - getEmployeeAll() execution started! ");
		return empService.getEmployeeAll();
	}

}
