package com.ucsi.dto;

import java.time.LocalDate;

public class StudentProfileDto {
	
	private String studentId;
	
	private String firstName;
	
	private LocalDate dateOfbirth;
	
	private String lastName;
	
	private int age;
	
	private String contactNumber;
	
	private String emailAddress;
	
	private String nric;
	
	private String programmeName;

	public StudentProfileDto(String studentId,String firstName, String lastName, int age, String contactNumber,
			String emailAddress,LocalDate dateOfBirth,String nric, String programmeName) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.contactNumber = contactNumber;
		this.emailAddress = emailAddress;
		this.dateOfbirth = dateOfBirth;
		this.nric = nric;
		this.programmeName = programmeName;
	}
	
	public StudentProfileDto() {
		
	}
	
	public void setStudentId(String id) {
		this.studentId = id;
	}
	public String getStudentId() {
		return studentId;
	}
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfbirth = dateOfBirth;
	}
	public LocalDate getDateOfBirth() {
		return dateOfbirth;
	}
	public void setNric(String nric) {
		this.nric = nric;
	}
	public String getNric() {
		return nric;
	}
	public void setProgrammeName(String programmeName) {
		this.programmeName = programmeName;
	}
	public String getProgrammeName() {
		return programmeName;
	}
}
