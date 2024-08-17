package com.example.demo.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String fullName;
	private String phone;
	private Date birth;
	private Double math;
	private Double english;

	@ManyToOne
	@JoinColumn(name = "class_id")
	private ClassEntity classEntity;

	public Student(Long id, String fullName, String phone, Date birth, Double math, Double english,
			ClassEntity classEntity) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.phone = phone;
		this.birth = birth;
		this.math = math;
		this.english = english;
		this.classEntity = classEntity;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Double getMath() {
		return math;
	}

	public void setMath(Double math) {
		this.math = math;
	}

	public Double getEnglish() {
		return english;
	}

	public void setEnglish(Double english) {
		this.english = english;
	}

	public ClassEntity getClassEntity() {
		return classEntity;
	}

	public void setClassEntity(ClassEntity classEntity) {
		this.classEntity = classEntity;
	}

}
