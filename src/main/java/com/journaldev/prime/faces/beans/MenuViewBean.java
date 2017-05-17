package com.journaldev.prime.faces.beans;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "menuViewBean")
@SessionScoped
public class MenuViewBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String orientation = "vertical";
	 
    public String getOrientation() {
        return orientation;
    }
 
    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }
    
    public String getPathHeader(){
    	return "header.jpg";
    }
    
    public void goToBusqueda(){
    	try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("search.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void goToListProducts(){
    	try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("trakingAll.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void goToNewProduct(){
    	try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("paquete.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void goToProduct(){
    	try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("product.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public void goToNewPQR(){
    	try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("PQR.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void goToCalification(){
    	try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("calificanos.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
}
