package com.journaldev.hibernate.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="calificanos")
public class Calificanos {

	private int pqrId;
	private int personaId;
	private int pqr1;
	private int pqr2;
	private int pqr3;
	private int pqr4;
	private int pqr5;
	private int pqr6;
	private int pqr7;
	private int pqr8;
	private int pqr9;
	private String otros;
	
	@Id
	@Column(name="id_pqr", unique = true, nullable = false)
	public int getPqrId() {
		return pqrId;
	}
	public void setPqrId(int pqrId) {
		this.pqrId = pqrId;
	}
	@Column(name="id_persona")
	public int getPersonaId() {
		return personaId;
	}
	public void setPersonaId(int personaId) {
		this.personaId = personaId;
	}
	@Column(name="pqr1")
	public int getPqr1() {
		return pqr1;
	}
	public void setPqr1(int pqr1) {
		this.pqr1 = pqr1;
	}
	@Column(name="pqr2")
	public int getPqr2() {
		return pqr2;
	}
	public void setPqr2(int pqr2) {
		this.pqr2 = pqr2;
	}
	@Column(name="pqr3")
	public int getPqr3() {
		return pqr3;
	}
	public void setPqr3(int pqr3) {
		this.pqr3 = pqr3;
	}
	@Column(name="pqr4")
	public int getPqr4() {
		return pqr4;
	}
	public void setPqr4(int pqr4) {
		this.pqr4 = pqr4;
	}
	@Column(name="pqr5")
	public int getPqr5() {
		return pqr5;
	}
	public void setPqr5(int pqr5) {
		this.pqr5 = pqr5;
	}
	@Column(name="pqr6")
	public int getPqr6() {
		return pqr6;
	}
	public void setPqr6(int pqr6) {
		this.pqr6 = pqr6;
	}
	@Column(name="pqr7")
	public int getPqr7() {
		return pqr7;
	}
	public void setPqr7(int pqr7) {
		this.pqr7 = pqr7;
	}
	@Column(name="pqr8")
	public int getPqr8() {
		return pqr8;
	}
	public void setPqr8(int pqr8) {
		this.pqr8 = pqr8;
	}
	@Column(name="pqr9")
	public int getPqr9() {
		return pqr9;
	}
	public void setPqr9(int pqr9) {
		this.pqr9 = pqr9;
	}
	@Column(name="otros")
	public String getOtros() {
		return otros;
	}
	public void setOtros(String otros) {
		this.otros = otros;
	}
	
	
}
