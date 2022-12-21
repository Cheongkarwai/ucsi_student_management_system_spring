package com.ucsi_sis.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	private String firstLineAddress;
	
	private String secondLineAddress;
	
	private String postcode;
	
	private String city;
	
	private String state;
	
	
	public Address() {
		
	}
	
	public Address(String firstLineAddress, String secondLineAddress, String postcode, String city, String state) {
		this.firstLineAddress = firstLineAddress;
		this.secondLineAddress = secondLineAddress;
		this.postcode = postcode;
		this.city = city;
		this.state = state;
	}
	
	public String getFirstLineAddress() {
		return firstLineAddress;
	}

	public void setFirstLineAddress(String firstLineAddress) {
		this.firstLineAddress = firstLineAddress;
	}

	public String getSecondLineAddress() {
		return secondLineAddress;
	}

	public void setSecondLineAddress(String secondLineAddress) {
		this.secondLineAddress = secondLineAddress;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}


}
