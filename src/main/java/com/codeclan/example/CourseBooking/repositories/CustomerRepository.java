package com.codeclan.example.CourseBooking.repositories;

import com.codeclan.example.CourseBooking.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long>, CustomerRepositoryCustom {

    List<Customer> getCustomersForCourse(Long id);

    List<Customer> findCustomerByBookingsCourseId(Long id);

    List<Customer> findCustomerByTownAndBookingsCourseId(String town, Long id);

    List<Customer> findCustomerByTownAndAgeAndBookingsCourseId(String town, int something, Long id);

}
