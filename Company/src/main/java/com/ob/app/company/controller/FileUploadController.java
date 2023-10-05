package com.ob.app.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ob.app.helper.FileUploadHelper;

@RestController
public class FileUploadController {

	@Autowired
	private FileUploadHelper fileUploadHelper;

	@PostMapping("/uploadLogo")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
		System.out.println(file.getOriginalFilename());

		try {
			if(file.isEmpty()) {
				return new ResponseEntity<String>("Request must contains file", HttpStatus.INTERNAL_SERVER_ERROR);
			}
			if(!file.getContentType().equals("text/plain")) {
				return new ResponseEntity<String>("only txt files are allowed", HttpStatus.INTERNAL_SERVER_ERROR);
			}

			boolean f =  fileUploadHelper.uploadFile(file);
			if(f)
			{
				return new ResponseEntity<String>( "file uploaded successfully", HttpStatus.OK); 
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<String>("something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
