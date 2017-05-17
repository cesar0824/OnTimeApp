package com.journaldev.prime.faces.beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.journaldev.hibernate.data.Paquete;
import com.journaldev.hibernate.data.User;
import com.journaldev.spring.service.PaqueteService;

/**
 * 
 * paquete Managed Bean
 * 
 *
 */
@ManagedBean(name = "productBean")
@SessionScoped
public class ProductBean implements Serializable {

	private static final long serialVersionUID = 1L;

	// Spring paquete Service is injected...
	@ManagedProperty(value = "#{paqueteService}")
	PaqueteService paqueteService;

	Paquete paquete = new Paquete();
	double x;
	double y;
	double z;
	List<Paquete> productoListAll;

	public void setPaqueteService(PaqueteService paqueteService) {
		this.paqueteService = paqueteService;
	}

	public PaqueteService getPaqueteService() {
		return paqueteService;
	}

	public Paquete getPaquete() {
		if (paquete == null) {
			return paquete = new Paquete();
		} else {
			return paquete;
		}
	}

	public void setPaquete(Paquete paquete) {
		this.paquete = paquete;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public static HttpSession getSessionUsingFaces() {
		return (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext()
				.getSession(false);
	}
	
	public List<Paquete> getProductoListAll() {
		if(productoListAll == null){
			HttpSession session = getSessionUsingFaces();
			User user = (User) session.getAttribute("user");
			productoListAll = paqueteService.searchAll(user); 
		}
		return productoListAll;
	}

	public void setProductoListAll(List<Paquete> productoListAll) {
		this.productoListAll = productoListAll;
	}

	public void save() {
		getPaquete().setDimensiones(getX()+"x"+getY()+"x"+getZ());
		paqueteService.save(getPaquete());
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("welcome.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}