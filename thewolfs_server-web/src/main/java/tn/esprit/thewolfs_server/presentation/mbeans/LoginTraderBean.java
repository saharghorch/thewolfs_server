package tn.esprit.thewolfs_server.presentation.mbeans;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import tn.esprit.thewolfs_server.entity.Trader;
import tn.esprit.thewolfs_server.services.TraderServiceLocal;

@ManagedBean
@RequestScoped
public class LoginTraderBean {
	@EJB
	TraderServiceLocal traderServiceLocal;

	private String password;
	private String login;
	private Trader trader;
	private boolean loggedIn;
	
	public String doLogin()
	{
		String navigateTo = "";
		trader = traderServiceLocal.getTraderByEmailAndPassword(login,password);
		if(trader != null )
		{
			navigateTo = "/views/accountAdmin?face-redirect=true";
			loggedIn = true;
		}
		else
		{
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Bad credentials"));
		}
		return navigateTo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Trader getTrader() {
		return trader;
	}

	public void setTrader(Trader trader) {
		this.trader = trader;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
	
}
