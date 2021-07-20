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

import com.trueperson.model.Status;
import com.trueperson.service.StatusService;

@RestController
public class StatusController {

	@Autowired
	StatusService sServ;
	
	@GetMapping("/liststatus")
	private List<Status> getAllStatus()
	{
		return sServ.getAllStatus();
	}
	
	@PostMapping("/savestatus")
	public ResponseEntity<Status> saveStatus(@RequestBody Status status)
	{
		return new ResponseEntity<Status>(sServ.saveStatus(status),
		   HttpStatus.CREATED);
		}
	
	@GetMapping("/status/{sid}")
	public ResponseEntity<Status> getStatusById(@PathVariable("sid") UUID sid){
		   
	return new ResponseEntity<Status>(sServ.getStatusById(sid), HttpStatus.OK);
		}
	
	@PutMapping("/status/{sid}")
	public ResponseEntity<Status> updateStatus(@PathVariable("sid") UUID sid,
			@RequestBody Status status){
       return new ResponseEntity<Status>(sServ.updateStatus(status,sid), HttpStatus.OK);
    }
	
	@DeleteMapping("/status/{sid}")
	 public ResponseEntity<String> deleteStatus(@PathVariable("sid") UUID sid){
		
		sServ.deleteStatus(sid);
		
		return new ResponseEntity<String>("Status Deleted Successfully!", HttpStatus.OK);
	}
}
