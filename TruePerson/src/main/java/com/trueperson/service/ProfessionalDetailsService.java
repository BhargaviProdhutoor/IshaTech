package com.trueperson.service;


import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trueperson.exception.ResourceNotFoundException;
import com.trueperson.model.ProfessionalDetails;

import com.trueperson.repository.ProfessionalDetailsRepository;


@Service
public class ProfessionalDetailsService {
	@Autowired
	ProfessionalDetailsRepository prepo;
	
	public List<ProfessionalDetails> getAllProfessions()
	{
		return prepo.findAll();
	}
	
	public ProfessionalDetails save(ProfessionalDetails professionaldetails)
	{
		return prepo.save(professionaldetails);
	}
	
	public ProfessionalDetails getProfessionById(UUID professionid)
	{
		return prepo.findById(professionid).orElseThrow(() -> 
		new ResourceNotFoundException("ProfessionalDetails", "Id", professionid));
	}
	
	public ProfessionalDetails update(ProfessionalDetails professionaldetails,UUID professionid)
	{
		ProfessionalDetails existingProfession = prepo.findById(professionid).orElseThrow(
				() -> new ResourceNotFoundException("ProfessionalDetails", "Id", professionid)); 
		
		existingProfession.setAbout_you(professionaldetails.getAbout_you());
		existingProfession.setHead_line(professionaldetails.getHead_line());
		existingProfession.setExperience(professionaldetails.getExperience());
		existingProfession.setWho_are_you(professionaldetails.getWho_are_you());
        existingProfession.setAlternative_mobileno(professionaldetails.getAlternative_mobileno());
		existingProfession.setCreated_date(professionaldetails.getCreated_date());
		existingProfession.setUpdated_date(professionaldetails.getUpdated_date());
		existingProfession.setUsers(professionaldetails.getUsers());

		prepo.save(existingProfession);
		return existingProfession;
	}
	
	public void delete(UUID professionid)
	{	
		prepo.findById(professionid).orElseThrow(() -> 
		new ResourceNotFoundException("ProfessionalDetails", "Id", professionid));
		
		prepo.deleteById(professionid);
	}
	
}
