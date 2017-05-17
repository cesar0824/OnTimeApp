package com.journaldev.hibernate.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pais")
public class Pais {

	private int paisId;
	private String descPais;
	
	@Id
	@Column(name="id_pais", unique = true, nullable = false)
	public int getPaisId() {
		return paisId;
	}
	public void setPaisId(int paisId) {
		this.paisId = paisId;
	}
	@Column(name="desc_pais")
	public String getDescPais() {
		return descPais;
	}
	public void setDescPais(String descPais) {
		this.descPais = descPais;
	}
	
	
}
