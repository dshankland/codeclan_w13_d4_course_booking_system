package com.codeclan.example.CourseBooking.repositories;

import com.codeclan.example.CourseBooking.models.Customer;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Customer> getCustomersForCourse(Long id) {

        List<Customer> results = null;
        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria cr = session.createCriteria(Customer.class);
            cr.createAlias("booking", "bookingAlias");
//            cr.add(Restrictions.eq("bookingAlias.course_id", id));
            cr.createAlias("bookingAlias.course_id", "courseAlias");
            cr.add(Restrictions.eq("courseAlias.id", id));
            results = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
        }

        return results;
    }


}
