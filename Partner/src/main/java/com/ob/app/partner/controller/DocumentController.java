package com.ob.app.partner.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ob.app.partner.entity.Document;
import com.ob.app.partner.service.DocumentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/partner")
public class DocumentController {

	@Autowired
	private DocumentService documentService;

	@PostMapping("/doc")
	public ResponseEntity<String> saveDocuments(@Valid @RequestBody Document document){
		Document SavedDocuments = documentService.saveDocument(document);
		if(SavedDocuments!=null) {
			return new ResponseEntity<String>("document is saved", HttpStatus.CREATED);
		}else {
			return new ResponseEntity<String>("please enter details", HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/del/{documentId}")
	public ResponseEntity<String> deleteDocument(@PathVariable int documentId){
		String deleteDocument = documentService.deleteDocument(documentId);	
		return new ResponseEntity<String>(deleteDocument,HttpStatus.OK);
	}

	@GetMapping("/getAllDoc")
	public ResponseEntity<List<Document>> getAllDocument(){
		List<Document> getAll =	documentService.getAllDocument();
		return new ResponseEntity<List<Document>>(getAll,HttpStatus.OK);
	}


	@GetMapping("/docname/{documentName}")
	public ResponseEntity<String> findDocumentByName(@PathVariable String documentName){
		Optional<Document> documentByName = documentService.getDocumentByName(documentName);
		if(documentByName.isPresent()) {
			return new ResponseEntity(documentByName, HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("document is not found with given name :"+ documentName,HttpStatus.NOT_FOUND);
		}
	}	


	@GetMapping("/docNo/{tanNo}")
	public ResponseEntity<String> findDocumentByNo(@PathVariable String tanNo){
		Optional<Document> documentByTanNo = documentService.getDocumentByNo(tanNo);
		if(documentByTanNo.isPresent()) {
			return new ResponseEntity(documentByTanNo, HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("document not found with tan number :"+ tanNo, HttpStatus.NOT_FOUND);	
		}
	}
	
	
		 @GetMapping("/sorted/{field}")
		    public ResponseEntity<List<Document>> findDocumentWithSorting(@RequestParam(required = false) String field) {
		        Sort sort = Sort.by(Direction.ASC, field); 
		        
		        List<Document> documents = documentService.findDocumentWithSorting(field);

		        return new ResponseEntity<>(documents, HttpStatus.OK);
		    	
		}
	}
	
	
