package com.trueperson.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trueperson.exception.ResourceNotFoundException;

import com.trueperson.model.UserTags;
import com.trueperson.repository.UserTagsRepository;

@Service
public class UserTagsService {

	@Autowired
	UserTagsRepository utRepo;
	
	public List<UserTags> getAllUserTags() {
		
		return utRepo.findAll();
	}

	public UserTags saveUserTags(UserTags userTags) {
		
		return utRepo.save(userTags);
	}

	public UserTags getUserTagsById(UUID utid) {
		
		return utRepo.findById(utid).orElseThrow(() ->
		new ResourceNotFoundException("UserTags", "Id", utid));
	}

	public UserTags updateUserTags(UserTags userTags, UUID utid) {
		
		UserTags existingUt = utRepo.findById(utid).orElseThrow(() -> 
		new ResourceNotFoundException("UserTags", "Id", utid)); 
		
		existingUt.setCreatedBy(userTags.getCreatedBy());
		existingUt.setCreatedDate(userTags.getCreatedDate());
		existingUt.setTag(userTags.getTag());
		existingUt.setUpdatedBy(userTags.getUpdatedBy());
		existingUt.setUpdatedDate(userTags.getUpdatedDate());
		existingUt.setUser_id(userTags.getUser_id());

		utRepo.save(existingUt);
		return existingUt;
	}

	public void deleteUserTags(UUID utid) {
		
		utRepo.findById(utid).orElseThrow(() ->
		new ResourceNotFoundException("UserTags", "Id", utid));
		
		 utRepo.deleteById(utid);
		
	}

	
}
