package com.wipro.workdir.sftp_local_file.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.workdir.sftp_local_file.model.SftpFile;
import com.wipro.workdir.sftp_local_file.service.FileService;

import reactor.core.publisher.Mono;

@RestController
public class SftpController {
	@Autowired
	private FileService fileService;

	@PostMapping
	public Mono<ResponseEntity<HttpStatus>> file(@RequestBody SftpFile sftpFile){
		HttpStatus response = HttpStatus.BAD_REQUEST;
		
		if(fileService.isValidRequest(sftpFile)) {
			boolean actionStatus = fileService.saveFile(sftpFile);
			response = actionStatus ? HttpStatus.ACCEPTED : HttpStatus.INTERNAL_SERVER_ERROR;
		} else {
			response = HttpStatus.BAD_REQUEST;
		}
		return Mono.just(ResponseEntity.status(response).body(response));
	}
}
