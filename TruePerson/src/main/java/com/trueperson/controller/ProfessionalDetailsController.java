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

import com.trueperson.model.ProfessionalDetails;
import com.trueperson.service.ProfessionalDetailsService;


@RestController
public class ProfessionalDetailsController {

	@Autowired
	ProfessionalDetailsService pservice;
	
	@GetMapping("/listprofession")
	public List<ProfessionalDetails> getAllProfession()
	{
		return pservice.getAllProfessions();
	}
	
	@PostMapping("/saveprofession")
	public ResponseEntity<ProfessionalDetails> saveProfession(@RequestBody ProfessionalDetails professiondetails){
		  return new ResponseEntity<ProfessionalDetails>(pservice.save(professiondetails), HttpStatus.CREATED);
		}

	@GetMapping("/{professionid}")
	public ResponseEntity<ProfessionalDetails> getProfessionById(@PathVariable("professionid") UUID professionid){
		   return new ResponseEntity<ProfessionalDetails>(pservice.getProfessionById(professionid), HttpStatus.OK);
		}
	
	@PutMapping("/updateprofession/{professionid}")
	public ResponseEntity<ProfessionalDetails> updateProfession(@PathVariable("professionid") UUID professionid
		    ,@RequestBody ProfessionalDetails professiondetails){
		  return new ResponseEntity<ProfessionalDetails>(pservice.update(professiondetails, professionid), HttpStatus.OK);
		    }
	
	@DeleteMapping("/profession/{professionid}")
	public ResponseEntity<String> deleteProfession(@PathVariable("professionid") UUID professionid){
		pservice.delete(professionid);
		return new ResponseEntity<String>("ProfessionalDetails Deleted Successfully!", HttpStatus.OK);
	}
}
