package com.codeclan.example.CourseBooking;

import com.codeclan.example.CourseBooking.models.Booking;
import com.codeclan.example.CourseBooking.models.Course;
import com.codeclan.example.CourseBooking.models.Customer;
import com.codeclan.example.CourseBooking.repositories.BookingRepository;
import com.codeclan.example.CourseBooking.repositories.CourseRepository;
import com.codeclan.example.CourseBooking.repositories.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseBookingApplicationTests {

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	CourseRepository courseRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canGetCourseWithRating() {
		List<Course> result = courseRepository.getCourseByRating(4);
		assertEquals(1, result.size());
	}

	@Test
	public void canGetCustomersForGivenCourse() {
		List<Customer> result = customerRepository.findCustomerByBookingsCourseId(1L);
		assertEquals(1, result.size());
	}

	@Test
	public void canGetCourseByCustomerId() {
		List<Course> result = courseRepository.findCourseByBookingsCustomerId(1L);
		assertEquals(1, result.size());
	}

	@Test
	public void getBookingsByDate() {
		List<Booking> result = bookingRepository.findBookingsByDate("14-06-19");
		assertEquals(1, result.size());
	}

	@Test
	public void getCustomerInTownForCourse() {
		List<Customer> result = customerRepository.findCustomerByTownAndBookingsCourseId("Glasgow", 1L);
		assertEquals(1, result.size());
	}

	@Test
	public void getCustomerByTownAndAgeForCourse() {
		List<Customer> result = customerRepository.findCustomerByAgeGreaterThanAndTownAndBookingsCourseId(25, "Glasgow", 1L);
		assertEquals(1, result.size());
	}
}
