package com.journaldev.hibernate.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="traking_paquete")
public class TrakingPaquete {
	
	private int trakingPaqueteId;
	private int trakingId;
	private int paqueteId;
	
	@Id
	@Column(name="id_traking_paquete", unique = true, nullable = false)
	public int getTrakingPaqueteId() {
		return trakingPaqueteId;
	}
	public void setTrakingPaqueteId(int trakingPaqueteId) {
		this.trakingPaqueteId = trakingPaqueteId;
	}
	@Column(name="id_traking")
	public int getTrakingId() {
		return trakingId;
	}
	public void setTrakingId(int trakingId) {
		this.trakingId = trakingId;
	}
	@Column(name="id_paquete")
	public int getPaqueteId() {
		return paqueteId;
	}
	public void setPaqueteId(int paqueteId) {
		this.paqueteId = paqueteId;
	}
	
	

}

