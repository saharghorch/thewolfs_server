package tn.esprit.thewolfs_server.presentation.mbeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.thewolfs_server.entity.Trader;


@ManagedBean
@SessionScoped
public class VariabeGlobale implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Trader  trader;
	
	

	public Trader getTrader() {
		return trader;
	}

	public void setTrader(Trader trader) {
		this.trader = trader;
	}
	

}
