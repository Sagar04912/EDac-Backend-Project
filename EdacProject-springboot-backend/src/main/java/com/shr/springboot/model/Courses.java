package com.shr.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Value;

/*@Entity
@Table(name="Courses")
public class Courses {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="course_id")
	private long courseId;
	
	@Column(name="course_name" , nullable = false)
	private String courseName;
	
	@Column(name="rating")
	@Value("0")
	private int rating;
	
	@Column()
	private String author;
	
	@Min(value = 500)
	@Max(value = 5000)
	private long fees;*/

@Entity
@Table(name = "Courses")
public class Courses {
	@Id
	@Column(name = "course_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long courseId;

	@Column(name = "course_name", nullable = false, unique = true)
	private String courseName;

	@Column(name = "rating")
	@Value("0")
	private String rating;

	@Column(name = "price")
	@Min(value = 500)
	@Max(value = 5000)
	private double price;

	@Column(name = "author")
	private String author;
	
	
	public Courses() {
		// TODO Auto-generated constructor stub
	}


	public Courses(Long courseId, String courseName, String rating, @Min(500) @Max(5000) double price, String author
			) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.rating = rating;
		this.price = price;
		this.author = author;
		
	}


	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	
	
}
