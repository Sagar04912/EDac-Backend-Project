package com.shr.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userCart")
public class UserCart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usercart_id")
	private long userCartId;
	@Column(name = "user_id", nullable = false)
	private long id;
	@Column(name = "course_id", nullable = false)
	private long courseId;
	
	public UserCart() {
		// TODO Auto-generated constructor stub
	}

	
	public UserCart(long userCartId, long id, long courseId) {
		super();
		this.userCartId = userCartId;
		this.id = id;
		this.courseId = courseId;
	}


	public long getUserCartId() {
		return userCartId;
	}


	public void setUserCartId(long userCartId) {
		this.userCartId = userCartId;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}
}
