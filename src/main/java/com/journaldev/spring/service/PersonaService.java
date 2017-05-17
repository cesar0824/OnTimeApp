package com.journaldev.spring.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.hibernate.data.Persona;

@Component
public class PersonaService {

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
	public void save(Persona persona) {
		SessionFactory sessionF = new Configuration().configure().buildSessionFactory();
		Session session = sessionF.openSession();
		session.getTransaction().begin();
		session.save(persona);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

}
