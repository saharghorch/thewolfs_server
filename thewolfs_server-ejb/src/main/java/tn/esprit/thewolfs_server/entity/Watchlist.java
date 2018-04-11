package tn.esprit.thewolfs_server.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Watchlist implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String evaluation;
	private Float premium_price;
	private Float strike_price;
	private Float stock_price;
	private Float time_money;
	private String type;
	private Float volatility;
	private Integer time_to_expiry;
	private Float rate;
	private Float probability;
   @OneToOne(mappedBy="watchlist")
   private Trader trader;
   
   
public Watchlist() {
	super();
}

public Watchlist(String evaluation, Float premium_price, Float strike_price, Trader trader) {
	super();
	this.evaluation = evaluation;
	this.premium_price = premium_price;
	this.strike_price = strike_price;
	this.trader = trader;
}

public Watchlist(String evaluation, Float premium_price, Float strike_price) {
	super();
	this.evaluation = evaluation;
	this.premium_price = premium_price;
	this.strike_price = strike_price;
}

public Watchlist(Float premium_price, Float strike_price, String type) {
	super();
	this.premium_price = premium_price;
	this.strike_price = strike_price;
	this.type = type;
}


public Float getTime_money() {
	return time_money;
}

public void setTime_money(Float time_money) {
	this.time_money = time_money;
}

public Watchlist( Float strike_price, Float stock_price, String type,
		Float volatility, Integer time_to_expiry) {
	super();
	
	this.strike_price = strike_price;
	this.stock_price = stock_price;
	this.type = type;
	this.volatility = volatility;
	this.time_to_expiry = time_to_expiry;

}


public Watchlist( Float strike_price, Float stock_price,
		Float volatility, Integer time_to_expiry, Float rate) {
	super();
	
	this.strike_price = strike_price;
	this.stock_price = stock_price;
	this.volatility = volatility;
	this.time_to_expiry = time_to_expiry;
	this.rate=rate;

}

public Watchlist(String evaluation, Float premium_price, Float strike_price, Float stock_price, Float time_money,
		String type, Float volatility, Integer time_to_expiry, Float probability) {
	super();
	this.evaluation = evaluation;
	this.premium_price = premium_price;
	this.strike_price = strike_price;
	this.stock_price = stock_price;
	this.time_money = time_money;
	this.type = type;
	this.volatility = volatility;
	this.time_to_expiry = time_to_expiry;
	this.probability = probability;
}


public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getEvaluation() {
	return evaluation;
}

public Float getStock_price() {
	return stock_price;
}


public void setStock_price(Float stock_price) {
	this.stock_price = stock_price;
}


public void setEvaluation(String evaluation) {
	this.evaluation = evaluation;
}


public Float getPremium_price() {
	return premium_price;
}

public void setPremium_price(Float premium_price) {
	this.premium_price = premium_price;
}


public Float getStrike_price() {
	return strike_price;
}


public void setStrike_price(Float strike_price) {
	this.strike_price = strike_price;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public Float getVolatility() {
	return volatility;
}


public void setVolatility(Float volatility) {
	this.volatility = volatility;
}

public Integer getTime_to_expiry() {
	return time_to_expiry;
}


public void setTime_to_expiry(Integer time_to_expiry) {
	this.time_to_expiry = time_to_expiry;
}


public Float getRate() {
	return rate;
}

public void setRate(Float rate) {
	this.rate = rate;
}

public Float getProbability() {
	return probability;
}

public void setProbability(Float probability) {
	this.probability = probability;
}

public Trader getTrader() {
	return trader;
}

public void setTrader(Trader trader) {
	this.trader = trader;
}

}
