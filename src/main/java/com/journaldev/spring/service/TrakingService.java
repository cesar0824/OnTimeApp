package com.journaldev.spring.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.hibernate.data.Traking;
import com.journaldev.hibernate.data.TrakingPaquete;
import com.journaldev.hibernate.data.User;

@Component
public class TrakingService {

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
	public List<Traking> search(User usr, int traking) {
		SessionFactory session = new Configuration().configure().buildSessionFactory();
		Query query = session.openSession()
				.createQuery("from Traking where trakingId = :traking and personaId = :persona");
		query.setParameter("traking", traking);
		query.setParameter("persona", usr.getPersonaID());
		List<Traking> result = query.list();
		session.getCurrentSession().disconnect();
		session.close();
		return result;
	}

	@Transactional
	public List<Traking> searchAll(User user) {
		SessionFactory session = new Configuration().configure().buildSessionFactory();
		Query query = session.openSession()
				.createQuery("from Traking where personaId = :persona");
		query.setParameter("persona", user.getPersonaID());
		List<Traking> result = query.list();
		session.getCurrentSession().disconnect();
		session.close();
		return result;
	}
	
	@Transactional
	public String searchPaquete(int traking) {
		SessionFactory session = new Configuration().configure().buildSessionFactory();
		Query query = session.openSession().createQuery("from TrakingPaquete where trakingId = :traking");
		query.setParameter("traking", traking);
		List<TrakingPaquete> result = query.list();
		session.getCurrentSession().disconnect();
		session.close();
		String all = "";
		int cont = 0;
		for (TrakingPaquete tp : result) {
			cont++;
			if (all.isEmpty()) {
				all += tp.getPaqueteId() + ", ";
			} else {
				if (cont == result.size()) {
					all += tp.getPaqueteId();
				} else {
					all += tp.getPaqueteId() + ", ";
				}
			}
		}
		return all;
	}

}
