package com.trueperson.service;



import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.trueperson.exception.ResourceNotFoundException;
import com.trueperson.model.User;
import com.trueperson.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userrepo;
	
	public List<User> getAllUsers()
	{
	return userrepo.findAll();
	}
	
	public User saveUser(User user)
	{
		
	 return	userrepo.save(user);
	}
	
	public User getUserById(UUID userid)
	{
		
	return userrepo.findById(userid).orElseThrow(() -> 
						new ResourceNotFoundException("User", "Id", userid));
				
	}
	
	public User updateUser(User user,UUID userid)
	{
		User existingUser = userrepo.findById(userid).orElseThrow(
				() -> new ResourceNotFoundException("User", "Id", userid)); 
		
		existingUser.setFirst_name(user.getFirst_name());
		existingUser.setLast_name(user.getLast_name());
		existingUser.setAge(user.getAge());
		existingUser.setCity(user.getCity());
		existingUser.setGender(user.getGender());
		existingUser.setMobilenumber(user.getMobilenumber());
		existingUser.setCreated_date(user.getCreated_date());
		existingUser.setUpdated_date(user.getUpdated_date());
		
		userrepo.save(existingUser);
		return existingUser;
	}
	
	public void deleteUser(UUID userid)
	{
		userrepo.findById(userid).orElseThrow(() -> 
		new ResourceNotFoundException("User", "Id", userid));
		
		userrepo.deleteById(userid);
	}
	
	public Optional<User> findByMobilenumber(BigInteger mobilenumber){
	       return userrepo.findByMobilenumber(mobilenumber);
	    }

}

