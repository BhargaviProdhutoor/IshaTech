package com.trueperson.model;

import java.math.BigInteger;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="user_professional_details")
@NoArgsConstructor
@AllArgsConstructor
public class ProfessionalDetails {
@Id
@GeneratedValue
private @Getter @Setter UUID professionid;
private @Getter @Setter String about_you;
private @Getter @Setter String head_line;
private @Getter @Setter String experience;
private @Getter @Setter BigInteger alternative_mobileno;
private @Getter @Setter String who_are_you;
private @Getter @Setter String created_date;
private @Getter @Setter String updated_date;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
@JoinColumn
private @Getter @Setter User users;

}
