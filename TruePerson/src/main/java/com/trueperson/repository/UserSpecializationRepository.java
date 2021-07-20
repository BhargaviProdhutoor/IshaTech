package com.trueperson.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trueperson.model.UserSpecialization;

public interface UserSpecializationRepository extends JpaRepository<UserSpecialization, UUID>{

}
