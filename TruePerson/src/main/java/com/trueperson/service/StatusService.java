package com.trueperson.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trueperson.exception.ResourceNotFoundException;
import com.trueperson.model.Status;
import com.trueperson.repository.StatusRepository;

@Service
public class StatusService {

	@Autowired
	StatusRepository sRepo;
	
	public List<Status> getAllStatus() {
		
		return sRepo.findAll();
	}

	public Status saveStatus(Status status) {
		
		return sRepo.save(status);
	}

	public Status getStatusById(UUID sid) {
		
		return sRepo.findById(sid).orElseThrow(() ->
		new ResourceNotFoundException("Status", "Id", sid));
		
	}

	public Status updateStatus(Status status, UUID sid) {
		
		Status existingStatus = sRepo.findById(sid).orElseThrow(() -> 
		new ResourceNotFoundException("Status", "Id", sid)); 
		
		existingStatus.setCreatedBy(status.getCreatedBy());
		existingStatus.setCreatedDate(status.getCreatedDate());
		existingStatus.setStatus(status.getStatus());
		existingStatus.setStatusCd(status.getStatusCd());
		existingStatus.setStatusType(status.getStatusType());
		existingStatus.setStartTime(status.getStartTime());
		existingStatus.setEndTime(status.getEndTime());
		existingStatus.setUpdatedBy(status.getUpdatedBy());
		existingStatus.setUpdatedDate(status.getUpdatedDate());
		
		sRepo.save(existingStatus);
		return existingStatus;
		
	}

	public void deleteStatus(UUID sid) {
		
		sRepo.findById(sid).orElseThrow(() ->
			new ResourceNotFoundException("Status", "Id", sid));
			
		sRepo.deleteById(sid);
			
		
	}

}
