package com.ckt.empService.exception;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ckt.empService.dto.ErrorResponse;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(EntityNotFoundException.class)
	@ResponseBody
	public List<ErrorResponse> handleMethodArgumentNotValid(HttpServletRequest req, EntityNotFoundException ex) {

		List<ErrorResponse> errorList = new ArrayList<ErrorResponse>();
		errorList.add(
				new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage(), "Employee Not found!", req.getRequestURI()));
		return errorList;
	}

}
