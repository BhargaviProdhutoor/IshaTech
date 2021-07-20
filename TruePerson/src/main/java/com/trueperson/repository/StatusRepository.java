package com.trueperson.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trueperson.model.Status;

public interface StatusRepository extends JpaRepository<Status, UUID>{

}
