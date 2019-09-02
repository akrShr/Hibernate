package com.entitiesorPOJO.coreJavanHibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="student_details")
public class StudentDetails {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="degree_program")
	private String degreeProg;
	
	@Column(name="semester")
	private String semester;
	
	@OneToOne(mappedBy="studentDetails",cascade=CascadeType.ALL)
	private Student student;
	
	public StudentDetails(){
		
	}
	
	public StudentDetails(String degreeProg, String semester) {
		this.degreeProg = degreeProg;
		this.semester = semester;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDegreeProg() {
		return degreeProg;
	}

	public void setDegreeProg(String degreeProg) {
		this.degreeProg = degreeProg;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
