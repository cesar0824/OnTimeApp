package com.journaldev.spring.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.hibernate.data.User;

@Component
public class UserService {

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
	public List<User> validUser(User usr) {
		SessionFactory session = new Configuration().configure().buildSessionFactory();
		Query query = session.openSession().createQuery("from User where usuario = :usuario and pass = :pass");
		query.setParameter("usuario", usr.getUsuario().toUpperCase());
		query.setParameter("pass", usr.getPass());
		List<User> result = query.list();
		session.getCurrentSession().disconnect();
		session.close();
		return result;
	}
	
	@Transactional
	public boolean validUserName(String usr) {
		SessionFactory session = new Configuration().configure().buildSessionFactory();
		Query query = session.openSession().createQuery("from User where usuario = :usuario");
		query.setParameter("usuario", usr.toUpperCase());
		List<User> result = query.list();
		session.getCurrentSession().disconnect();
		session.close();
		return result.isEmpty();
	}
	
	@Transactional
	public void save(User usr) {
		usr.setUsuarioID(generateID());
		usr.setUsuario(usr.getUsuario().toUpperCase());
		SessionFactory sessionF = new Configuration().configure().buildSessionFactory();
		Session session = getSessionFactory().openSession();
		session.getTransaction().begin();
		session.save(usr);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

	@Transactional
	public int generateID() {
		SessionFactory session = new Configuration().configure().buildSessionFactory();
		List<User> result = (List<User>) session.openSession().createQuery("from User").list();
		session.getCurrentSession().disconnect();
		session.close();
		return result.size()+1;
	}
}
