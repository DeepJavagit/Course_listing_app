package com.courseapi.Main.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.courseapi.Main.dto.CourseInstance;
import com.courseapi.Main.service.CourseService;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
     
	  private CourseService courseService;

	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}
	
	
	//add Course rest api
	@PostMapping
	public ResponseEntity<CourseInstance> addCourse(@RequestBody CourseInstance courseInst){
		return new ResponseEntity<>(courseService.createCourse(courseInst), HttpStatus.CREATED);
	}
	
	// get course rest api
	@GetMapping("/{id}")
	public ResponseEntity<CourseInstance> getcourseById(@PathVariable Long id){
		 CourseInstance courseinst = courseService.getcourseById(id);
		 return ResponseEntity.ok(courseinst);
	}
	
	//update corse rest api
	@PutMapping("/{id}/update")
    public  ResponseEntity<CourseInstance> courseupdate(@PathVariable Long id, @RequestBody Map<String, String> request ){
    	String str = request.get("description");
    	CourseInstance coursedet =  courseService.updatecoursebyId(id, str);
    	return ResponseEntity.ok(coursedet);
    	   
    }
	
	//get all courses rest api
	@GetMapping
	public  ResponseEntity<List<CourseInstance>> getAllCourses(){
		 List<CourseInstance> courseall = courseService.getAllCourse();
		 return ResponseEntity.ok(courseall);
	}
	
	@DeleteMapping("/{id}")
	public  ResponseEntity<String> deletCourse(@PathVariable Long id){
		courseService.deleteCourseById(id);
		return  ResponseEntity.ok("Course delete successfully!");
	}
	
	 @GetMapping("/{year}/{semester}")
	    public ResponseEntity<List<CourseInstance>> getCoursesByYearAndSemester(@PathVariable int year, @PathVariable int semester) {
	        List<CourseInstance> courses = courseService.getCoursesByYearAndSemester(year, semester);
	        return ResponseEntity.ok(courses);
	    }
	 
	 @GetMapping("/{id}/{year}/{semester}")
	 public ResponseEntity<CourseInstance> getCourseByIdYearAndSemester(
	            @PathVariable Long id, @PathVariable int year, @PathVariable int semester) {
	        Optional<CourseInstance> courseInst = courseService.getCourseInstanceDetails(id, year, semester);
	        return courseInst.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	    }
	 
	 @DeleteMapping("/delete/{year}/{semester}/{id}")
	    public ResponseEntity<String> deleteCourseInstance(
	            @PathVariable int year,
	            @PathVariable int semester,
	            @PathVariable Long id) {
	        Optional<CourseInstance> courseInstance = courseService.getCourseInstanceDetails(id, year, semester);
	        if (courseInstance.isPresent()) {
	            courseService.deleteCourseById(id);
	            return ResponseEntity.ok("Course instance deleted successfully!");
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course instance not found!");
	        }
	    }
}
