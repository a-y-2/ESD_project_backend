package com.example.backend.repository;


import com.example.backend.model.CoursePrerequisite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CourseprereqRepository extends JpaRepository<CoursePrerequisite,Long> {

    @Query(value = "SELECT id FROM course_prerequisite WHERE course_id = :courseId", nativeQuery = true)
    Set<Long> getEntriesBasedOnCourseId(@Param("courseId") Long courseId);

    @Query(value = "SELECT id FROM course_prerequisite WHERE  prereq_id = :courseId", nativeQuery = true)
    Set<Long> getEntriesBasedOnPrerequisiteId(@Param("courseId") Long courseId);
}
