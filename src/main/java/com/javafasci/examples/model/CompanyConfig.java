package com.javafasci.examples.model;

public class CompanyConfig {
	
	private int id;
	private String name;
	private int employeeCount;
	
	
	public CompanyConfig(int id, String name, int employeeCount) {
		super();
		this.id = id;
		this.name = name;
		this.employeeCount = employeeCount;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEmployeeCount() {
		return employeeCount;
	}
	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
	}
	
}
