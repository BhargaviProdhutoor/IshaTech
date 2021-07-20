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

import com.trueperson.model.StatusType;
import com.trueperson.service.StatusTypeService;

@RestController
public class StatusTypeController {

	@Autowired
	StatusTypeService stServ;
	
	@GetMapping("/liststatustype")
	private List<StatusType> getAllStatusType()
	{
		return stServ.getAllStatusType();
	}
	
	@PostMapping("/savestatustype")
	public ResponseEntity<StatusType> saveStatusType(@RequestBody StatusType statusType)
	{
		return new ResponseEntity<StatusType>(stServ.saveStatusType(statusType),
		   HttpStatus.CREATED);
		}
	
	@GetMapping("/statustype/{stid}")
	public ResponseEntity<StatusType> getStatusTypeById(@PathVariable("stid") UUID stid){
		   
	return new ResponseEntity<StatusType>(stServ.getStatusTypeById(stid), HttpStatus.OK);
		}
	
	@PutMapping("/statustype/{stid}")
	public ResponseEntity<StatusType> updateStatusType(@PathVariable("stid") UUID stid,
			@RequestBody StatusType statusType){
       return new ResponseEntity<StatusType>(stServ.updateStatusType(statusType, stid), HttpStatus.OK);
    }
	
	@DeleteMapping("/statustype/{stid}")
	 public ResponseEntity<String> deleteStatusType(@PathVariable("stid") UUID stid){
		
		stServ.deleteStatusType(stid);
		
		return new ResponseEntity<String>("StatusType Deleted Successfully!", HttpStatus.OK);
	}
	
}
