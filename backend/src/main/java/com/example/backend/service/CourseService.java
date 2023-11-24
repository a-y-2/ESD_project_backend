package com.example.backend.service;

import com.example.backend.exception.CourseNotFoundException;
import com.example.backend.model.Course;
import com.example.backend.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;
    public Course addCourse(Course course){
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

//    public Course getCourseById(Long course_id) {
//        return courseRepository.findById(course_id)
//                .orElseThrow(() -> new CourseNotFoundException(course_id));
    }



