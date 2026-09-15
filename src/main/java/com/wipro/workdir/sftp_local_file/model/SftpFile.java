package com.wipro.workdir.sftp_local_file.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SftpFile {
	@JsonProperty("fileName")
	@NotEmpty(message="'fileName' should not be null/empty")
	@Pattern(regexp = "(^[_\\-a-zA-Z0-9.]+\\.([a-z]+$)", message = "Invalid fileName")
	private String fileName;
	
	@JsonProperty("content")
	@NotEmpty(message="'content' should not be null/empty")
	private String content;

}
