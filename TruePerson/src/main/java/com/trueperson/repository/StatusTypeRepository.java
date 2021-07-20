package com.trueperson.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trueperson.model.StatusType;

public interface StatusTypeRepository extends JpaRepository<StatusType, UUID>{

}
