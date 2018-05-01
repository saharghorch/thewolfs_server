package tn.esprit.thewolfs_server.presentation.mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;

import tn.esprit.thewolfs_server.entity.Level;
import tn.esprit.thewolfs_server.entity.Portfolio;
import tn.esprit.thewolfs_server.entity.Trader;
import tn.esprit.thewolfs_server.services.PortfolioServiceLocal;
import tn.esprit.thewolfs_server.services.TraderServiceLocal;

@ManagedBean
@ViewScoped
public class TraderBean implements Serializable{
	private static final long serialVersionUID = 1L;
	@EJB
	private TraderServiceLocal traderServiceLocal;
	private Trader trader;
	private List<Trader> listTrader;
	//Travail Meriem
		@EJB
		private PortfolioServiceLocal portfolioServiceLocal;
	
	private Integer id;
	private String first_name;
	private String last_name;
	private String email;
	private String password;
	private Float solde;	
	private Level level;
	private Portfolio portfolio;

	public TraderBean() {
		listTrader=new ArrayList<>();
	}	
	@PostConstruct
	public  void intialize() {
		listTrader=traderServiceLocal.dislayTrader();
	}
	public Trader getTrader() {
		return trader;
	}
	public void setTrader(Trader trader) {
		this.trader = trader;
	}
	public List<Trader> getListTrader() {
		return listTrader;
	}
	public void setListTrader(List<Trader> listTrader) {
		this.listTrader = listTrader;
	}
	public TraderServiceLocal getTraderServiceLocal() {
		return traderServiceLocal;
	}
	public void setTraderServiceLocal(TraderServiceLocal traderServiceLocal) {
		this.traderServiceLocal = traderServiceLocal;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Float getSolde() {
		return solde;
	}
	public void setSolde(Float solde) {
		this.solde = solde;
	}
	public Level getLevel() {
		return level;
	}
	public void setLevel(Level level) {
		this.level = level;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public PortfolioServiceLocal getPortfolioServiceLocal() {
		return portfolioServiceLocal;
	}
	public void setPortfolioServiceLocal(PortfolioServiceLocal portfolioServiceLocal) {
		this.portfolioServiceLocal = portfolioServiceLocal;
	}
	public Portfolio getPortfolio() {
		return portfolio;
	}
	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}
	
	public void addTrader()
	{
		Trader Trader = new Trader();
		Trader.setFirst_name(first_name);
		Trader.setLast_name(last_name);
		Trader.setEmail(email);
		Trader.setLevel(level);
		Trader.setSolde(solde);
		Trader.setPassword(password);
		traderServiceLocal.addTrader(Trader);
		

		//Travail Meriem
	    Portfolio newPortfolio=new Portfolio();
	    newPortfolio.setCash(0.0f);
	    Date creationDate=new Date();
	    newPortfolio.setCreationDate(creationDate);
		portfolioServiceLocal.addPortfolio(newPortfolio);
		Trader.setPortfolio(newPortfolio);
		traderServiceLocal.addTrader(Trader);
		
		first_name="";
		last_name="";
		email="";
		level=null;
		solde=null;
		password="";
		
	        FacesContext.getCurrentInstance().addMessage(null,
	                new FacesMessage("Welcome " + first_name + " " + last_name));
	    
	     
	}
	public void modifierTrader(Trader trader)
	{
		id = trader.getId();
		first_name=trader.getFirst_name();
		last_name=trader.getLast_name();
		email=trader.getEmail();
		password=trader.getPassword();
		level=trader.getLevel();
		solde=trader.getSolde();
		portfolio=trader.getPortfolio();
		//traderServiceLocal.updateTrader(trader);
			
	}
	
	public void updateTrader()
	{
		Trader trader = new Trader();
		trader.setId(id);
		trader.setFirst_name(first_name);
		trader.setLast_name(last_name);
		trader.setEmail(email);
		trader.setLevel(level);
		trader.setSolde(solde);
		trader.setPassword(password);
		trader.setPortfolio(portfolio);
		traderServiceLocal.updateTrader(trader);
		first_name="";
		last_name="";
		email="";
		level=null;
		solde=null;
		password="";
	}
	public void deleteTrader(int id)
	{
		traderServiceLocal.deleteTraderById(id);
	}

}
