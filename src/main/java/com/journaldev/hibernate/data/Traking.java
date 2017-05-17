package com.journaldev.hibernate.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pqrs")
public class Traking {

	private int trakingId;
	private int personaId;
	private int ciudadOrigen;
	private int ciudadDestino;
	private String estado;
	
	@Id
	@Column(name="id_traking", unique = true, nullable = false)
	public int getTrakingId() {
		return trakingId;
	}
	public void setTrakingId(int trakingId) {
		this.trakingId = trakingId;
	}
	@Column(name="id_persona")
	public int getPersonaId() {
		return personaId;
	}
	public void setPersonaId(int personaId) {
		this.personaId = personaId;
	}
	@Column(name="ciudad_origen")
	public int getCiudadOrigen() {
		return ciudadOrigen;
	}
	public void setCiudadOrigen(int ciudadOrigen) {
		this.ciudadOrigen = ciudadOrigen;
	}
	@Column(name="ciudad_destino")
	public int getCiudadDestino() {
		return ciudadDestino;
	}
	public void setCiudadDestino(int ciudadDestino) {
		this.ciudadDestino = ciudadDestino;
	}
	@Column(name="estado")
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
