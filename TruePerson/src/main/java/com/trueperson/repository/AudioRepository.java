package com.trueperson.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trueperson.model.Audio;

public interface AudioRepository extends JpaRepository<Audio, UUID>{

}
