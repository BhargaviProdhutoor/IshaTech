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
@Table(name="true_contacts")
public class TrueContacts {

	@Id
	@GeneratedValue
	private UUID id;
	@Column(name="user_id")
	private UUID userId;
	@Column(name="followed_user_id")
	private UUID followedUserId;
	@Column(name="mobile_number")
	private Integer mobileNumber;
	@Column(name="status_id")
	private UUID statusId;
	@Column(name="contact_name")
	private String contactName;
	@Column(name="post_comment_id")
	private UUID postCommentId;
	@Column(name="start_time")
	private Date startTime;
	@Column(name="end_time")
	private Date endTime;
	@Column(name="created_dt")
	private Date createdDate;
	@Column(name="updated_dt")
	private Date updatedDate;
	@Column(name="created_by")
	private String createdBy;
	@Column(name="updated_by")
	private String updatedBy;
	
	
}
