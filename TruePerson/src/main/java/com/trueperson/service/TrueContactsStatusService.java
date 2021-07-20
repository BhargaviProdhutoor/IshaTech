package com.trueperson.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trueperson.exception.ResourceNotFoundException;
import com.trueperson.model.TrueContactsStatus;
import com.trueperson.repository.TrueContactsStatusRepository;

@Service
public class TrueContactsStatusService {

	@Autowired
	TrueContactsStatusRepository tcsRepo;
	
	public List<TrueContactsStatus> getAllTrueContactsStatus() {
		
		return tcsRepo.findAll();
	}

	public TrueContactsStatus saveTrueContactsStatus(TrueContactsStatus trueContactsStatus) {
		
		return tcsRepo.save(trueContactsStatus);
	}

	public TrueContactsStatus getTrueContactsStatusById(UUID tcsid) {
		
		return tcsRepo.findById(tcsid).orElseThrow(() ->
		new ResourceNotFoundException("TrueContactsStatus", "Id", tcsid));
	}

	public TrueContactsStatus updateTrueContactsStatus(TrueContactsStatus trueContactsStatus, UUID tcsid) {
		
		TrueContactsStatus existingtcs = tcsRepo.findById(tcsid).orElseThrow(() -> 
		new ResourceNotFoundException("TrueContactsStatus", "Id", tcsid)); 
		
		existingtcs.setCreatedBy(trueContactsStatus.getCreatedBy());
		existingtcs.setCreatedDate(trueContactsStatus.getCreatedDate());
		existingtcs.setStatus(trueContactsStatus.getStatus());
		existingtcs.setStatusCd(trueContactsStatus.getStatusCd());
		existingtcs.setStartTime(trueContactsStatus.getStartTime());
		existingtcs.setEndTime(trueContactsStatus.getEndTime());
		existingtcs.setUpdatedBy(trueContactsStatus.getUpdatedBy());
		existingtcs.setUpdatedDate(trueContactsStatus.getUpdatedDate());
		
		tcsRepo.save(existingtcs);
		return existingtcs;
	}

	public void deleteTrueContactsStatuss(UUID tcsid) {
		
		tcsRepo.findById(tcsid).orElseThrow(() ->
		new ResourceNotFoundException("TrueContactsStatus", "Id", tcsid));
		
		tcsRepo.deleteById(tcsid);
		
	}

}
