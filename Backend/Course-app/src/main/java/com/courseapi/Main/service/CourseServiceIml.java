package com.courseapi.Main.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courseapi.Main.Map.CourseMapper;
import com.courseapi.Main.dto.CourseInstance;
import com.courseapi.Main.entity.Course;
import com.courseapi.Main.repository.CourseRepository;


@Service
public class CourseServiceIml implements CourseService{

	
	 @Autowired
	private CourseRepository courserepository;
	
	public CourseServiceIml(CourseRepository courserepository) {
		this.courserepository = courserepository;
	}

	@Override
	public CourseInstance createCourse(CourseInstance course) {
		Course courses = CourseMapper.mapToCourse(course);
		Course savedcourse = courserepository.save(courses);
		return CourseMapper.mapToCourceInstance(savedcourse);
	}
	
	@Override
	public CourseInstance getcourseById(Long Id) {
		Course course = courserepository.findById(Id)
		.orElseThrow(() -> new RuntimeException("Course does not exist"));
		
		return CourseMapper.mapToCourceInstance(course);
	}
	
	@Override
	public CourseInstance updatecoursebyId(Long Id, String description) {
		Course course = courserepository
				.findById(Id)
				.orElseThrow(() -> new RuntimeException("Course does not exist"));
		 course.setDescription(description);
		 Course savedCourse = courserepository.save(course);
		return CourseMapper.mapToCourceInstance(savedCourse);
	}

	@Override
	public List<CourseInstance> getAllCourse() {
		  List<Course> courses = courserepository.findAll();
		  return courses.stream().map((course) -> CourseMapper
				  .mapToCourceInstance(course))
		          .collect(Collectors.toList());
	}
	
	@Override
	public void deleteCourseById(Long id) {
		Course course = courserepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Course does not exist"));  
		courserepository.deleteById(id);
	}

	@Override
    public List<CourseInstance> getCoursesByYearAndSemester(int year, int semester) {
        List<Course> courses = courserepository.findByYearAndSemester(year, semester);
        return courses.stream()
            .map(CourseMapper::mapToCourceInstance)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<CourseInstance> getCourseInstanceDetails(Long id, int year, int semester) {
        return courserepository.findByYearAndSemesterAndId(year, semester, id)
            .stream().findFirst().map(CourseMapper::mapToCourceInstance);
    }

//	@Override
//	public CourseInstance getcourseByYear(int year) {
//		Course course = courserepository.fin
//				.orElseThrow(() -> new RuntimeException("Course does not exist"));
//				
//				return CourseMapper.mapToCourceInstance(course);
//	}
	
	
	
	
	
}
