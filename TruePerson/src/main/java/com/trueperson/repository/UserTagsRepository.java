package com.trueperson.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trueperson.model.UserTags;

public interface UserTagsRepository extends JpaRepository<UserTags, UUID>{

}
