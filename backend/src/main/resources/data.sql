DROP DATABASE IF EXISTS fullstack;
CREATE DATABASE IF NOT EXISTS fullstack;
USE fullstack;

DROP TABLE IF EXISTS employee,
    courses,
    users,
    course_prerequisite;
###ddls###

##USERS
create table users(
                      usr_id INT AUTO_INCREMENT PRIMARY KEY,
                      usr_email varchar(255) not null unique,
                      usr_password varchar(255) not null,
                      usr_type varchar(255) not null unique
);

##EMPLOYEE
create table employee(
                         employee_id INT AUTO_INCREMENT PRIMARY KEY,
                         first_name varchar(255) not null,
                         last_name varchar(255),
                         email varchar(255) not null unique,
                         title varchar(255),
                         photograph_path varchar(255),
                         dept_id int
);

##COURSES
create table courses(
                        course_id int AUTO_INCREMENT PRIMARY KEY,
                        course_code int not null unique,
                        coursename varchar(255) not null,
                        description varchar(255),
                        year int not null,
                        term varchar(255) not null,
                        credits int not null,
                        capacity int not null,
                        faculty int
);


##COURSE_PREREQUISITES
create table course_prerequisite(
                                    course_prereq_id INT AUTO_INCREMENT PRIMARY KEY,
                                    course_id int,
                                    prereq_course_id int,
                                    prereq_description varchar(255)
);

###ALTER FKS

alter table courses add constraint fk_faculty FOREIGN KEY (faculty) REFERENCES employee(employee_id);

alter table course_prerequisite add constraint fk_course_id FOREIGN KEY (course_id) REFERENCES courses(course_id);

alter table course_prerequisite add constraint fk_prereq_id FOREIGN KEY (prereq_course_id) REFERENCES courses(course_id);


###INSERTS

## Example 1: Regular User
INSERT INTO users (usr_id, usr_email, usr_password, usr_type) VALUES
(1,'john.doe@example.com', 'hashed_password_1', 'regular');

## Example 2: Admin User
INSERT INTO users (usr_id,usr_email, usr_password, usr_type) VALUES
(2,'admin@example.com', 'hashed_password_2', 'admin');

## Example 3: Moderator User
INSERT INTO users (usr_id, usr_email, usr_password, usr_type) VALUES
(3,'moderator@example.com', 'hashed_password_3', 'moderator');
