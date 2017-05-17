package com.journaldev.hibernate.data;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="calificaion")
public class Calificacion {

	private int calificacionId;
	private int personaId;
	private String opinion;
	private int rating;
	private Date fecha;
	
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
	@Column(name="rating")
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	@Column(name="fecha")
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
}
