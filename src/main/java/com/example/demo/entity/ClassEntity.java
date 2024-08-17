package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class ClassEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "classEntity")
    private List<Student> students;

	public ClassEntity() {
		
	}

	public ClassEntity(Long id, String name, List<Student> students) {
		super();
		this.id = id;
		this.name = name;
		this.students = students;
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

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
    
}
