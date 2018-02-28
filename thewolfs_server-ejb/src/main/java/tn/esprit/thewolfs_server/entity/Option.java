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
public class Option implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Float premium_price;
	private Float strike_price;
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	
	
	
	

}
