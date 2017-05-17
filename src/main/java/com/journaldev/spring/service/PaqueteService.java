package com.journaldev.spring.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.hibernate.data.Paquete;
import com.journaldev.hibernate.data.User;

@Component
public class PaqueteService {

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
	public List<Paquete> searchAllId(String allId) {
		SessionFactory session = new Configuration().configure().buildSessionFactory();
		Query query = session.openSession()
				.createQuery("from Paquete where paqueteId in ("+ allId+")");
		List<Paquete> result = query.list();
		session.getCurrentSession().disconnect();
		session.close();
		return result;
	}

	@Transactional
	public List<Paquete> searchAll(User user) {
		SessionFactory session = new Configuration().configure().buildSessionFactory();
		Query query = session.openSession()
				.createQuery("from Paquete where personaId = :persona");
		query.setParameter("persona", user.getPersonaID());
		List<Paquete> result = query.list();
		session.getCurrentSession().disconnect();
		session.close();
		return result;
	}
	
	@Transactional
	public int getId() {
		SessionFactory session = new Configuration().configure().buildSessionFactory();
		Query query = session.openSession()
				.createQuery("from Paquete");
		List<Paquete> result = query.list();
		session.getCurrentSession().disconnect();
		session.close();
		return result.size()+1;
	}
	
	@Transactional
	public void save(Paquete paquete) {
		paquete.setPaqueteId(getId());
		paquete.setEstado("Pendiente Aprovación");
		SessionFactory sessionF = new Configuration().configure().buildSessionFactory();
		Session session = sessionF.openSession();
		session.getTransaction().begin();
		session.save(paquete);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
}
