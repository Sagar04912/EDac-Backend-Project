package com.shr.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userCourse")
public class UserCourse  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long uId;	// User Course ID // primary key
	@Column(name = "user_id")
	private long id;	//User ID // foreign key
	@Column(name = "course_id")
	private long courseId;	//Course ID	// foreign key
	
	public UserCourse() {
		// TODO Auto-generated constructor stub
	}

	
	public UserCourse(long uId, long id, long courseId) {
		super();
		this.uId = uId;
		this.id = id;
		this.courseId = courseId;
		
	}


	public long getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	
}
