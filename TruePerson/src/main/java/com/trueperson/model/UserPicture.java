package com.trueperson.model;

import java.util.Date;
import java.util.UUID;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="pictures")
public class UserPicture {

	@Id
	@GeneratedValue
	private UUID id;
	@Column(name="title")
	private String fileName;
	@Column(name="description")
	private String description;
	@Column(name="link")
	private String link;
	@Column(name="created_dt")
	private Date createdDate;
	@Column(name="updated_dt")
	private Date updatedDate;
	@Column(name="created_by")
	private String createdBy;
	@Column(name="updated_by")
	private String updatedBy;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private UUID user_id;
}
