package com.trueperson.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trueperson.exception.ResourceNotFoundException;
import com.trueperson.model.UserPicture;
import com.trueperson.repository.UserPictureRepository;

@Service
public class UserPictureService {

	@Autowired
	UserPictureRepository upRepo;
	
	public List<UserPicture> getAllPictures() {
		
		return upRepo.findAll();
	}

	public UserPicture savePicture(UserPicture userPicture) {
		
		return upRepo.save(userPicture);
	}

	public UserPicture getPictureById(UUID piccid) {
		
		return upRepo.findById(piccid).orElseThrow(() -> 
		new ResourceNotFoundException("UserPicture", "Id", piccid));
	}

	public UserPicture updatePictue(UserPicture userPicture, UUID piccid) {
		
		UserPicture existingPic = upRepo.findById(piccid).orElseThrow(
				() -> new ResourceNotFoundException("UserPicture", "Id", piccid)); 
		
		existingPic.setCreatedBy(userPicture.getCreatedBy());
		existingPic.setCreatedDate(userPicture.getCreatedDate());
		existingPic.setFileName(userPicture.getFileName());
		existingPic.setDescription(userPicture.getDescription());
		existingPic.setLink(userPicture.getLink());
		existingPic.setUpdatedBy(userPicture.getUpdatedBy());
		existingPic.setUpdatedDate(userPicture.getUpdatedDate());
		existingPic.setUser_id(userPicture.getUser_id());

		upRepo.save(existingPic);
		return existingPic;

	}

	public void deletePicture(UUID piccid) {
		
		upRepo.findById(piccid).orElseThrow(() -> 
		new ResourceNotFoundException("UserPicture", "Id", piccid));
		
		upRepo.deleteById(piccid);
		
	}

	
}
