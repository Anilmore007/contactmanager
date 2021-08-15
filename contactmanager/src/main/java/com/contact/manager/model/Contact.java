package com.contact.manager.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
@Entity
@Table(name = "CONTACT")
public class Contact implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CONTACT_ID")
	private Long contactId;
	
	@Column(name = "FIRST_NAME")
	@NotBlank(message = "First Name Cannot be Blank")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	@NotBlank(message = "Last Name Cannot be Blank")
	private String lastName;
	
	@Column(name = "EMAIL")
	@NotBlank(message = "Email Cannot be Blank")
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$" , message = "Invalid Email")
	private String email;
	
	@Column(name = "PHONE_NUMBER")
	@NotNull
	//@Range(min = 10,max= 12, message = "Phone Number should be Between 10 to 12  Digits in length" )
	private Long phoneNumber;
	
	@Column(name = "STATUS")
	@NotBlank(message = "Status Cannot be Blank")
	private String status;

}
