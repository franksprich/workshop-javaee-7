package de.punkt.myaktion.controller;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import de.punkt.myaktion.model.Spende;

@SessionScoped
@Named
public class GeldSpendenController implements Serializable {

	private static final long serialVersionUID = -4176100219308970166L;
	private String textColor = "000000";
	private String bgColor = "ffffff";
	private Spende spende;
	private Long aktionId;
	
	@Inject
	FacesContext facesContext;
	
	@Inject
	Logger logger;
	
	@PostConstruct
	public void init(){
		this.spende = new Spende();
	}
	
//	public GeldSpendenController(){
//		this.spende = new Spende();
//	}

	public String getTextColor() {
		return textColor;
	}

	public void setTextColor(String textColor) {
		this.textColor = textColor;
	}

	public String getBgColor() {
		return bgColor;
	}

	public void setBgColor(String bgColor) {
		this.bgColor = bgColor;
	}

	public Spende getSpende() {
		return spende;
	}

	public void setSpende(Spende spende) {
		this.spende = spende;
	}

	public Long getAktionId() {
		return aktionId;
	}

	public void setAktionId(Long aktionId) {
		this.aktionId = aktionId;
	}
	
	public String doSpende(){
		logger.info(spende.getSpenderName() +" hat " +spende.getBetrag() +" Euro gespendet.");
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Vielen Dank für die Spende", null);
		facesContext.addMessage(null, facesMessage);
		init();
		return Pages.GELD_SPENDEN;
	}
	
}

































