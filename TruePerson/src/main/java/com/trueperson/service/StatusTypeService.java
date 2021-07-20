package com.trueperson.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trueperson.exception.ResourceNotFoundException;
import com.trueperson.model.StatusType;
import com.trueperson.repository.StatusTypeRepository;

@Service
public class StatusTypeService {

	@Autowired
	StatusTypeRepository stRepo;
	
	public List<StatusType> getAllStatusType() {

		return stRepo.findAll();
	}

	public StatusType saveStatusType(StatusType statusType) {
		
		return stRepo.save(statusType);
	}

	public StatusType getStatusTypeById(UUID stid) {
		
		return stRepo.findById(stid).orElseThrow(() ->
		new ResourceNotFoundException("StatusType", "Id", stid));
	}

	public StatusType updateStatusType(StatusType statusType, UUID stid) {
		
		StatusType existingSt = stRepo.findById(stid).orElseThrow(() -> 
		new ResourceNotFoundException("StatusType", "Id", stid)); 
		
		existingSt.setCreatedBy(statusType.getCreatedBy());
		existingSt.setCreatedDate(statusType.getCreatedDate());
		existingSt.setStatusTypeCd(statusType.getStatusTypeCd());
		existingSt.setStatusType(statusType.getStatusType());
		existingSt.setStartTime(statusType.getStartTime());
		existingSt.setEndTime(statusType.getEndTime());
		existingSt.setUpdatedBy(statusType.getUpdatedBy());
		existingSt.setUpdatedDate(statusType.getUpdatedDate());
		
		stRepo.save(existingSt);
		return existingSt;
		
	}

	public void deleteStatusType(UUID stid) {
		
		stRepo.findById(stid).orElseThrow(() ->
		new ResourceNotFoundException("StatusType", "Id", stid));
		
		stRepo.deleteById(stid);
	
	}

}
