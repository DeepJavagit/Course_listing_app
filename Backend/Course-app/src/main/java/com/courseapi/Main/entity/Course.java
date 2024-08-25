package com.courseapi.Main.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "courses")
@Entity
public class Course {
    
	
	
    public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Course(Long id, String title, String courseCode, String description,int year, int semester) {
		this.id = id;
		this.title = title;
		this.courseCode = courseCode;
		this.description = description;
		this.year = year;
		this.semester = semester;
	}
	public Course() {
		
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "course_title")
    private String title;
    @Column(name = "course_coursecode")
    private String courseCode;
    @Column(name = "course_description")
    private String description;
    @Column(name = "course_year")
    private int year;
    @Column(name = "course_semester")
    private int semester;

    
}
