package tn.esprit.thewolfs_server.entity;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Portfolio implements Serializable  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Temporal(TemporalType.DATE)
	private Date creation_date;
	private Float cash;
	@OneToOne(mappedBy="portfolio")
	private Trader trader;
	@OneToMany(mappedBy="portfolio")
	private List<Options> allOptions;
	
	
	public Portfolio() {
		super();
	}
	
	public Portfolio(Date creation_date) {
		super();
		this.creation_date = creation_date;}

	public Portfolio(Date creation_date, Float cash) {
		super();
		this.creation_date = creation_date;
		this.cash = cash;

	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}
	
	
	public Float getCash() {
		return cash;
	}


	public void setCash(Float cash) {
		this.cash = cash;
	}


	public Trader getTrader() {
		return trader;
	}
	public void setTrader(Trader trader) {
		this.trader = trader;
	}


	public List<Options> getAllOptions() {
		return allOptions;
	}


	public void setAllOptions(List<Options> allOptions) {
		this.allOptions = allOptions;
	}


	@Override
	public String toString() {
		return "Portfolio [id=" + id + ", creation_date=" + creation_date + ", cash=" + cash + "]";
	}
	
	

}
