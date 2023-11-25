package com.example.backend.service;

import com.example.backend.exception.CourseNotFoundException;
import com.example.backend.model.Course;
import com.example.backend.model.User;
import com.example.backend.repository.CourseRepository;
import com.example.backend.repository.UserRepository;
import com.example.backend.requestBody.userLoginReqBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    @Autowired
    UserRepository userRepo;

    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }


    //finds user by mail id if it exists in the db. and does validation check for matching password and admin type
    // Returns id of user if yes, else returns 0
    public Long validateUser(userLoginReqBody userReq) {
        Long userId=0L;
        User user = userRepo.findByEmail(userReq.getEmail());
        if (user != null && user.getType().equalsIgnoreCase("ADMIN") && user.getPassword().equals(userReq.getPassword())) {
            userId = user.getId();
        }
        return userId;
    }
}



