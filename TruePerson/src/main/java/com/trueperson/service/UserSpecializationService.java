package com.trueperson.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trueperson.exception.ResourceNotFoundException;
import com.trueperson.model.UserSpecialization;
import com.trueperson.repository.UserSpecializationRepository;

@Service
public class UserSpecializationService {

	@Autowired
	UserSpecializationRepository uspRepo;
	
	public List<UserSpecialization> getAllUserSpecializations() {

		return uspRepo.findAll();
	}

	public UserSpecialization saveUserSpecialization(UserSpecialization userSpecialization) {
	
		return uspRepo.save(userSpecialization);
	}

	public UserSpecialization getUserSpecializationById(UUID uspid) {

		return uspRepo.findById(uspid).orElseThrow(() ->
		new ResourceNotFoundException("UserSpecialization", "Id", uspid));
		
	}

	public UserSpecialization updateUserSpecialization(UserSpecialization userSpecialization, UUID uspid) {
		
		UserSpecialization existingUsp = uspRepo.findById(uspid).orElseThrow(
				() -> new ResourceNotFoundException("UserSpecialization", "Id", uspid)); 
		
		existingUsp.setCreatedBy(userSpecialization.getCreatedBy());
		existingUsp.setCreatedDate(userSpecialization.getCreatedDate());
		existingUsp.setSpecialization(userSpecialization.getSpecialization());
		existingUsp.setUpdatedBy(userSpecialization.getUpdatedBy());
		existingUsp.setUpdatedDate(userSpecialization.getUpdatedDate());
		existingUsp.setUser_id(userSpecialization.getUser_id());

		uspRepo.save(existingUsp);
		return existingUsp;
	}

	
	public void deleteUserSpecialization(UUID uspid) {
		
		uspRepo.findById(uspid).orElseThrow(() ->
		new ResourceNotFoundException("UserSpecialization", "Id", uspid));
		
		 uspRepo.deleteById(uspid);
	}

}
