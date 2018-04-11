package tn.esprit.thewolfs_server.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class StockOption implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Double premiumPrice;
	private Double strikePrice;
	private Double underlyingPrice;
	private Double volatility;
	private Double riskFreeInterestRate;
	private String symbole;
	@Temporal(TemporalType.DATE)
	private Date expirationDate ;
	@Enumerated(EnumType.STRING)
	private Type type;
	@Enumerated(EnumType.STRING)
	private Status status;
	@ManyToOne
	private Trader trader;
	@ManyToOne
	private Trader counterparty;
    @ManyToOne
	private Portfolio portfolio;
	
    public StockOption() {
		super();
	}

	public StockOption(Double premiumPrice, Double strikePrice, Double underlyingPrice, Double volatility,
			Double riskFreeInterestRate, Date expirationDate, Type type) {
		super();
		this.premiumPrice = premiumPrice;
		this.strikePrice = strikePrice;
		this.underlyingPrice = underlyingPrice;
		this.volatility = volatility;
		this.riskFreeInterestRate = riskFreeInterestRate;
		this.expirationDate = expirationDate;
		this.type = type;

	}
	
	



	public StockOption(Double underlyingPrice, Double volatility, Double riskFreeInterestRate, String symbole,
			Type type, Status status) {
		super();
		this.underlyingPrice = underlyingPrice;
		this.volatility = volatility;
		this.riskFreeInterestRate = riskFreeInterestRate;
		this.symbole = symbole;
		this.type = type;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getPremiumPrice() {
		return premiumPrice;
	}

	public void setPremiumPrice(Double premiumPrice) {
		this.premiumPrice = premiumPrice;
	}

	public Double getStrikePrice() {
		return strikePrice;
	}

	public void setStrikePrice(Double strikePrice) {
		this.strikePrice = strikePrice;
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
	
	public String getSymbole() {
		return symbole;
	}

	public void setSymbole(String symbole) {
		this.symbole = symbole;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}


	public Trader getTrader() {
		return trader;
	}

	public void setTrader(Trader trader) {
		this.trader = trader;
	}

	public Trader getCounterparty() {
		return counterparty;
	}

	public void setCounterparty(Trader counterparty) {
		this.counterparty = counterparty;
	}


	public Portfolio getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}

	@Override
	public String toString() {
		return "StockOption [id=" + id + ", premiumPrice=" + premiumPrice + ", strikePrice=" + strikePrice
				+ ", underlyingPrice=" + underlyingPrice + ", volatility=" + volatility + ", riskFreeInterestRate="
				+ riskFreeInterestRate + ", expirationDate=" + expirationDate + ", type=" + type + ", status=" + status
				+ "]";
	}



	
	
		
	
	
	
	
	


}

