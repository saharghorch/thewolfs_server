package tn.esprit.thewolfs_server.presentation.mbeans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import tn.esprit.thewolfs_server.entity.Trader;
import tn.esprit.thewolfs_server.services.TraderServiceLocal;

@ManagedBean
@SessionScoped
public class LoginTraderBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	TraderServiceLocal traderServiceLocal;
	private Trader trader;
	private String login;
	private String password;
	public static Integer idTrader;

	public LoginTraderBean() {
		trader = new Trader();
	}

	@PostConstruct
	public void initModel() {	
	}

	public String doLogin() {
		String navigateTo = null;
		trader = traderServiceLocal.login(login,password);
		
		if (trader != null) {
			navigateTo="/SPACE-TRADER/homeTrader?faces-redirect=true&id=" + trader.getId();
	
		}
		idTrader=trader.getId();
		return navigateTo;
	}
	
	public String showPortfolio(){
		String navigateTo = null;
		trader = traderServiceLocal.login(login,password);
		if (trader != null) {
			navigateTo="/SPACE-TRADER/portfolio?faces-redirect=true&id=" + trader.getId();
	
		}

		return navigateTo;
		
	}

	public String doLogout() {
		String navigateTo = null;
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		navigateTo = "/SPACE-TRADER/loginTrader?faces-redirect=true";
		return navigateTo;
	}

	public TraderServiceLocal getTraderServiceLocal() {
		return traderServiceLocal;
	}

	public void setTraderServiceLocal(TraderServiceLocal traderServiceLocal) {
		this.traderServiceLocal = traderServiceLocal;
	}

	public Trader getTrader() {
		return trader;
	}

	public void setTrader(Trader trader) {
		this.trader = trader;
	}


	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
