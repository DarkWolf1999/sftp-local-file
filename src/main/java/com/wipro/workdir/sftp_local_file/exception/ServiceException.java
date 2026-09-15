package com.wipro.workdir.sftp_local_file.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

import lombok.Getter;

@Getter
public class ServiceException extends ResponseStatusException{
	
	private final Integer errCode;

	public ServiceException(HttpStatus status, int errorCode, String reason) {
		super(status, reason);
		this.errCode = errorCode;
	}
	
	public ServiceException(HttpStatus status, int errorCode, String reason, Throwable cause) {
		super(status, reason, cause);
		this.errCode = errorCode;
	}
	
	public ServiceException(HttpStatusCode status, int errorCode, String reason) {
		super(status, reason);
		this.errCode = errorCode;
	}
	
	public ServiceException(HttpStatusCode status, int errorCode, String reason, Throwable cause) {
		super(status, reason, cause);
		this.errCode = errorCode;
	}
	
}
