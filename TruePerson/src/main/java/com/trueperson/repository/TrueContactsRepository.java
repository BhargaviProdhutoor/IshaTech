package com.trueperson.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trueperson.model.TrueContacts;

public interface TrueContactsRepository extends JpaRepository<TrueContacts, UUID>{

}
