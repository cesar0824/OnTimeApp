package com.journaldev.prime.faces.beans;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.bean.ManagedBean;

@ManagedBean (name="indexBean")
public class IndexBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2743290558520564449L;

	public void goToLogin() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void goToIndex() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void goToHome() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("welcome.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void goToRegistro() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("register.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
