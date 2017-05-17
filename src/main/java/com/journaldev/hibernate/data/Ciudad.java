package com.journaldev.hibernate.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ciudad")
public class Ciudad {

	private int ciudadId;
	private String descCiudad;
	private int paisId;
	
	@Id
	@Column(name="id_ciudad", unique = true, nullable = false)
	public int getCiudadId() {
		return ciudadId;
	}
	public void setCiudadId(int ciudadId) {
		this.ciudadId = ciudadId;
	}
	@Column(name="desc_ciudad")
	public String getDescCiudad() {
		return descCiudad;
	}
	public void setDescCiudad(String descCiudad) {
		this.descCiudad = descCiudad;
	}
	@Column(name="id_pais")
	public int getPaisId() {
		return paisId;
	}
	public void setPaisId(int paisId) {
		this.paisId = paisId;
	}
	
	
}
