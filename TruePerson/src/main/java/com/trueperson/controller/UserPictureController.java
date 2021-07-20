
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


import com.trueperson.model.UserPicture;
import com.trueperson.service.UserPictureService;

@RestController
public class UserPictureController {

	@Autowired
	private UserPictureService upService; 
	
	@GetMapping("/listpicture")
	private List<UserPicture> getAllPictures()
	{
		return upService.getAllPictures();
	}
	
	@PostMapping("/savepicture")
	public ResponseEntity<UserPicture> savePicture(@RequestBody UserPicture userPicture)
	{
   return new ResponseEntity<UserPicture>(upService.savePicture(userPicture),
		   HttpStatus.CREATED);
		}
	
	@GetMapping("/picture/{piccid}")
	public ResponseEntity<UserPicture> getPictureById(@PathVariable("piccid") UUID piccid){
		   
	return new ResponseEntity<UserPicture>(upService.getPictureById(piccid), HttpStatus.OK);
		}
	
	@PutMapping("/{piccid}")
	public ResponseEntity<UserPicture> updatePictue(@PathVariable("piccid") UUID piccid,
    @RequestBody UserPicture userPicture){
       return new ResponseEntity<UserPicture>(upService.updatePictue(userPicture, piccid), HttpStatus.OK);
    }
	
	@DeleteMapping("/picture/{piccid}")
	 public ResponseEntity<String> deletePicture(@PathVariable("piccid") UUID piccid){
		upService.deletePicture(piccid);
		return new ResponseEntity<String>("Picture Deleted Successfully!", HttpStatus.OK);
	}
}
