package com.journaldev.spring.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.hibernate.data.Ciudad;
import com.journaldev.hibernate.data.User;

@Component
public class CiudadService {

	private SessionFactory sessionFactory;
	private Map<Integer, String> ciudadesMap;

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
	
	public Map<Integer, String> getCiudadesMap() {
		if(ciudadesMap == null){
			search();
		}
		return ciudadesMap;
	}

	public void setCiudadesMap(Map<Integer, String> ciudadesMap) {
		this.ciudadesMap = ciudadesMap;
	}

	@Transactional
	public void search() {
		SessionFactory session = new Configuration().configure().buildSessionFactory();
		Query query = session.openSession()
				.createQuery("from Ciudad");
		List<Ciudad> result = query.list();
		session.getCurrentSession().disconnect();
		session.close();
		Map<Integer, String> resultMap = new HashMap<Integer, String>();
		for(Ciudad ciudad : result){
			resultMap.put(ciudad.getCiudadId(), ciudad.getDescCiudad());
		}
		setCiudadesMap(resultMap);
	}

}
