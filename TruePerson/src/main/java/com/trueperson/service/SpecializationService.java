package com.trueperson.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.trueperson.exception.ResourceNotFoundException;
import com.trueperson.model.Specialization;
import com.trueperson.repository.SpecializationRepository;


@Service
public class SpecializationService {

	@Autowired
	SpecializationRepository spRepo;

	public List<Specialization> getAllSpecializations() {
		
		return spRepo.findAll();
	}

	public Specialization saveSpecialization(Specialization specialization) {
		
		return spRepo.save(specialization);
	}

	public Specialization getSpecializationById(UUID spid) {
		
		return spRepo.findById(spid).orElseThrow(() ->
		new ResourceNotFoundException("Specialization", "Id", spid));
	}

	public Specialization updateSpecialization(Specialization specialization, UUID spid) {

		
		Specialization existingSp = spRepo.findById(spid).orElseThrow(
				() -> new ResourceNotFoundException("Specialization", "Id", spid)); 
		
		existingSp.setCreatedBy(specialization.getCreatedBy());
		existingSp.setCreatedDate(specialization.getCreatedDate());
		existingSp.setSpecialization(specialization.getSpecialization());
		existingSp.setSpecialization_cd(specialization.getSpecialization_cd());
		existingSp.setLink(specialization.getLink());
		existingSp.setUpdatedBy(specialization.getUpdatedBy());
		existingSp.setUpdatedDate(specialization.getUpdatedDate());
		existingSp.setUser_id(specialization.getUser_id());

		spRepo.save(existingSp);
		return existingSp;

		
	}

	public void deleteSpecialization(UUID spid) {
		
		spRepo.findById(spid).orElseThrow(() ->
		new ResourceNotFoundException("Specialization", "Id", spid));
		
		 spRepo.deleteById(spid);
		
	}
	
	
}
