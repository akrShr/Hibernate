package com.entitiesorPOJO.coreJavanHibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="student")
public class Student {
		
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="addmision_status")
	private String addmisionStatus;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="student_details_id")
	private StudentDetails studentDetails;
	
	//When we delete student instance we don't want to delete the associated sports instance
	@OneToMany(fetch = FetchType.EAGER,mappedBy="student",
			   cascade={CascadeType.PERSIST,CascadeType.MERGE,
			   CascadeType.DETACH,CascadeType.REFRESH})
	private List<Sports> sports;

	public Student(){			
		}

	public Student(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public StudentDetails getStudentDetails() {
		return studentDetails;
	}

	public void setStudentDetails(StudentDetails studentDetails) {
		this.studentDetails = studentDetails;
	}

	public void setAddmisionStatus(String addmisionStatus) {
		this.addmisionStatus = addmisionStatus;
	}

	public List<Sports> getSports() {
		return sports;
	}

	public void setSports(List<Sports> sports) {
		this.sports = sports;
	}
	
	//for bi-directional relationship between Sports and Student class
	public void addSports(Sports sport){
		if (this.sports == null)
			this.sports=new ArrayList<Sports>();
		
		this.sports.add(sport);
		sport.setStudent(this);
	}
}
