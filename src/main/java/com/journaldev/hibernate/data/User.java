package com.journaldev.hibernate.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class User {
	
	private int usuarioID;
	private String usuario;
	private String pass;
	private String rol;
	private int personaID;
	
	@Id
	@Column(name="id_usuario", unique = true, nullable = false)
	public int getUsuarioID() {
		return usuarioID;
	}
	public void setUsuarioID(int usuarioID) {
		this.usuarioID = usuarioID;
	}
	@Column(name="usuario")
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	@Column(name="pass")
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Column(name="rol")
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	@Column(name="id_persona")
	public int getPersonaID() {
		return personaID;
	}
	public void setPersonaID(int personaID) {
		this.personaID = personaID;
	}

}
