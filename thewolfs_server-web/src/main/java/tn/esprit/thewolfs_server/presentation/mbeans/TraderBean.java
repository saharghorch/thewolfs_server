package tn.esprit.thewolfs_server.presentation.mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.esprit.thewolfs_server.entity.Trader;
import tn.esprit.thewolfs_server.services.TraderServiceLocal;

@ManagedBean
@ViewScoped
public class TraderBean implements Serializable{
	private static final long serialVersionUID = 1L;
	@EJB
	private TraderServiceLocal traderServiceLocal;
	private Trader trader;
	private List<Trader> listTrader;

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
	

}
