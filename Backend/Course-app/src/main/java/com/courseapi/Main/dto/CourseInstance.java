package com.courseapi.Main.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CourseInstance {
	
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
		
	    public CourseInstance(Long id, String title, String courseCode, String description, int year, int semester) {
		this.id = id;
		this.title = title;
		this.courseCode = courseCode;
		this.description = description;
		this.year = year;
		this.semester = semester;
	}
		public CourseInstance() {
	    	
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
		private Long id;
	    private String title;
	    private String courseCode;
	    private String description;
	    private int year;
	    private int semester;
}
