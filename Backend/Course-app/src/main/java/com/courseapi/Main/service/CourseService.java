package com.courseapi.Main.service;

import java.util.List;
import java.util.Optional;

import com.courseapi.Main.dto.CourseInstance;



public interface CourseService {
	
    CourseInstance createCourse(CourseInstance course);
    
    CourseInstance getcourseById(Long Id);
    
    CourseInstance updatecoursebyId(Long Id , String description);
    
    List<CourseInstance> getAllCourse();
    
    void deleteCourseById(Long Id);
    
    List<CourseInstance> getCoursesByYearAndSemester(int year, int semester);
    
    Optional<CourseInstance> getCourseInstanceDetails( Long id, int year, int semester);
}
