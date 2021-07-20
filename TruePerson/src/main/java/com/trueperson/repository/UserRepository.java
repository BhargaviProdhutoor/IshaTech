package com.trueperson.repository;



import java.math.BigInteger;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trueperson.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,UUID>{

	
	Optional<User> findByMobilenumber(BigInteger mobilenumber);
}
