package com.journaldev.prime.faces.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.journaldev.hibernate.data.Persona;
import com.journaldev.hibernate.data.User;
import com.journaldev.spring.service.PersonaService;
import com.journaldev.spring.service.UserService;

@ManagedBean(name = "registerBean")
@SessionScoped
public class RegisterBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value = "#{personaService}")
	PersonaService personaService;
	
	@ManagedProperty(value = "#{userService}")
	UserService userService;
	
	Persona persona = new Persona();
	
	private String username;
	private String password1;
	private String password2;

	public PersonaService getPersonaService() {
		return personaService;
	}

	public void setPersonaService(PersonaService personaService) {
		this.personaService = personaService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public Persona getPersona() {
		if(persona == null){
			return persona = new Persona();
		}else{
			return persona;	
		}
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	public void register(){
		try{
		if(userService.validUserName(username)){
			if(password1.equals(password2)){
				personaService.save(getPersona());
				User usr = new User();
				usr.setRol("C");
				usr.setPersonaID(getPersona().getIdentificacion());
				usr.setUsuario(username);
				usr.setPass(password1);
				userService.save(usr);
				FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
			}else{
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Las contraseñas deben ser iguales"));				
			}
		}else{
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Usuario registrado"));
		}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}	
}
