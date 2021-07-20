package com.trueperson.model;

import java.math.BigInteger;
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
import lombok.ToString;



@Entity
@Table(name="user_profile")

@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	@Column(name="userid")
	@GeneratedValue
private @Getter @Setter UUID userid;

private @Getter @Setter String first_name;
private @Getter @Setter String last_name;
private @Getter @Setter int age;
private @Getter @Setter String gender;
private @Getter @Setter String city;
@Column(name="mobile_number")
private @Getter @Setter BigInteger mobilenumber;
private @Getter @Setter String created_date;
private @Getter @Setter String updated_date;



}
