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

import com.trueperson.model.TrueContactsStatus;
import com.trueperson.service.TrueContactsStatusService;

@RestController
public class TrueContactsStatusController {

	
	@Autowired
	TrueContactsStatusService tcsServ;
	
	@GetMapping("/listtruecontactsstatus")
	private List<TrueContactsStatus> getAllTrueContactsStatus()
	{
		return tcsServ.getAllTrueContactsStatus();
	}
	
	@PostMapping("/savetruecontactsstatus")
	public ResponseEntity<TrueContactsStatus> saveTrueContactsStatus(@RequestBody TrueContactsStatus trueContactsStatus)
	{
		return new ResponseEntity<TrueContactsStatus>(tcsServ.saveTrueContactsStatus(trueContactsStatus),
		   HttpStatus.CREATED);
		}
	
	@GetMapping("/truecontactsstatus/{tcsid}")
	public ResponseEntity<TrueContactsStatus> getTrueContactsStatusById(@PathVariable("tcsid") UUID tcsid){
		   
	return new ResponseEntity<TrueContactsStatus>(tcsServ.getTrueContactsStatusById(tcsid), HttpStatus.OK);
		}
	
	@PutMapping("/truecontactsstatus/{tcsid}")
	public ResponseEntity<TrueContactsStatus> updateTrueContactsStatus(@PathVariable("tcsid") UUID tcsid,
			@RequestBody TrueContactsStatus trueContactsStatus){
       return new ResponseEntity<TrueContactsStatus>(tcsServ.updateTrueContactsStatus(trueContactsStatus, tcsid), HttpStatus.OK);
    }
	
	@DeleteMapping("/truecontactsstatus/{tcsid}")
	 public ResponseEntity<String> deleteTrueContactsStatus(@PathVariable("tcsid") UUID tcsid){
		
		tcsServ.deleteTrueContactsStatuss(tcsid);
		
		return new ResponseEntity<String>("TrueContactsStatus Deleted Successfully!", HttpStatus.OK);
	}
}
