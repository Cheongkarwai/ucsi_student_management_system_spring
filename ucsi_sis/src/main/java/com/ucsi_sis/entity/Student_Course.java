package com.ucsi_sis.entity;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Student_Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Student student;
	
	@ManyToOne
	private Course course;
	
	private LocalDate dateFinished;
	
	private LocalDate dateEnrolled;
	
	@Column(nullable = false)
	private LocalDate dateCreated = LocalDate.now();
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Status status = Status.PENDING;
	
	@OneToOne(mappedBy = "studentCourse",cascade = CascadeType.ALL, orphanRemoval = true)
	private Result result;
	

	public Student_Course() {
		
	}
	
	public Student_Course(Student student, Course course, LocalDate dateFinished, LocalDate dateEnrolled) {
		this.student = student;
		this.course = course;
		this.dateFinished = dateFinished;
		this.dateEnrolled = dateEnrolled;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public LocalDate getDateFinished() {
		return dateFinished;
	}

	public void setDateFinished(LocalDate dateFinished) {
		this.dateFinished = dateFinished;
	}

	public LocalDate getDateEnrolled() {
		return dateEnrolled;
	}

	public void setDateEnrolled(LocalDate dateEnrolled) {
		this.dateEnrolled = dateEnrolled;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setResult(Result result) {
		this.result = result;
	}
	
	public Result getResult() {
		return result;
	}
	
}
