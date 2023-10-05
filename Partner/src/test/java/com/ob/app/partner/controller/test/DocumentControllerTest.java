package com.ob.app.partner.controller.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ob.app.partner.controller.DocumentController;
import com.ob.app.partner.entity.Document;

@SpringBootTest
class DocumentControllerTest {

	@Autowired
	private	DocumentController documentController;


	@Test
	void test() {
		fail("Not yet implemented");
	}


	@Test
	void saveDocumentTest() {
		Document document = new Document();

		document.setDocumentId(3);
		document.setDocumentName("Tan");
		document.setTanNo("2334545");
		ResponseEntity<String> response =  documentController.saveDocuments(document);

		assertNotNull(response);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}

	//	@Test
	//	void saveDuplicateTanNumberTest() {
	//	    // Create and save a document with a TAN number first
	//	    Document existingDocument = new Document();
	//	    existingDocument.setDocumentId(1);
	//	    existingDocument.setDocumentName("Existing Document");
	//	    existingDocument.setTanNo("9876543");
	//	    documentController.saveDocuments(existingDocument);
	//
	//	    // Attempt to save another document with the same TAN number
	//	    Document duplicateDocument = new Document();
	//	    duplicateDocument.setDocumentId(2);
	//	    duplicateDocument.setDocumentName("Duplicate Document");
	//	    duplicateDocument.setTanNo("9876543");
	//
	//	    ResponseEntity<String> response = documentController.saveDocuments(duplicateDocument);
	//
	//	    assertNotNull(response);
	//	    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	//	    // You can add more assertions here to verify the response body or other details.
	//	}



	@Test
	public void getAllDocumentTest() {
		List<Document> docList1 = new ArrayList<>();
		Document document1 = new Document();
		document1.setDocumentId(1);
		document1.setDocumentName("adhar");
		document1.setTanNo("342323");

		List<Document> docList2 = new ArrayList<>();
		Document document2 = new Document();
		document2.setDocumentId(2);
		document2.setDocumentName("tan");
		document2.setTanNo("234345");
		
		docList1.add(document1);
		docList2.add(document2);

		ResponseEntity<List<Document>> response = documentController.getAllDocument();

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(response.getBody());
		assertEquals(0, response.getBody().get(0).getDocumentId());
		assertEquals("Duplicate Document", response.getBody().get(2).getDocumentName());
	}
	
	@Test
	void findDocumentByNameTest() {
	    
        Document document = new Document();
      
        document.setDocumentName("");        
        ResponseEntity<String> response = documentController.findDocumentByName("");
       
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Reliance", response.getBody());
    }	
}
