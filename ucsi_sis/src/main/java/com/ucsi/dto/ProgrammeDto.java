package com.ucsi.dto;

public class ProgrammeDto {

	private Long id;
	
	private String name;
	
	public ProgrammeDto() {
		
	}
	public ProgrammeDto(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
