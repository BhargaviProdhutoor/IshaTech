package com.trueperson.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trueperson.model.UserDocument;

@Repository
public interface UserDocumentRepository extends JpaRepository<UserDocument, UUID> {

}
