package com.journaldev.prime.faces.beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.journaldev.hibernate.data.User;
import com.journaldev.spring.service.UserService;

/**
 * 
 * User Managed Bean
 * 
 *
 */
@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = "success";
	private static final String ERROR = "error";

	// Spring User Service is injected...
	@ManagedProperty(value = "#{userService}")
	UserService userService;

	User user = new User();

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserService getUserService() {
		return userService;
	}

	public User getUser() {
		if (user == null) {
			return user = new User();
		} else {
			return user;
		}
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static HttpSession getSessionUsingFaces() {
		return (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext()
				.getSession(false);
	}
	
	public void login() {
		// Calling Business Service
		FacesMessage message;
		List<User> listUser = userService.validUser(getUser());
		if (!listUser.isEmpty()) {
			HttpSession session = getSessionUsingFaces();
			session.setAttribute("user", listUser.get(0));
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", getUser().getUsuario());
			try {
				FacesContext.getCurrentInstance().addMessage(null, message);
				FacesContext.getCurrentInstance().getExternalContext().redirect("welcome.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Usuario o Clave Invalidas"));
		}
	}

	public void logout() {
		try {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.invalidate();
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}