package com.ucsi_sis.entity;

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

import org.hibernate.annotations.ColumnDefault;

@Entity
public class Course {

	@Id
	private String id;

	@Column(nullable = false)
	private String name;
	
	@ColumnDefault(value="0")
	private int creditHour;
	
	@Column(precision = 10,scale = 2,nullable = false)
	private double fees;
	
	@ManyToOne
	private Programme programme;
	
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Student_Course> enrolledStudents = new ArrayList<>();
	
	public Course() {
		
	}
	
	public Course(String id,String name,int creditHour) {
		this.id = id;
		this.name = name;
		this.creditHour = creditHour;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCreditHour() {
		return creditHour;
	}

	public void setCreditHour(int creditHour) {
		this.creditHour = creditHour;
	}
	
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	
}
