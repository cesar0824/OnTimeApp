package com.journaldev.hibernate.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="paquete")
public class Paquete {
	
	private  int paqueteId;
	private String dimensiones;
	private int peso;
	private int valor;
	private String estado;
	private int personaId;
	private String observacion;
	
	@Id
	@Column(name="id_paquete", unique = true, nullable = false)
	public int getPaqueteId() {
		return paqueteId;
	}
	public void setPaqueteId(int paqueteId) {
		this.paqueteId = paqueteId;
	}
	@Column(name="dimensiones")
	public String getDimensiones() {
		return dimensiones;
	}
	public void setDimensiones(String dimensiones) {
		this.dimensiones = dimensiones;
	}
	@Column(name="peso")
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	@Column(name="valor")
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	@Column(name="estado")
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	@Column(name="id_persona")
	public int getPersonaId() {
		return personaId;
	}
	public void setPersonaId(int personaId) {
		this.personaId = personaId;
	}
	@Column(name="observacion")
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	
}
