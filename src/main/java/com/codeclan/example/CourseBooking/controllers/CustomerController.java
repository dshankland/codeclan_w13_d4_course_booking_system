package com.codeclan.example.CourseBooking.controllers;

import com.codeclan.example.CourseBooking.models.Course;
import com.codeclan.example.CourseBooking.models.Customer;
import com.codeclan.example.CourseBooking.repositories.CourseRepository;
import com.codeclan.example.CourseBooking.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/courseid/{id}")
    public List<Customer> getCustomerByCourseId(@PathVariable Long id) {
        return customerRepository.findCustomerByBookingsCourseId(id);
    }

    @GetMapping(value = "/town/{town}/course/{id}")
    public List<Customer> getCustomerByTownAndCourseId(@PathVariable String town, @PathVariable Long id) {
        return customerRepository.findCustomerByTownAndBookingsCourseId(town, id);
    }

}
