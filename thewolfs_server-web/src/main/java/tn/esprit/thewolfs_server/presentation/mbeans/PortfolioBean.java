package tn.esprit.thewolfs_server.presentation.mbeans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

import tn.esprit.thewolfs_server.entity.Portfolio;
import tn.esprit.thewolfs_server.entity.StockOption;
import tn.esprit.thewolfs_server.entity.Trader;
import tn.esprit.thewolfs_server.entity.Type;
import tn.esprit.thewolfs_server.services.PortfolioServiceLocal;
import tn.esprit.thewolfs_server.services.PricingLocal;
import tn.esprit.thewolfs_server.services.TraderServiceLocal;

@ManagedBean
@ViewScoped
public class PortfolioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@EJB
	private PortfolioServiceLocal portfolioServiceLocal;
	@EJB
	private TraderServiceLocal traderServiceLocal;
	@EJB
	private PricingLocal pricingLocal;

	private List<StockOption> listStockOption;
	private Portfolio portfolio;
	private List<Portfolio> listPortfolio;
	private Float cash;
	private Date creationDate;

	private Double strikePrice;
	private Date expirationDate;
	private Double premiumPrice;
	private Integer id;
	private String symbole;
	private Double underlyingPrice;
	private Double volatility;
	private Double riskFreeInterestRate;
	private Type type;

	public PortfolioBean() {
		listPortfolio = new ArrayList<>();
		listStockOption = new ArrayList<>();

	}

	@PostConstruct
	public void intialize() {
		listPortfolio = portfolioServiceLocal.displayAllPortfolios();
		listStockOption = portfolioServiceLocal.findStockOptionsValid();
		// Déclaration statique idTrader
		Integer idTrader = 11;
		Trader trader = traderServiceLocal.findTraderById(idTrader);
		portfolio = trader.getPortfolio();
		cash = portfolio.getCash();
		creationDate = portfolio.getCreationDate();

	}

	public void showStockOption(StockOption stockOption) {
		id = stockOption.getId();
		symbole = stockOption.getSymbole();
		underlyingPrice = stockOption.getUnderlyingPrice();
		volatility = stockOption.getVolatility();
		riskFreeInterestRate = stockOption.getRiskFreeInterestRate();
		type = stockOption.getType();

	}

	public void pricingOption() {
		Calendar cal = Calendar.getInstance();
		Date todayDate = cal.getTime();
		long z = pricingLocal.getDateDiff(todayDate, expirationDate, TimeUnit.DAYS);
		Double timeToExpiration = (double) z / 365;

		if (type.equals(Type.Call)) {
			premiumPrice = pricingLocal.CallOptionPrice(underlyingPrice, strikePrice, volatility, riskFreeInterestRate,
					timeToExpiration);
		} else {
			premiumPrice = pricingLocal.PutOptionPrice(underlyingPrice, strikePrice, volatility, riskFreeInterestRate,
					timeToExpiration);
		}

	}

	public void onDateSelect(SelectEvent event) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		facesContext.addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
	}

	public void click() {
		PrimeFaces.current().ajax().update("form:display");
		PrimeFaces.current().executeScript("PF('dlg').show()");
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

	public PortfolioServiceLocal getPortfolioServiceLocal() {
		return portfolioServiceLocal;
	}

	public void setPortfolioServiceLocal(PortfolioServiceLocal portfolioServiceLocal) {
		this.portfolioServiceLocal = portfolioServiceLocal;
	}

	public TraderServiceLocal getTraderServiceLocal() {
		return traderServiceLocal;
	}

	public void setTraderServiceLocal(TraderServiceLocal traderServiceLocal) {
		this.traderServiceLocal = traderServiceLocal;
	}

	public Float getCash() {
		return cash;
	}

	public void setCash(Float cash) {
		this.cash = cash;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public List<StockOption> getListStockOption() {
		return portfolioServiceLocal.findStockOptionsValid();
	}

	public void setListStockOption(List<StockOption> listStockOption) {
		this.listStockOption = listStockOption;
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

	public Double getPremiumPrice() {
		return premiumPrice;
	}

	public void setPremiumPrice(Double premiumPrice) {
		this.premiumPrice = premiumPrice;
	}

}
