package com.ckt.empService.dto;

import org.springframework.stereotype.Component;

@Component
public class ResponseHeader {
	private String cmdType;
	private String cmdStatus;
	private String message;
	
	ResponseHeader(){
		
	}

	public ResponseHeader(String cmdType, String cmdStatus, String message) {
		super();
		this.cmdType = cmdType;
		this.cmdStatus = cmdStatus;
		this.message = message;
	}

	public String getCmdType() {
		return cmdType;
	}

	public void setCmdType(String cmdType) {
		this.cmdType = cmdType;
	}

	public String getCmdStatus() {
		return cmdStatus;
	}

	public void setCmdStatus(String cmdStatus) {
		this.cmdStatus = cmdStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
