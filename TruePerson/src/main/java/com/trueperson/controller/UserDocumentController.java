package com.trueperson.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.trueperson.model.UserDocument;
import com.trueperson.service.UserDocumentService;

@RestController
public class UserDocumentController {

	@Autowired
	UserDocumentService docservice;
	
	@GetMapping("/listdoc")
	private List<UserDocument> getAllDocuments()
	{
		return docservice.getAllDocuments();
	}
	
	@PostMapping("/savedoc")
	public ResponseEntity<UserDocument> saveDocument(@RequestBody UserDocument userdocument)
	{
   return new ResponseEntity<UserDocument>(docservice.saveDocument(userdocument),
		   HttpStatus.CREATED);
		}
	
	@GetMapping("/document/{docid}")
	public ResponseEntity<UserDocument> getDocumentById(@PathVariable("docid") UUID docid){
		   
	return new ResponseEntity<UserDocument>(docservice.getDocumentById(docid), HttpStatus.OK);
		}
	
	@PutMapping("/{docid}")
	public ResponseEntity<UserDocument> updateDocument(@PathVariable("docid") UUID docid,
    @RequestBody UserDocument userdocument){
       return new ResponseEntity<UserDocument>(docservice.updateDocument(userdocument, docid), HttpStatus.OK);
    }
	
	@DeleteMapping("/document/{docid}")
	 public ResponseEntity<String> deleteDocument(@PathVariable("docid") UUID docid){
		docservice.deleteDocument(docid);
		return new ResponseEntity<String>("DocumentDetails Deleted Successfully!", HttpStatus.OK);
	}
}
