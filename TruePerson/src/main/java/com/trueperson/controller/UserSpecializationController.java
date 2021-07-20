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

import com.trueperson.model.UserSpecialization;
import com.trueperson.service.UserSpecializationService;

@RestController
public class UserSpecializationController {

	@Autowired
	UserSpecializationService uspSev;
	
	@GetMapping("/listuserspecialization")
	private List<UserSpecialization> getAllUserSpecializations()
	{
		return uspSev.getAllUserSpecializations();
	}
	
	@PostMapping("/saveuserspecialization")
	public ResponseEntity<UserSpecialization> saveUserSpecialization(@RequestBody UserSpecialization userSpecialization)
	{
		return new ResponseEntity<UserSpecialization>(uspSev.saveUserSpecialization(userSpecialization),
		   HttpStatus.CREATED);
		}
	
	@GetMapping("/userspecialization/{uspid}")
	public ResponseEntity<UserSpecialization> getUserSpecializationById(@PathVariable("uspid") UUID uspid){
		   
	return new ResponseEntity<UserSpecialization>(uspSev.getUserSpecializationById(uspid), HttpStatus.OK);
		}
	
	@PutMapping("/userspecialization/{uspid}")
	public ResponseEntity<UserSpecialization> updateUserSpecialization(@PathVariable("uspid") UUID uspid,
    @RequestBody UserSpecialization userSpecialization){
       return new ResponseEntity<UserSpecialization>(uspSev.updateUserSpecialization(userSpecialization, uspid), HttpStatus.OK);
    }
	
	@DeleteMapping("/userspecialization/{uspid}")
	 public ResponseEntity<String> deleteUserSpecialization(@PathVariable("uspid") UUID uspid){
		uspSev.deleteUserSpecialization(uspid);
		
		return new ResponseEntity<String>("UserSpecialization Deleted Successfully!", HttpStatus.OK);
	}
}
