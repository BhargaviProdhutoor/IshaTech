package com.trueperson.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trueperson.model.UserPicture;

public interface UserPictureRepository extends JpaRepository<UserPicture, UUID> {

}
