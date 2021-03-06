package tn.esprit.thewolfs_server.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Account implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Float amount;
	@Enumerated(EnumType.STRING)
	private Currency currency;
	@Enumerated(EnumType.STRING)
	private Activity isActive;
	@ManyToOne
	Trader trader;
	
	
	public Account() {
		super();
	}



	public Account(Float amount, Currency currency) {
		super();
		this.amount = amount;
		this.currency = currency;
	}
	
	
	
	

	public Account(Float amount, Currency currency, Activity isActive) {
		super();
		this.amount = amount;
		this.currency = currency;
		this.isActive = isActive;
	}

	public Account(Float amount) {
		super();
		this.amount = amount;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	
	public Activity getIsActive() {
		return isActive;
	}

	public void setIsActive(Activity isActive) {
		this.isActive = isActive;
	}



	public Trader getTrader() {
		return trader;
	}



	public void setTrader(Trader trader) {
		this.trader = trader;
	}



	@Override
	public String toString() {
		return "Account [id=" + id + ", amount=" + amount + ", currency=" + currency + ", isActive=" + isActive
				+ ", trader=" + trader + "]";
	}

	



	}

	
	
	


