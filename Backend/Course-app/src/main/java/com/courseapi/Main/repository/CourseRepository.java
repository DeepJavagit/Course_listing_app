package com.courseapi.Main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.courseapi.Main.dto.CourseInstance;
import com.courseapi.Main.entity.Course;


public interface CourseRepository extends JpaRepository<Course, Long> {
	List<Course> findByYearAndSemester(int year, int semester);
	
    List<Course> findByYearAndSemesterAndId(int year, int semester, Long id);
}
