package com.Mpahsis.Payload;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class ApiResponse {
	
	private String message;
	private boolean success;
	
	
	public ApiResponse(String message, boolean success) {
		super();
		this.message = message;
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	

}
