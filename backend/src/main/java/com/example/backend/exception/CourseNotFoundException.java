package com.example.backend.exception;

public class CourseNotFoundException extends RuntimeException{
    public CourseNotFoundException(Long course_id){
        super("course not found");
    }
}
