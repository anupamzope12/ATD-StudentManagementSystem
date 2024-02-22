package com.app.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="students")
public class Student {
	
	@Id
	@Column(name="roll_No",unique = true,nullable = false)
	public Long	rollNo;
	@Column(name="first_Name", nullable = false)
	public String firstName;
	@Column(name="last_Name")
	public String lastName;
	@Column(name = "email_Id",nullable = false)
	public String emailId;
	public String city;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(Long rollNo, String firstName, String lastName, String emailId, String city) {
		super();
		this.rollNo = rollNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.city = city;
	}

	public Long getRollNo() {
		return rollNo;
	}

	public void setRollNo(Long rollNo) {
		this.rollNo = rollNo;
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId="
				+ emailId + ", city=" + city + "]";
	}		
}