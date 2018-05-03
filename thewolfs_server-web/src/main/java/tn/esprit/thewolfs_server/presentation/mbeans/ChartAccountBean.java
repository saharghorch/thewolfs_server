package tn.esprit.thewolfs_server.presentation.mbeans;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import tn.esprit.thewolfs_server.entity.Account;
import tn.esprit.thewolfs_server.services.AccountServiceLocal;


@ManagedBean
public class ChartAccountBean implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private LineChartModel animatedModel1;
	private BarChartModel animatedModel2;
	 @EJB
		private AccountServiceLocal accountServiceLocal;
	    private List<Account> accounts;
	 

	    
	    public ChartAccountBean() {
	    	accounts=new ArrayList<>();
		}

	@PostConstruct
	public void init() {
		createAnimatedModels();
		 accounts=accountServiceLocal.displayAllAccounts();
	}

	   public LineChartModel getAnimatedModel1() {
	        return animatedModel1;
	    }
	 
	    public BarChartModel getAnimatedModel2() {
	        return animatedModel2;
	    }

	private void createAnimatedModels() {
		// Modele lineaire
		animatedModel1 = initLinearModel();
        animatedModel1.setTitle("Amount=f(Trader)");
        animatedModel1.setAnimate(true);
        animatedModel1.setLegendPosition("se");
        Axis yAxis = animatedModel1.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(20);
		

		// Modele en BAR
		animatedModel2 = initBarModel();
		animatedModel2.setTitle("Number Account=f(Currency Account)");
		animatedModel2.setAnimate(true);
		animatedModel2.setLegendPosition("ne");
		yAxis = animatedModel2.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(20);
	}

	private BarChartModel initBarModel() {
		BarChartModel model = new BarChartModel();
        String titre="Accounts Currencies";
		
		ChartSeries accountsEur = new ChartSeries();
		accountsEur.setLabel("Currency EUR");
		accountsEur.set(titre,accountServiceLocal.numberAccountEUR() );

		ChartSeries accountsUSD = new ChartSeries();
		accountsUSD.setLabel("Currency USD");
		accountsUSD.set(titre,accountServiceLocal.numberAccountUSD());

		ChartSeries accountsSAR = new ChartSeries();
		accountsSAR.setLabel("Currency SAR");
		accountsSAR.set(titre,accountServiceLocal.numberAccountSAR());

		model.addSeries(accountsEur);
		model.addSeries(accountsUSD);
		model.addSeries(accountsSAR);

		return model;
	}

	 private LineChartModel initLinearModel() {
	        LineChartModel model = new LineChartModel();
	 
	      /*  LineChartSeries amount = new LineChartSeries();
	        amount.setLabel("amount");
	        
	        for (Account account:accounts){
	        	Float amountAccount=account.getAmount();
	        	Integer id=account.getId();
	        	amount.set(id,amountAccount);
	        }*/
	 
	 
	        LineChartSeries series2 = new LineChartSeries();
	        series2.setLabel("Series 2");
	 
	        series2.set(1, 6);
	        series2.set(2, 3);
	        series2.set(3, 2);
	        series2.set(4, 7);
	        series2.set(5, 9);
	 
            //model.addSeries(amount);
	       model.addSeries(series2);
	         
	        return model;
	    }
	
}

