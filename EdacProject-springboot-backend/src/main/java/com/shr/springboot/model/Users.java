package com.shr.springboot.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="Users")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="user_name")
	@NotBlank
	private String username;
	
		
	@Column(name="email_id", unique = true)
	@NotBlank
	private String email;
	
	@Column(name="password")
	@NotBlank
	private String password;
	
	
	@Column(name="role")
	private int role;
	
	@ManyToMany
	@JoinTable(name = "users_courses",
				joinColumns = @JoinColumn(name = "user_id"),
				inverseJoinColumns = @JoinColumn(name = "course_id"))
	private List<Courses> userCourse = new ArrayList<>();


	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(long id, @NotBlank String username, @NotBlank String email, @NotBlank String password, int role,
			List<Courses> userCourse) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
		this.userCourse = userCourse;
	}




	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getRole() {
		return role;
	}


	public void setRole(int role) {
		this.role = role;
	}


	public List<Courses> getUserCourse() {
		return userCourse;
	}


	public void setUserCourse(List<Courses> userCourse) {
		this.userCourse = userCourse;
	}



	
}
