package com.wipro.workdir.sftp_local_file.service;

import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.wipro.workdir.sftp_local_file.config.FileProperties;
import com.wipro.workdir.sftp_local_file.exception.ServiceException;
import com.wipro.workdir.sftp_local_file.model.SftpFile;

@Service
public class FileService {
	@Autowired
	private FileProperties properties;
	
	@Autowired
	private SftpFile file;

	public boolean isValidRequest(SftpFile sftpFile) {
		if(!Base64.isBase64(sftpFile.getContent())) {
			throw new ServiceException(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(), "Content is not base64 encoded");
		}
		return true;
	}

	public boolean saveFile(SftpFile sftpFile) {
		boolean actionStatus = false;
		String localFilePath = properties.getTempPath() + file.getFileName();
		
		try {
			boolean isFileCreated = createFile(localFilePath, sftpFile);
			actionStatus = true;
		} catch (Exception e) {
			throw new ServiceException(HttpStatus.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(),e);
		}
		return actionStatus;
	}

	private boolean createFile(String localFilePath, SftpFile sftpFile) throws IOException{
		try (FileWriter writer = new FileWriter(localFilePath)){
			writer.write(sftpFile.getContent()); 
		} 
		return true;
	}

}
