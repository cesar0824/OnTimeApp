package com.journaldev.hibernate.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pqrs")
public class Pqr {

	private int calificacionId;
	private int personaId;
	private String opinion;
	private String categoria;
	
	@Id
	@Column(name="id_calificaion", unique = true, nullable = false)
	public int getCalificacionId() {
		return calificacionId;
	}
	public void setCalificacionId(int calificacionId) {
		this.calificacionId = calificacionId;
	}
	@Column(name="id_persona")
	public int getPersonaId() {
		return personaId;
	}
	public void setPersonaId(int personaId) {
		this.personaId = personaId;
	}
	@Column(name="opinion")
	public String getOpinion() {
		return opinion;
	}
	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}
	@Column(name="categoria")
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
}
