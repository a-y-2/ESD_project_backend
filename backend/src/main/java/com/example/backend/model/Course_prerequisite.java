package com.example.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.HashSet;

@Entity
public class Course_prerequisite {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToMany
    @
    private Set<Course> course_id = new HashSet<>();
}
