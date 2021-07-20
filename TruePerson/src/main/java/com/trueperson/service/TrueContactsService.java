package com.trueperson.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trueperson.exception.ResourceNotFoundException;
import com.trueperson.model.TrueContacts;
import com.trueperson.repository.TrueContactsRepository;

@Service
public class TrueContactsService {

	@Autowired
	TrueContactsRepository tcRepo;
	
	public List<TrueContacts> getAllTrueContacts() {
		
		return tcRepo.findAll();
	}

	public TrueContacts saveTrueContacts(TrueContacts trueContacts) {
		
		return tcRepo.save(trueContacts);
	}

	public TrueContacts getTrueContactsId(UUID tcid) {
		
		return tcRepo.findById(tcid).orElseThrow(() ->
		new ResourceNotFoundException("TrueContacts", "Id", tcid));
	}

	public TrueContacts updateTrueContacts(TrueContacts trueContacts, UUID tcid) {
		
		TrueContacts existingtc = tcRepo.findById(tcid).orElseThrow(() -> 
		new ResourceNotFoundException("TrueContacts", "Id", tcid)); 
		
		existingtc.setCreatedBy(trueContacts.getCreatedBy());
		existingtc.setCreatedDate(trueContacts.getCreatedDate());
		existingtc.setUserId(trueContacts.getUserId());
		existingtc.setFollowedUserId(trueContacts.getFollowedUserId());
		existingtc.setMobileNumber(trueContacts.getMobileNumber());
		existingtc.setStatusId(trueContacts.getStatusId());
		existingtc.setContactName(trueContacts.getContactName());
		existingtc.setPostCommentId(trueContacts.getPostCommentId());
		existingtc.setStartTime(trueContacts.getStartTime());
		existingtc.setEndTime(trueContacts.getEndTime());
		existingtc.setUpdatedBy(trueContacts.getUpdatedBy());
		existingtc.setUpdatedDate(trueContacts.getUpdatedDate());
		
		tcRepo.save(existingtc);
		return existingtc;
	}

	public void deleteTrueContacts(UUID tcid) {
		
		tcRepo.findById(tcid).orElseThrow(() ->
		new ResourceNotFoundException("TrueContactsStatus", "Id", tcid));
		
		tcRepo.deleteById(tcid);
		
	}

}
