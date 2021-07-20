package com.trueperson.controller;


import java.util.List;
import java.util.Optional;
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

import com.trueperson.exception.BadRequestException;
import com.trueperson.model.User;
import com.trueperson.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userservice;
	
	@GetMapping("/list")
	public List<User> getAllUsers()
	{
		return userservice.getAllUsers();
	}
	
	@PostMapping("/saveuser")
	public  ResponseEntity<User> saveUser(@RequestBody User user){
	
		Optional<User> u=userservice.findByMobilenumber(user.getMobilenumber());
		if(u.isPresent()){
		   throw new BadRequestException(user.getMobilenumber()+ "user already exists");
		}
		else {
	  return new ResponseEntity<User>(userservice.saveUser(user), HttpStatus.CREATED);
		}
	}
	
	@GetMapping("user/{userid}")
	public ResponseEntity<User> getUserById(@PathVariable("userid") UUID userid){
	   return new ResponseEntity<User>(userservice.getUserById(userid), HttpStatus.OK);
	}
	
	@PutMapping("user/{userid}")
	public ResponseEntity<User> updateUser(@PathVariable("userid") UUID userid
    ,@RequestBody User user){
       return new ResponseEntity<User>(userservice.updateUser(user, userid), HttpStatus.OK);
    }
	
	@DeleteMapping("/{userid}")
    public ResponseEntity<String> deleteUser(@PathVariable("userid") UUID userid){
		userservice.deleteUser(userid);
		return new ResponseEntity<String>("User Deleted Successfully!", HttpStatus.OK);
	}
	
}
	