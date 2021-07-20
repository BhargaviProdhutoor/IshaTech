package com.trueperson.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trueperson.model.TrueContactsStatus;

public interface TrueContactsStatusRepository extends JpaRepository<TrueContactsStatus, UUID> {

}
