package tn.esprit.thewolfs_server.presentation.mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;

import tn.esprit.thewolfs_server.entity.Options;
import tn.esprit.thewolfs_server.services.WatchlistServiceLocal;

@ManagedBean
@ViewScoped
public class WatchlistBean implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private WatchlistServiceLocal watchlistServiceLocal;
	 public Options options ;
	 public List<Options> listOptions;
	 
	 
	


public WatchlistBean() {
	listOptions=new ArrayList<>();
}	

@PostConstruct
public  void intialize() {
	System.out.println("DebutInitialize");
	listOptions=watchlistServiceLocal.findOptionsOnHold();
}


public void onRowSelect(SelectEvent event){
	System.out.println("debut");
	
	options=(Options) event.getObject();
	System.out.println("val options : ="+options.getId());
	watchlistServiceLocal.calculprobabilite(options.getId());
	watchlistServiceLocal.evaluer(options.getId());
	System.out.println("val options-proba : ="+options.getSuccessProbability());
	System.out.println("val options-eval : ="+options.getEvaluation());
}

public Options getOptions() {
	return options;
}

public void setOptions(Options options) {
	this.options = options;
}

public List<Options> getListOptions() {
	return listOptions;
}

public void setListOptions(List<Options> listOptions) {
	this.listOptions = listOptions;
}
}
