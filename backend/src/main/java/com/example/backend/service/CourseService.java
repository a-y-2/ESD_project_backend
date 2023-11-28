package com.example.backend.service;

import com.example.backend.model.Course;
import com.example.backend.model.CoursePrerequisite;
import com.example.backend.model.User;
import com.example.backend.repository.CourseRepository;
import com.example.backend.repository.CourseprereqRepository;
import com.example.backend.repository.UserRepository;
import com.example.backend.requestBody.courseRequestBody;
import com.example.backend.requestBody.prereqReqBody;
import com.example.backend.requestBody.userLoginReqBody;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CourseprereqRepository coursePrereqRepo;

    @Autowired
    UserRepository userRepo;

//    public Course addCourse(Course course) {
//        return courseRepository.save(course);
//    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }


    //finds user by mail id if it exists in the db. and does validation check for matching password and admin type
    // Returns id of user if yes, else returns 0
    public Long validateUser(userLoginReqBody userReq) {
        Long userId = 0L;
        User user = userRepo.findByEmail(userReq.getEmail());
        if (user != null && user.getType().equalsIgnoreCase("ADMIN") && user.getPassword().equals(userReq.getPassword())) {
            userId = user.getId();
        }
        return userId;
    }

    public Course createCourse(courseRequestBody courseReqBody) {
        Course course = new Course();

        course.setCourse_code(courseReqBody.getCourseCode());
        course.setName(courseReqBody.getCourseName());
        course.setCapacity(courseReqBody.getCourseCapacity());
        course.setCredits(courseReqBody.getCourseCredits());
        course.setDescription(courseReqBody.getCourseDescription());
        course.setTerm(courseReqBody.getCourseTerm());
        course.setYear(courseReqBody.getCourseYear());
        course.setFaculty(courseReqBody.getCourseFaculty());

        Course savedCourse = courseRepository.save(course);

        List<prereqReqBody> prereqList = courseReqBody.getPreReqList();
        if (prereqList != null) {
            for (prereqReqBody prereqReqBody : prereqList) {
                Course prerequisiteCourse = courseRepository.findById(prereqReqBody.getPrereqId())
                        .orElseThrow(() -> new EntityNotFoundException("Prerequisite course not found"));

                CoursePrerequisite coursePrerequisite = new CoursePrerequisite();
                coursePrerequisite.setCourse(savedCourse);
                coursePrerequisite.setPrerequisite(prerequisiteCourse);
                coursePrerequisite.setPrereqDescription(prereqReqBody.getDescription());

                coursePrereqRepo.save(coursePrerequisite);
            }
        }
        return savedCourse;
    }


    @Transactional
    public boolean deleteCourse(Long courseId) {

        Optional<Course> optionalCourse = Optional.ofNullable(courseRepository.findCourseByIdOptionalWrapper(courseId));

        if (optionalCourse.isPresent()) {
            Course courseToDelete = optionalCourse.get();

            Set<Long> uniquePrereqIds = new HashSet<>();
            Set<Long> preReqIds1 = coursePrereqRepo.getEntriesBasedOnCourseId(courseToDelete.getCourse_id());
            uniquePrereqIds.addAll(preReqIds1);

            Set<Long> preReqIds2 = coursePrereqRepo.getEntriesBasedOnPrerequisiteId(courseToDelete.getCourse_id());
            uniquePrereqIds.addAll(preReqIds2);

            uniquePrereqIds.forEach(preReqId ->coursePrereqRepo.deleteById(preReqId));
            courseRepository.delete(courseToDelete);
            return true;
        } else {
            // Course not found
            return false;
        }
    }
}



