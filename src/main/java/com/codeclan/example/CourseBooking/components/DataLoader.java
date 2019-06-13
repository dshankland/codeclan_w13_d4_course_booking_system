package com.codeclan.example.CourseBooking.components;

import com.codeclan.example.CourseBooking.models.Booking;
import com.codeclan.example.CourseBooking.models.Course;
import com.codeclan.example.CourseBooking.models.Customer;
import com.codeclan.example.CourseBooking.repositories.BookingRepository;
import com.codeclan.example.CourseBooking.repositories.CourseRepository;
import com.codeclan.example.CourseBooking.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader() {
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Customer customer1 = new Customer("Jimmy Smith", "Glasgow", 33);
        customerRepository.save(customer1);

        Customer customer2 = new Customer("Betty Smith", "Glasgow", 25);
        customerRepository.save(customer2);

        Course course1 = new Course("CodeClan", "Glasgow", 5);
        courseRepository.save(course1);

        Course course2 = new Course("Kung Fu", "Edinburgh", 4);
        courseRepository.save(course2);

        Booking booking1 = new Booking("13-06-19", course1, customer1);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("14-06-19", course2, customer2);
        bookingRepository.save(booking2);
    }
}
