package tn.esprit.thewolfs_server.presentation.mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;



import tn.esprit.thewolfs_server.entity.StockOption;
import tn.esprit.thewolfs_server.entity.Type;
import tn.esprit.thewolfs_server.services.PricingLocal;
import tn.esprit.thewolfs_server.services.StockOptionServiceLocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;
 
import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

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
	private Double strikePrice;
	private Date expirationDate;
	private Integer id;
	private String symbole;
	private Double underlyingPrice;
	private Double volatility;
	private Double riskFreeInterestRate;
	private Double premiumPrice;
	private Type type;
	private Boolean buyOption;

	public StockOptionBean() {
		listStockOption = new ArrayList<>();
		
	}

	@PostConstruct
	public void intialize() {
		listStockOption = stockOptionServiceLocal.displayAllStockOptions();
		expirationDate=new Date();
		strikePrice=null;
		premiumPrice=null;
	}

	public void showStockOption(StockOption stockOption) {
		id = stockOption.getId();
		symbole = stockOption.getSymbole();
		underlyingPrice = stockOption.getUnderlyingPrice();
		volatility = stockOption.getVolatility();
		riskFreeInterestRate = stockOption.getRiskFreeInterestRate();
		type=stockOption.getType();
		expirationDate=new Date();
		strikePrice=null;
		premiumPrice=null;
		

	}
	
	public void pricingOption(){
		Calendar cal = Calendar.getInstance ();
        Date todayDate = cal.getTime();
  		long z = pricingLocal.getDateDiff(todayDate, expirationDate, TimeUnit.DAYS);
  		Double timeToExpiration = (double) z / 365;
	
		
		if(type.equals(Type.Call)){
			premiumPrice=pricingLocal.CallOptionPrice(underlyingPrice,strikePrice,volatility, riskFreeInterestRate,timeToExpiration);
		}
		else{
			premiumPrice=pricingLocal.PutOptionPrice(underlyingPrice,strikePrice,volatility, riskFreeInterestRate,timeToExpiration);
		}
		
		expirationDate=new Date();
		strikePrice=null;
	
		
	
		
	}
	
	  
    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }
     
    public void click() {
        PrimeFaces.current().ajax().update("form:display");
        PrimeFaces.current().executeScript("PF('dlg').show()");
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

	public Double getPremiumPrice() {
		return premiumPrice;
	}

	public void setPremiumPrice(Double premiumPrice) {
		this.premiumPrice = premiumPrice;
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
	
	  public void destroyWorld() {
	        addMessage("System Error", "Please try again later.");
	    }
	     
	    public void addMessage(String summary, String detail) {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
	        FacesContext.getCurrentInstance().addMessage(null, message);
	    }
	
	

}
