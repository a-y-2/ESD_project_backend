package com.example.backend.requestBody;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor

public class courseRequestBody {


    @JsonProperty("code")
    private String courseCode;

    @JsonProperty("name")
    private String courseName;

    @JsonProperty("description")
    private String courseDescription;

    @JsonProperty("year")
    private int courseYear;

    @JsonProperty("term")
    private String courseTerm;

    @JsonProperty("credits")
    private int courseCredits;

    @JsonProperty("capacity")
    private int courseCapacity;

    @JsonProperty("faculty")
    private String courseFaculty;


    @JsonProperty("course_prereq")
    public List<prereqReqBody> preReqList;

    public List<prereqReqBody> getPreReqList() {
        return preReqList;
    }

    public void setPreReqList(List<prereqReqBody> preReqList) {
        this.preReqList = preReqList;
    }


    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public int getCourseYear() {
        return courseYear;
    }

    public void setCourseYear(int courseYear) {
        this.courseYear = courseYear;
    }

    public String getCourseTerm() {
        return courseTerm;
    }

    public void setCourseTerm(String courseTerm) {
        this.courseTerm = courseTerm;
    }

    public int getCourseCredits() {
        return courseCredits;
    }

    public void setCourseCredits(int courseCredits) {
        this.courseCredits = courseCredits;
    }

    public int getCourseCapacity() {
        return courseCapacity;
    }

    public void setCourseCapacity(int courseCapacity) {
        this.courseCapacity = courseCapacity;
    }

    public String getCourseFaculty() {
        return courseFaculty;
    }

    public void setCourseFaculty(String courseFaculty) {
        this.courseFaculty = courseFaculty;
    }





}

