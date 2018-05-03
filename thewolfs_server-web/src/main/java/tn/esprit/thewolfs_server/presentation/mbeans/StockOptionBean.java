package tn.esprit.thewolfs_server.presentation.mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import tn.esprit.thewolfs_server.entity.Account;
import tn.esprit.thewolfs_server.entity.StockOption;
import tn.esprit.thewolfs_server.entity.Type;
import tn.esprit.thewolfs_server.services.PricingLocal;
import tn.esprit.thewolfs_server.services.StockOptionServiceLocal;

import java.util.Date;
import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class StockOptionBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private StockOptionServiceLocal stockOptionServiceLocal;
	@EJB
	private PricingLocal pricingLocal;
	private StockOption stockOption;
	private List<StockOption> listStockOption;
	private Double strikePrice=null;
	private Date expirationDate;
	private Integer id;
	private String symbole;
	private Double underlyingPrice;
	private Double volatility;
	private Double riskFreeInterestRate;
	public Double premiumPrice;
	private Type type;
	private Boolean buyOption;
	private String message;
	public static Double priceOptionStatic;

	public StockOptionBean() {
		listStockOption = new ArrayList<>();

	}

	@PostConstruct
	public void intialize() {
		listStockOption = stockOptionServiceLocal.displayAllStockOptions();
		

	}

	public void showStockOption(StockOption stockOption) {
		id = stockOption.getId();
		symbole = stockOption.getSymbole();
		underlyingPrice = stockOption.getUnderlyingPrice();
		volatility = stockOption.getVolatility();
		riskFreeInterestRate = stockOption.getRiskFreeInterestRate();
		type = stockOption.getType();
		premiumPrice=0.0d;
		expirationDate=new Date();

	}

	public void pricingOption(Type typeOption) {
		System.out.println("hi");
		System.out.println("strike price is "+strikePrice+" under"+underlyingPrice+" vol "+volatility+" risk"+riskFreeInterestRate+"exp "+expirationDate);
		 Calendar cal = Calendar.getInstance ();
		 Date todayDate = cal.getTime();
		 long z = pricingLocal.getDateDiff(todayDate, expirationDate,TimeUnit.DAYS);
		 Double timeToExpiration = (double) z / 365;
		 System.out.println("time to expiration " +timeToExpiration);
		
		 if(typeOption.equals(Type.Call)){
			 System.out.println("cest un call");
			 System.out.println("Avant calcul"+"under "+underlyingPrice+"strike "+strikePrice+"vol"+volatility+"risk "+riskFreeInterestRate+"time "+timeToExpiration);
		 premiumPrice=pricingLocal.CallOptionPrice(underlyingPrice,strikePrice,volatility/100,riskFreeInterestRate/100,timeToExpiration);
		 }
		 else{
			 System.out.println("cest un put");
		 premiumPrice=pricingLocal.PutOptionPrice(strikePrice,underlyingPrice,volatility/100,riskFreeInterestRate/100,timeToExpiration);
		 }
		 System.out.println(premiumPrice);
		 priceOptionStatic=premiumPrice;
	

	}

	public String openOther() {
		String navigateTo = null;
		if (premiumPrice != 0) {
			navigateTo = "/SPACE-TRADER/buyOption?faces-redirect=true";

		} else
			message = "Erreur D'authentification";
		System.out.println("  Done: price :" + premiumPrice);
		return navigateTo;
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

	public Double getStrikePrice() {
		return strikePrice;
	}

	public void setStrikePrice(Double strikePrice) {
		this.strikePrice = strikePrice;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public StockOptionServiceLocal getStockOptionServiceLocal() {
		return stockOptionServiceLocal;
	}

	public void setStockOptionServiceLocal(StockOptionServiceLocal stockOptionServiceLocal) {
		this.stockOptionServiceLocal = stockOptionServiceLocal;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSymbole() {
		return symbole;
	}

	public void setSymbole(String symbole) {
		this.symbole = symbole;
	}

	public Double getUnderlyingPrice() {
		return underlyingPrice;
	}

	public void setUnderlyingPrice(Double underlyingPrice) {
		this.underlyingPrice = underlyingPrice;
	}

	public Double getVolatility() {
		return volatility;
	}

	public void setVolatility(Double volatility) {
		this.volatility = volatility;
	}

	public Double getRiskFreeInterestRate() {
		return riskFreeInterestRate;
	}

	public void setRiskFreeInterestRate(Double riskFreeInterestRate) {
		this.riskFreeInterestRate = riskFreeInterestRate;
	}


	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public PricingLocal getPricingLocal() {
		return pricingLocal;
	}

	public void setPricingLocal(PricingLocal pricingLocal) {
		this.pricingLocal = pricingLocal;
	}

	public Boolean getBuyOption() {
		return buyOption;
	}

	public void setBuyOption(Boolean buyOption) {
		this.buyOption = buyOption;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Double getPremiumPrice() {
		return premiumPrice;
	}

	public void setPremiumPrice(Double premiumPrice) {
		this.premiumPrice = premiumPrice;
	}

	public static Double getPriceOptionStatic() {
		return priceOptionStatic;
	}

	public static void setPriceOptionStatic(Double priceOptionStatic) {
		StockOptionBean.priceOptionStatic = priceOptionStatic;
	}
	
	
	
	

}
