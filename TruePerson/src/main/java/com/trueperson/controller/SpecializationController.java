package com.trueperson.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.trueperson.model.Specialization;
import com.trueperson.service.SpecializationService;

@RestController
public class SpecializationController {

	@Autowired
	SpecializationService spServ;

	@GetMapping("/listspecialization")
	private List<Specialization> getAllSpecializations()
	{
		return spServ.getAllSpecializations();
	}
	
	@PostMapping("/savespecialization")
	public ResponseEntity<Specialization> saveSpecialization(@RequestBody Specialization specialization)
	{
		return new ResponseEntity<Specialization>(spServ.saveSpecialization(specialization),
		   HttpStatus.CREATED);
		}
	
	@GetMapping("/specialization/{spid}")
	public ResponseEntity<Specialization> getSpecializationById(@PathVariable("spid") UUID spid){
		   
	return new ResponseEntity<Specialization>(spServ.getSpecializationById(spid), HttpStatus.OK);
		}
	
	@PutMapping("/specialization/{spid}")
	public ResponseEntity<Specialization> updateSpecialization(@PathVariable("spid") UUID spid,
    @RequestBody Specialization specialization){
       return new ResponseEntity<Specialization>(spServ.updateSpecialization(specialization, spid), HttpStatus.OK);
    }
	
	@DeleteMapping("/specialization/{spid}")
	 public ResponseEntity<String> deleteSpecialization(@PathVariable("spid") UUID spid){
		spServ.deleteSpecialization(spid);
		
		return new ResponseEntity<String>("Specialization Deleted Successfully!", HttpStatus.OK);
	}
	
}
