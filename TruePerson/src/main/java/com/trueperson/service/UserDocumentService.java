package com.trueperson.service;


import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trueperson.exception.ResourceNotFoundException;
import com.trueperson.model.UserDocument;
import com.trueperson.repository.UserDocumentRepository;


@Service
public class UserDocumentService {
	@Autowired
	UserDocumentRepository repo;
	
	public List<UserDocument> getAllDocuments()
	{
		return repo.findAll();
	}
	
	public UserDocument saveDocument(UserDocument userdoc)
	{
		return repo.save(userdoc);
	}
	
	public UserDocument getDocumentById(UUID docid)
	{
		
	return repo.findById(docid).orElseThrow(() -> 
	new ResourceNotFoundException("UserDocument", "Id", docid));
				
	}
	
	public UserDocument updateDocument(UserDocument userdoc,UUID docid)
	{
		UserDocument existingdoc = repo.findById(docid).orElseThrow(
		() -> new ResourceNotFoundException("UserDocument", "Id", docid)); 
		existingdoc.setFile_name(userdoc.getFile_name());
		existingdoc.setFile_type(userdoc.getFile_type());
		existingdoc.setFile_url(userdoc.getFile_url());
		existingdoc.setCreated_date(userdoc.getCreated_date());
		existingdoc.setUpdated_date(userdoc.getUpdated_date());
		existingdoc.setProfessionaldetails(userdoc.getProfessionaldetails());

	    repo.save(existingdoc);
	    return existingdoc;
	}
	
	public void deleteDocument(UUID docid)
	{
		repo.findById(docid).orElseThrow(() -> 
		new ResourceNotFoundException("UserDocument", "Id", docid));
		
		repo.deleteById(docid);
	}
	
}
