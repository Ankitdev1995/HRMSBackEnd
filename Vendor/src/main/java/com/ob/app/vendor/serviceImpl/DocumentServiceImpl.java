package com.ob.app.vendor.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ob.app.vendor.entity.Document;
import com.ob.app.vendor.exception.DocumentNotFoundException;
import com.ob.app.vendor.repository.DocumentRepository;
import com.ob.app.vendor.service.DocumentService;

@Service
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	private DocumentRepository documentRepository;

	@Override
	public Document saveDocument(Document document) {
		Document savedDocument = documentRepository.save(document);
		return savedDocument;
	}

	@Override
	public String deleteDocument(int documentId) {
		documentRepository.deleteById(documentId);
		return "document is deleted with id :"+ documentId;
	}

	@Override
	public List<Document> getAllDocument() {
		List<Document> listdoc = documentRepository.findAll();
		return listdoc;
	}

	@Override
	public Optional<Document> getDocumentByName(String documentName) {
		return documentRepository.findBydocumentName(documentName);
	}

	@Override
	public Optional<Document> getDocumentByNo(String tanNo) {
		return documentRepository.findBytanNo(tanNo);
	}

	@Override
	public Document updateDocument(int documentId, Document document) {
		Optional<Document> existDocument = documentRepository.findById(documentId);
		if(existDocument.isPresent()) {
			
			Document updatedDoc =  existDocument.get();
			
			updatedDoc.setDocumentName(document.getDocumentName());
			updatedDoc.setTanNo(document.getTanNo());
		return documentRepository.save(updatedDoc);
		}else {
		 throw new DocumentNotFoundException("document not found with id: " + documentId) ;
		}
	}
}
