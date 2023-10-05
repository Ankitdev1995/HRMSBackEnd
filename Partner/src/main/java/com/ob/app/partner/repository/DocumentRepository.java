package com.ob.app.partner.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ob.app.partner.entity.Document;

public interface DocumentRepository extends JpaRepository<Document, Integer>{
	
	Optional<Document> findBydocumentName(String documentName);
	
	Optional<Document> findBytanNo(String tanNo);
	
	
	
}
