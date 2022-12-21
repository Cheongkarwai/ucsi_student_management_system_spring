package com.ucsi.dto;

import java.util.ArrayList;
import java.util.List;

import com.ucsi_sis.entity.Address;
import com.ucsi_sis.entity.Programme;
import com.ucsi_sis.entity.Student_Course;
import com.ucsi_sis.entity.User;


public class StudentDto {
	
	private String id;

	public StudentDto(String id, String firstName, String lastName, String nric, int age, String contact,
			String emailAddress, User user, Address address, ProgrammeDto programme) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nric = nric;
		this.age = age;
		this.contact = contact;
		this.emailAddress = emailAddress;
		this.user = user;
		this.address = address;
		this.programme = programme;
		this.enrolledCourses = enrolledCourses;
	}
	private String firstName;

	private String lastName;

	private String nric;

	private int age;

	private String contact;

	private String emailAddress;

	private User user;

	private Address address;

	private ProgrammeDto programme;

	private List<EnrolledCourseDto> enrolledCourses = new ArrayList<>();

	public StudentDto() {

	}
	
	public StudentDto(String id, String firstName, String lastName, String nric, int age, String contact,
			String emailAddress, User user, Address address, ProgrammeDto programme,
			List<EnrolledCourseDto> enrolledCourses) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nric = nric;
		this.age = age;
		this.contact = contact;
		this.emailAddress = emailAddress;
		this.user = user;
		this.address = address;
		this.programme = programme;
		this.enrolledCourses = enrolledCourses;
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
	public ProgrammeDto getProgramme() {
		return programme;
	}
	public void setProgramme(ProgrammeDto programme) {
		this.programme = programme;
	}
	
	public void addEnrolledCourse(EnrolledCourseDto course) {
		this.enrolledCourses.add(course);
	}
	public List<EnrolledCourseDto> getEnrolledCourses(){
		return this.enrolledCourses;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setEnrolledCourses(List<EnrolledCourseDto> enrolledCourses) {
		this.enrolledCourses = enrolledCourses;
	}

}
