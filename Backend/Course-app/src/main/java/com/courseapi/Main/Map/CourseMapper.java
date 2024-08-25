package com.courseapi.Main.Map;

import com.courseapi.Main.dto.CourseInstance;
import com.courseapi.Main.entity.Course;

public class CourseMapper {
    public static Course mapToCourse(CourseInstance courseInst) {
    	   Course course = new Course(
    			   courseInst.getId(),
    			   courseInst.getTitle(),
    			   courseInst.getCourseCode(),
    			   courseInst.getDescription(),
    			   courseInst.getYear(),
    			   courseInst.getSemester()
    			   );
    	   return course;
    }
    
    public static CourseInstance mapToCourceInstance(Course course) {
    	  CourseInstance courseinst = new CourseInstance(
    		   course.getId(),
   			   course.getTitle(),
   			   course.getCourseCode(),
   			   course.getDescription(),
   			   course.getYear(),
   			   course.getSemester()
    			  );
    	  return courseinst;
    }
}
