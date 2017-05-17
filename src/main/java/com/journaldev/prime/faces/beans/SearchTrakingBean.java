package com.journaldev.prime.faces.beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.journaldev.hibernate.data.Paquete;
import com.journaldev.hibernate.data.Traking;
import com.journaldev.hibernate.data.User;
import com.journaldev.spring.service.CiudadService;
import com.journaldev.spring.service.PaqueteService;
import com.journaldev.spring.service.TrakingService;

@ManagedBean(name = "searchTrakingBean")
@SessionScoped
public class SearchTrakingBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value = "#{trakingService}")
	TrakingService trakingService;
	
	@ManagedProperty(value = "#{ciudadService}")
	CiudadService ciudadService;
	
	@ManagedProperty(value = "#{paqueteService}")
	PaqueteService paqueteService;
	
	private int traking;
	private List<Traking> trakingList;
    private List<Traking> trakingListAll;
    private List<Paquete> paqueteList;
    
	public TrakingService getTrakingService() {
		return trakingService;
	}
	public void setTrakingService(TrakingService trakingService) {
		this.trakingService = trakingService;
	}
	public int getTraking() {
		return traking;
	}
	public void setTraking(int traking) {
		this.traking = traking;
	}
	public List<Traking> getTrakingList() {
		return trakingList;
	}
	public void setTrakingList(List<Traking> trakingList) {
		this.trakingList = trakingList;
	}
	public List<Traking> getTrakingListAll() {
		if(trakingListAll == null){
			searchAll();
		}
		return trakingListAll;
	}
	public void setTrakingListAll(List<Traking> trakingListAll) {
		this.trakingListAll = trakingListAll;
	}
	public CiudadService getCiudadService() {
		return ciudadService;
	}
	public void setCiudadService(CiudadService ciudadService) {
		this.ciudadService = ciudadService;
	}
	public PaqueteService getPaqueteService() {
		return paqueteService;
	}
	public void setPaqueteService(PaqueteService paqueteService) {
		this.paqueteService = paqueteService;
	}
	public List<Paquete> getPaqueteList() {
		return paqueteList;
	}
	public void setPaqueteList(List<Paquete> paqueteList) {
		this.paqueteList = paqueteList;
	}
	
	public static HttpSession getSessionUsingFaces() {
		return (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext()
				.getSession(false);
	}
	
	public void search(){
		HttpSession session = getSessionUsingFaces();
		User user = (User) session.getAttribute("user");
		setTrakingList(trakingService.search(user, getTraking()));
		if(!getTrakingList().isEmpty()){
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("traking.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "No se obtuvieron resultados"));
		}
	}

	public void searchAll(){
		HttpSession session = getSessionUsingFaces();
		User user = (User) session.getAttribute("user");
		setTrakingListAll(trakingService.searchAll(user));
		if(!getTrakingListAll().isEmpty()){
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Se obtuvieron "+getTrakingListAll().size()));
		}else{
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "No se obtuvieron resultados"));
		}
	}
	
	public String ciudad(int ciudadId){
		Map<Integer, String> map = new HashMap<Integer, String>();
		if(map.isEmpty()){
			map = ciudadService.getCiudadesMap();
		}
		return map.get(ciudadId);
	}
	
	public void detalle(int traking){
		
		String allId = trakingService.searchPaquete(traking);
		setPaqueteList(paqueteService.searchAllId(allId));
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("paqueteDetalle.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
