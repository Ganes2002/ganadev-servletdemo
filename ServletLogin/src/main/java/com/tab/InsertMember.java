package com.tab;


public class InsertMember {
	
	int id;
	String name;
	String email;
	String dept;
	int salary;

	public InsertMember(int id,String name,String email,String dept,int salary) {
		this.id=id;
		this.name=name;
		this.email=email;
		this.dept=dept;
		this.salary=salary;
	}
	
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	public String getDepartment() {
		return dept;
	}
	public int getSalary() {
		return salary;
	}
}
