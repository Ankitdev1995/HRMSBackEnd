package com.ob.app.helper;

import java.io.FileOutputStream;
import java.io.InputStream;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
		
	public final String UPLOAD_DIR = "C:\\Users\\OB-Anikt\\Documents\\HRMS\\Company\\src\\main\\resources\\static\\image";

	public boolean uploadFile(MultipartFile multipartFile) {
		boolean f = false;
		try {
			InputStream inputStream = multipartFile.getInputStream();
			byte data[] = new byte[inputStream.available()];

			inputStream.read(data);

			FileOutputStream fileOutputStream = new FileOutputStream(UPLOAD_DIR + "\\" + multipartFile.getOriginalFilename());

			fileOutputStream.write(data);
			fileOutputStream.flush();
			fileOutputStream.close();
			f = true;
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
}
