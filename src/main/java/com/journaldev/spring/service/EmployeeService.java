package com.journaldev.spring.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.hibernate.data.Employee;

@Component
public class EmployeeService {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			return sessionFactory = new Configuration().configure().buildSessionFactory();
		} else {
			return sessionFactory;
		}
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void register(Employee emp) {
		emp.setEmployeeId(generateID());
		// Acquire session
		Session session = getSessionFactory().openSession();
		// Save employee, saving behavior get done in a transactional manner
		session.getTransaction().begin();
		session.save(emp);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

	public long generateID() {
		SessionFactory session = new Configuration().configure().buildSessionFactory();
		List<Employee> result = (List<Employee>) session.openSession().createQuery("from Employee").list();
		session.getCurrentSession().disconnect();
		session.close();
		return result.size()+1;
	}

}
