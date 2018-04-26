package tn.esprit.thewolfs_server.presentation.mbeans;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.SelectEvent;

import tn.esprit.thewolfs_server.entity.StockOption;
import tn.esprit.thewolfs_server.services.StockOptionServiceLocal;






@ManagedBean
@ViewScoped
public class StockOptionBean implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private StockOptionServiceLocal stockOptionServiceLocal;
	 public StockOption stockOption;
	 public List<StockOption> listStockOption;
	 
	 
	


public StockOptionBean() {
	listStockOption=new ArrayList<>();
}	

@PostConstruct
public  void intialize() {
	System.out.println("DebutInitialize");
	listStockOption=stockOptionServiceLocal.displayAllStockOptions();
}


public void onRowSelect(SelectEvent event){
	/*System.out.println("debut");
	options=(Options) event.getObject();
	System.out.println("val options : ="+options.getId());
	watchlistServiceLocal.calculprobabilite(options.getId());
	watchlistServiceLocal.evaluer(options.getId());
	System.out.println("val options-proba : ="+options.getSuccessProbability());
	System.out.println("val options-eval : ="+options.getEvaluation());*/
}

public StockOption getStockOption() {
	return stockOption;
}

public void setStockOption(StockOption stockOption) {
	this.stockOption = stockOption;
}

public List<StockOption> getListStockOption() {
	return listStockOption;
}

public void setListStockOption(List<StockOption> listStockOption) {
	this.listStockOption = listStockOption;
}



}

