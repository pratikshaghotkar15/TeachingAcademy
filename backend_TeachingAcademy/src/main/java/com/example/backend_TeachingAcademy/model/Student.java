package com.example.backend_TeachingAcademy.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "stu_Name")
    private String stu_Name;
    
	@Column(name = "courseName")
    private String courseName;
    
	@Column(name = "companyName")
    private String companyName;
    
	@Column(name = "fee")
    private int fee;
	
	

	public Student()
	{
	}

	public Student(long id, String stu_Name, String courseName, String companyName, int fee) {
		super();
		this.id = id;
		this.stu_Name = stu_Name;
		this.courseName = courseName;
		this.companyName = companyName;
		this.fee = fee;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStu_Name() {
		return stu_Name;
	}

	public void setStu_Name(String stu_Name) {
		this.stu_Name = stu_Name;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}
	
	

}
