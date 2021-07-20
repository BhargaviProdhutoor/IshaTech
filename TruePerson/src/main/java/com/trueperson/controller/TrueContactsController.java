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

import com.trueperson.model.TrueContacts;
import com.trueperson.service.TrueContactsService;

@RestController
public class TrueContactsController {

	@Autowired
	TrueContactsService tcServ;
	
	@GetMapping("/listtruecontacts")
	private List<TrueContacts> getAllTrueContacts()
	{
		return tcServ.getAllTrueContacts();
	}
	
	@PostMapping("/savetruecontacts")
	public ResponseEntity<TrueContacts> saveTrueContacts(@RequestBody TrueContacts trueContacts)
	{
		return new ResponseEntity<TrueContacts>(tcServ.saveTrueContacts(trueContacts),
		   HttpStatus.CREATED);
		}
	
	@GetMapping("/truecontacts/{tcid}")
	public ResponseEntity<TrueContacts> getTrueContactsById(@PathVariable("tcid") UUID tcid){
		   
	return new ResponseEntity<TrueContacts>(tcServ.getTrueContactsId(tcid), HttpStatus.OK);
		}
	
	@PutMapping("/truecontacts/{tcid}")
	public ResponseEntity<TrueContacts> updateTrueContacts(@PathVariable("tcid") UUID tcid,
			@RequestBody TrueContacts trueContacts){
       return new ResponseEntity<TrueContacts>(tcServ.updateTrueContacts(trueContacts, tcid), HttpStatus.OK);
    }
	
	@DeleteMapping("/truecontacts/{tcid}")
	 public ResponseEntity<String> deleteTrueContacts(@PathVariable("tcid") UUID tcid){
		
		tcServ.deleteTrueContacts(tcid);
		
		return new ResponseEntity<String>("TrueContacts Deleted Successfully!", HttpStatus.OK);
	}
	
}
