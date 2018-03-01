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
	@Enumerated(EnumType.STRING)
	private Evaluation evaluation;
	private float potential_gain;
	private float risk_limitation;
	
   @OneToOne(mappedBy="watchlist")
   private Trader trader;
   
   
public Watchlist() {
	super();
}

public Watchlist(Evaluation evaluation, float potential_gain, float risk_limitation) {
	super();
	this.evaluation = evaluation;
	this.potential_gain = potential_gain;
	this.risk_limitation = risk_limitation;
}

public Watchlist(Evaluation evaluation, float potential_gain, Trader trader) {
	super();
	this.evaluation = evaluation;
	this.potential_gain = potential_gain;
	
	this.trader = trader;
	
}


	

public Watchlist(Evaluation evaluation, float potential_gain) {
	super();
	this.evaluation = evaluation;
	this.potential_gain = potential_gain;
}

public Watchlist(Evaluation evaluation) {
	super();
	this.evaluation = evaluation;
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
public Evaluation getEvaluation() {
	return evaluation;
}
public void setEvaluation(Evaluation evaluation) {
	this.evaluation = evaluation;
}
public float getPotential_gain() {
	return potential_gain;
}
public void setPotential_gain(Integer potential_gain) {
	this.potential_gain = potential_gain;
}
public float getRisk_limitation() {
	return risk_limitation;
}
public void setRisk_limitation(float risk_limitation) {
	this.risk_limitation = risk_limitation;
}
public void setPotential_gain(float potential_gain) {
	this.potential_gain = potential_gain;
}

   
}
