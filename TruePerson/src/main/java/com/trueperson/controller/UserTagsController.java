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

import com.trueperson.model.UserTags;
import com.trueperson.service.UserTagsService;

@RestController
public class UserTagsController {

	@Autowired
	UserTagsService utServ;
	
	@GetMapping("/listusertags")
	private List<UserTags> getAllUserTags()
	{
		return utServ.getAllUserTags();
	}
	
	@PostMapping("/saveusertag")
	public ResponseEntity<UserTags> saveUserTags(@RequestBody UserTags userTags)
	{
		return new ResponseEntity<UserTags>(utServ.saveUserTags(userTags),
		   HttpStatus.CREATED);
		}
	
	@GetMapping("/usertag/{utid}")
	public ResponseEntity<UserTags> getUserTagsById(@PathVariable("utid") UUID utid){
		   
	return new ResponseEntity<UserTags>(utServ.getUserTagsById(utid), HttpStatus.OK);
		}
	
	@PutMapping("/usertag/{utid}")
	public ResponseEntity<UserTags> updateUserTags(@PathVariable("utid") UUID utid,
    @RequestBody UserTags userTags){
       return new ResponseEntity<UserTags>(utServ.updateUserTags(userTags, utid), HttpStatus.OK);
    }
	
	@DeleteMapping("/usertag/{utid}")
	 public ResponseEntity<String> deleteUserTags(@PathVariable("utid") UUID utid){
		utServ.deleteUserTags(utid);
		
		return new ResponseEntity<String>("UserTags Deleted Successfully!", HttpStatus.OK);
	}
}
