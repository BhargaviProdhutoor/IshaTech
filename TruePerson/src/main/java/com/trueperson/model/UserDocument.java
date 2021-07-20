package com.trueperson.model;


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

@Table(name="user_documents")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UserDocument {
@Id	
@GeneratedValue
private @Getter @Setter UUID docid;
private @Getter @Setter String file_name;
private @Getter @Setter String file_type;
private @Getter @Setter String file_url;
private @Getter @Setter String created_date;
private @Getter @Setter String updated_date;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
@JoinColumn
private @Getter @Setter ProfessionalDetails professionaldetails;
}
