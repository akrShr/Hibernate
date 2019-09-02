package com.entitiesorPOJO.coreJavanHibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="sports")
public class Sports {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;	
	
	@Column(name="title")
	private String title;
	
	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE,
			   CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="student_id")
	private Student student;

	public Sports() {
		
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
