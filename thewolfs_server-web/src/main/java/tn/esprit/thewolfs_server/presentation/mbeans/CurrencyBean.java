package tn.esprit.thewolfs_server.presentation.mbeans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import tn.esprit.thewolfs_server.entity.Currency;

@ManagedBean
@ApplicationScoped
public class CurrencyBean {
	public Currency[] getCurrencies(){
		return Currency.values();
	}

}
