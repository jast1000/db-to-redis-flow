package org.duckdns.jastdev.read_jdbc_demo.model;

import java.io.Serializable;

public class Student implements Serializable {

	private static final long serialVersionUID = 6300166951974227565L;

	private Integer studentId;
	private String name;
	private String lastName;
	private String gender;

	public Student() {
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", lastName=" + lastName + ", gender=" + gender
				+ "]";
	}
	
}
