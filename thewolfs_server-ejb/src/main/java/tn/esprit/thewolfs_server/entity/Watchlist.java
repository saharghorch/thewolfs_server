package tn.esprit.thewolfs_server.entity;

import java.io.Serializable;

import javax.persistence.Entity;

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
	private Double premium_price;
	private Double strike_price;
	
   @OneToOne(mappedBy="watchlist")
   private Trader trader;
   
   
public Watchlist() {
	super();
}









public Watchlist(String evaluation, Double premium_price, Double strike_price, Trader trader) {
	super();
	this.evaluation = evaluation;
	this.premium_price = premium_price;
	this.strike_price = strike_price;
	this.trader = trader;
}






public Watchlist(String evaluation, Double premium_price, Double strike_price) {
	super();
	this.evaluation = evaluation;
	this.premium_price = premium_price;
	this.strike_price = strike_price;
}









public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Trader getTrader() {
	return trader;
}
public void setTrader(Trader trader) {
	this.trader = trader;
}


public String getEvaluation() {
	return evaluation;
}




public void setEvaluation(String evaluation) {
	this.evaluation = evaluation;
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






   
}
