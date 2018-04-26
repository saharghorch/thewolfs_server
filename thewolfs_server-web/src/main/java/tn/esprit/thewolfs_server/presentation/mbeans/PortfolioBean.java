package tn.esprit.thewolfs_server.presentation.mbeans;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.SelectEvent;

import tn.esprit.thewolfs_server.entity.Portfolio;
import tn.esprit.thewolfs_server.services.PortfolioServiceLocal;






@ManagedBean
@ViewScoped
public class PortfolioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@EJB
	private PortfolioServiceLocal portfolioServiceLocal;
	private Portfolio portfolio;
	private List<Portfolio> listPortfolio;
	 
	 
	


public PortfolioBean() {
	listPortfolio=new ArrayList<>();
}	

@PostConstruct
public  void intialize() {
	listPortfolio=portfolioServiceLocal.displayAllPortfolios();
}


public void onRowSelect(SelectEvent event){
	/*options=(Options) event.getObject();
	System.out.println("val options : ="+options.getId());
	watchlistServiceLocal.calculprobabilite(options.getId());
	watchlistServiceLocal.evaluer(options.getId());
	System.out.println("val options-proba : ="+options.getSuccessProbability());
	System.out.println("val options-eval : ="+options.getEvaluation());*/
}

public Portfolio getPortfolio() {
	return portfolio;
}

public void setPortfolio(Portfolio portfolio) {
	this.portfolio = portfolio;
}

public List<Portfolio> getListPortfolio() {
	return listPortfolio;
}

public void setListPortfolio(List<Portfolio> listPortfolio) {
	this.listPortfolio = listPortfolio;
}



}

