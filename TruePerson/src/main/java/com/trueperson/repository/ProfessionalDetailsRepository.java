package com.trueperson.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trueperson.model.ProfessionalDetails;

@Repository
public interface ProfessionalDetailsRepository extends JpaRepository<ProfessionalDetails, UUID> {

}
