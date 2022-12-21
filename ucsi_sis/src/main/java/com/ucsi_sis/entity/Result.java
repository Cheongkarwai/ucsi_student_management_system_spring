package com.ucsi_sis.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Formula;

@Entity
public class Result {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String subject;
	
	@Column(nullable=false)
	private double marks;
	
	@Column(nullable=false)
	private double cgpa;
	
	@Column(nullable = false)
	private double gpa;
	
	@OneToOne
	private Student_Course studentCourse;
	
	
	public Result() {
		
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}
	public Long getId() {
		return id;
	}
	public String getSubject() {
		return subject;
	}
	public double getMarks() {
		return marks;
	}
	public double getCgpa() {
		return cgpa;
	}

}
