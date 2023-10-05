package com.ob.app.vendor.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Document {
	
	@Id
	private int documentId;
	
	@NotEmpty(message = "document name is required")
	@Column(name = "document_name")
	private String documentName;
	
	@NotEmpty(message = "tan number is required")
	@Column(name = "tan_number")
	private String tanNo;
	
	public Document() {
		
	}
	
	public Document(int documentId,String documentName,String tanNo) {
		super();
		this.documentId = documentId;
		this.documentName = documentName;
		this.tanNo = tanNo;
	}

	public int getDocumentId() {
		return documentId;
	}

	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public String getTanNo() {
		return tanNo;
	}

	public void setTanNo(String tanNo) {
		this.tanNo = tanNo;
	}

	@Override
	public String toString() {
		return "Document [documentId=" + documentId + ", documentName=" + documentName + ", tanNo=" + tanNo + "]";
	}
}
