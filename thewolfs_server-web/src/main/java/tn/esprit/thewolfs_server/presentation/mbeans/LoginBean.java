package tn.esprit.thewolfs_server.presentation.mbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import Utils.Bourse;
import tn.esprit.thewolfs_server.entity.Trader;
import tn.esprit.thewolfs_server.services.TraderServiceLocal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

@ManagedBean
@ViewScoped

public class LoginBean {
	@EJB
	private TraderServiceLocal traderServiceLocal;
	 @ManagedProperty(value="#{variabeGlobale}")
	 VariabeGlobale variabeGlobale;
	private  String mail;
	private  String pass;
	private Trader trader;
	private List<Bourse> listBourse;
 public LoginBean() {
	 trader=new Trader();
	 listBourse= new ArrayList<>();
	 
	}
	
	
	@PostConstruct
	public void initialize() 
	{}

	public String connexion()
	{
		String navigateTo=null;	
		System.out.println("Dans la methode connexion");
	
    String resultat="out";
    trader=traderServiceLocal.login(mail, pass);

    if(trader !=null)
    {
    	 
    	resultat="In";
    	variabeGlobale.setTrader(trader);
    	navigateTo="/SPACE-TRADER/homeTrader?faces-redirect=true";	
    	
    }
    System.out.println("****"+resultat);
    System.out.println("****"+variabeGlobale.getTrader().getId());
    System.out.println("****"+variabeGlobale.getTrader().getEmail());
    System.out.println("Fin de la methode connexion");
    return navigateTo;
	}
	
	

	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public Trader getTrader() {
		return trader;
	}


	public void setTrader(Trader trader) {
		this.trader = trader;
	}


	public VariabeGlobale getVariabeGlobale() {
		return variabeGlobale;
	}


	public void setVariabeGlobale(VariabeGlobale variabeGlobale) {
		this.variabeGlobale = variabeGlobale;
	}



	public List<Bourse> getListBourse() {
		return listBourse;
	}


	public void setListBourse(List<Bourse> listBourse) {
		this.listBourse = listBourse;
	}
	
	

}
