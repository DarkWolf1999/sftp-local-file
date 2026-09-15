package com.wipro.workdir.sftp_local_file.config;

import org.springframework.beans.factory.annotation.Value;

import lombok.Data;

@Data
public class FileProperties {
	@Value("${file.path.tempPath}")
	private String tempPath;
}
