package com.trueperson.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="user_specialization")
public class UserSpecialization {

	
	@Id
	@GeneratedValue
	private UUID id;
	@Column(name="specialization")
	private String specialization;
	private UUID user_id;
	@Column(name="created_dt")
	private Date createdDate;
	@Column(name="updated_dt")
	private Date updatedDate;
	@Column(name="created_by")
	private String createdBy;
	@Column(name="updated_by")
	private String updatedBy;
	
	
}
