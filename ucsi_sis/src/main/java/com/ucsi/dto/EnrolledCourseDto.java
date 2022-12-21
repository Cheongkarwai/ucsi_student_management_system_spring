package com.ucsi.dto;

import java.time.LocalDate;

import com.ucsi_sis.entity.Result;

public class EnrolledCourseDto {

	private Long id;

	private String name;

	private int creditHour;

	private double fees;

	private LocalDate dateFinished;

	private LocalDate dateEnrolled;

	private Result result;

	public EnrolledCourseDto() {

	}

	public EnrolledCourseDto(Long id, String name, int creditHour, double fees, LocalDate dateFinished,
			LocalDate dateEnrolled, Result result) {
		this.id = id;
		this.name = name;
		this.creditHour = creditHour;
		this.fees = fees;
		this.dateFinished = dateFinished;
		this.dateEnrolled = dateEnrolled;
		this.result = result;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

}
