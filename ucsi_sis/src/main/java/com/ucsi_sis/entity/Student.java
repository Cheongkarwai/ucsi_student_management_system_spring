package com.ucsi_sis.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.NaturalId;

@Entity
public class Student {

	@Id
	private String id;

	private String firstName;

	private String lastName;
	
	@Column(nullable = false)
	private LocalDate dateOfBirth;

	@NaturalId
	@Column(nullable = false)
	private String nric;

	@Column(nullable = false)
	private int age;

	@Column(nullable = false)
	private String contact;

	@Column(nullable = false)
	private String emailAddress;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "account_id")
	private User user;

	private Address address;

	@ManyToOne
	private Programme programme;

//	@JoinTable(
//			name="Student_Course",
//			joinColumns = @JoinColumn(
//					name="student_id",
//					referencedColumnName = "id"),
//			inverseJoinColumns = @JoinColumn(
//					name="course_id",
//					referencedColumnName = "courseId"))	
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Student_Course> enrolledCourses = new ArrayList<>();

	public Student() {

	}
	
	public Student(String id,String firstName, String lastName,String nric,
			int age, String contact, String emailAddress, Address address) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nric = nric;
		this.age = age;
		this.contact= contact;
		this.emailAddress = emailAddress;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
	
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getNric() {
		return nric;
	}

	public void setNric(String nric) {
		this.nric = nric;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public Programme getProgramme() {
		return programme;
	}
	public void setProgramme(Programme programme) {
		this.programme = programme;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public void setEnrolledCourse(Course course) {
		
	}
	public List<Student_Course> getEnrolledCourses(){
		return this.enrolledCourses;
	}
}
