package tn.esprit.thewolfs_server.entity;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Interest implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer id;
     private Double principale;
     private Double amount;
     private Double rate;
     private Integer period;
     @Enumerated(EnumType.STRING)
 	 private TypeRate typeRate;
	public Interest() {
	}
	public Interest(Double principale, Double rate, Integer period) {
		super();
		this.principale = principale;
		this.rate = rate;
		this.period = period;
	}
	
	
	public Interest(Double principale, Double rate, Integer period, TypeRate typeRate) {
		super();
		this.principale = principale;
		this.rate = rate;
		this.period = period;
		this.typeRate = typeRate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getPrincipale() {
		return principale;
	}
	public void setPrincipale(Double principale) {
		this.principale = principale;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Double getRate() {
		return rate;
	}
	public void setRate(Double rate) {
		this.rate = rate;
	}
	public Integer getPeriod() {
		return period;
	}
	public void setPeriod(Integer period) {
		this.period = period;
	}
	public TypeRate getTypeRate() {
		return typeRate;
	}
	public void setTypeRate(TypeRate typeRate) {
		this.typeRate = typeRate;
	}
	
	
	}


     
