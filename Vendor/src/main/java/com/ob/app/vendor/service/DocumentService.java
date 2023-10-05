package com.ob.app.vendor.service;

import java.util.List;
import java.util.Optional;

import com.ob.app.vendor.entity.Document;

public interface DocumentService {
	
	public Document saveDocument (Document document);
 
	public String deleteDocument (int documentId);
	
	public List<Document> getAllDocument();
	
	public Optional<Document> getDocumentByName(String documentName);
	
	public Optional<Document> getDocumentByNo (String tanNo);
	
	public Document updateDocument(int documentId , Document document);
	
	

}
