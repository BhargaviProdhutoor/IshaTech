package com.trueperson.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trueperson.model.Specialization;

public interface SpecializationRepository extends JpaRepository<Specialization, UUID>{

}
