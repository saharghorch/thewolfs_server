package tn.esprit.thewolfs_server.presentation.mbeans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


import tn.esprit.thewolfs_server.entity.Trader;
import tn.esprit.thewolfs_server.services.TraderService;
import tn.esprit.thewolfs_server.services.TraderServiceLocal;



@ManagedBean
@SessionScoped
public class LoginTraderBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Trader trader;
	private Trader TraderCurrent;
	
	private String message;
	
	public LoginTraderBean() {

	}
	@PostConstruct
	public void initModel() {
		trader = new Trader();
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@EJB
	TraderServiceLocal service;

	public Trader getTrader() {
		return trader;
	}

	public void setTrader(Trader trader) {
		this.trader = trader;
	}
	
	
	public String DoLogin(){
		String navigateTo=null;		
		trader=service.login(trader.getEmail(), trader.getPassword());
				if (trader!=null){
<<<<<<< HEAD
			 navigateTo="/SPACE-TRADER/homeTrader?faces-redirect=true";	
=======

			 navigateTo="/homeTrader?faces-redirect=true";	

>>>>>>> branch 'master' of https://github.com/saharghorch/thewolfs_server.git
			 
			 
			 }
				else message="Erreur D'authentification";
				System.out.println(trader+"  Done");
				return navigateTo;
	}
	public String doLogout() {
		String navigateTo=null;
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		navigateTo="/SPACE-TRADER/loginTrader?faces-redirect=true";
		return navigateTo;
	}
	

	
	public Trader getTraderCurrent() {
		return TraderCurrent;
	}

	public void setTraderCurrent(Trader TraderCurrent) {
		TraderCurrent = TraderCurrent;
	}

}