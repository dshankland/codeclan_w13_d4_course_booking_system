package com.codeclan.example.CourseBooking.repositories;

import com.codeclan.example.CourseBooking.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> getCourseByRating(int rating);

    List<Course> findCourseByBookingsCustomerId(Long id);
}
