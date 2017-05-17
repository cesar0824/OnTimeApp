package com.journaldev.hibernate.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="persona")
public class Persona {

	private int identificacion;
	private String tipoId;
	private String nombre;
	private String apellido;
	private String direccion;
	private int telefono1;
	private int telefono2;
	
	@Id
	@Column(name="identificacion", unique = true, nullable = false)
	public int getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(int identificacion) {
		this.identificacion = identificacion;
	}
	@Column(name="tipo_id")
	public String getTipoId() {
		return tipoId;
	}
	public void setTipoId(String tipoId) {
		this.tipoId = tipoId;
	}
	@Column(name="nombre")
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Column(name="apellido")
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	@Column(name="direccion")
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	@Column(name="telefono1")
	public int getTelefono1() {
		return telefono1;
	}
	public void setTelefono1(int telefono1) {
		this.telefono1 = telefono1;
	}
	@Column(name="telefono2")
	public int getTelefono2() {
		return telefono2;
	}
	public void setTelefono2(int telefono2) {
		this.telefono2 = telefono2;
	}
	
}
