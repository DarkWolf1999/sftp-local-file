package com.wipro.workdir.sftp_local_file.service;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpStatus;

import com.wipro.workdir.sftp_local_file.exception.ServiceException;
import com.wipro.workdir.sftp_local_file.model.SftpFile;

public class FileService {

	public boolean isValidRequest(SftpFile sftpFile) {
		if(!Base64.isBase64(sftpFile.getContent())) {
			throw new ServiceException(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(), "Content is not base64 encoded");
		}
		return true;
	}

	public boolean saveFile(SftpFile sftpFile) {
		// TODO Auto-generated method stub
		return false;
	}

}
