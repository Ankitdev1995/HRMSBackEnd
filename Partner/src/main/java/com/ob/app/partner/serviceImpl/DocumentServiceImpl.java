package com.ob.app.partner.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ob.app.partner.entity.Document;
import com.ob.app.partner.repository.DocumentRepository;
import com.ob.app.partner.service.DocumentService;

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
	public List<Document> findDocumentWithSorting(String field) {
		return documentRepository.findAll(Sort.by(Direction.ASC));
	}
}
