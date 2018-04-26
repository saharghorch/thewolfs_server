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
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Options implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Double premium_price;
	private Double strike_price;

	@Temporal(TemporalType.DATE)
	private Date expiration_date ;
	@Enumerated(EnumType.STRING)
	private Type type;
	@Enumerated(EnumType.STRING)
	private Status status;
	@ManyToOne
	private User user;
	@ManyToOne
	private Trader trader;
	@ManyToOne
	private Trader counterparty;
	@ManyToOne
    private Asset asset;

	private Double  stock_price;
private Double riskFreeInterestRate;  
    private Double volatility;
	private String evaluation;
	private Double timeMoney;
	private Double successProbability;
    private Integer time_to_expiry;

	@ManyToOne
	private Portfolio portfolio;

	
	public Options() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Options(int id) {
		// TODO Auto-generated constructor stub
		this.id=id;
	}
	
	


	public Options(Type type, Status status, Double stock_price, Double riskFreeInterestRate, Double volatility,
			String evaluation, Double timeMoney, Double successProbability) {
		super();
		this.type = type;
		this.status = status;
		this.stock_price = stock_price;
		this.riskFreeInterestRate = riskFreeInterestRate;
		this.volatility = volatility;
		this.evaluation = evaluation;
		this.timeMoney = timeMoney;
		this.successProbability = successProbability;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Double getPremium_price() {
		return premium_price;
	}


	public void setPremium_price(Double premium_price) {
		this.premium_price = premium_price;
	}


	public Double getStrike_price() {
		return strike_price;
	}


	public void setStrike_price(Double strike_price) {
		this.strike_price = strike_price;
	}




	public Date getExpiration_date() {
		return expiration_date;
	}


	public void setExpiration_date(Date expiration_date) {
		this.expiration_date = expiration_date;
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


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
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


	public Asset getAsset() {
		return asset;
	}


	public void setAsset(Asset asset) {
		this.asset = asset;
	}


	public Double getStock_price() {
		return stock_price;
	}


	public void setStock_price(Double stock_price) {
		this.stock_price = stock_price;
	}


	public Double getRiskFreeInterestRate() {
		return riskFreeInterestRate;
	}


	public void setRiskFreeInterestRate(Double riskFreeInterestRate) {
		this.riskFreeInterestRate = riskFreeInterestRate;
	}


	public Double getVolatility() {
		return volatility;
	}


	public void setVolatility(Double volatility) {
		this.volatility = volatility;
	}


	public String getEvaluation() {
		return evaluation;
	}


	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}


	public Double getTimeMoney() {
		return timeMoney;
	}


	public void setTimeMoney(Double timeMoney) {
		this.timeMoney = timeMoney;
	}


	public Double getSuccessProbability() {
		return successProbability;
	}


	public void setSuccessProbability(Double successProbability) {
		this.successProbability = successProbability;
	}


	public Integer getTime_to_expiry() {
		return time_to_expiry;
	}


	public void setTime_to_expiry(Integer time_to_expiry) {
		this.time_to_expiry = time_to_expiry;
	}


	public Portfolio getPortfolio() {
		return portfolio;
	}


	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}


	@Override
	public String toString() {
		return "Options [id=" + id + ", premium_price=" + premium_price + ", strike_price=" + strike_price
				+ ", expiration_date=" + expiration_date + ", type=" + type + ", status=" + status + ", user=" + user
				+ ", trader=" + trader + ", counterparty=" + counterparty + ", asset=" + asset + "]";
	}

	
	
	
	


}
