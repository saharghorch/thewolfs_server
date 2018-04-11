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
	private Date creationDate;
	private Float cash;
	@OneToOne(mappedBy="portfolio")
	private Trader trader;
	@OneToMany(mappedBy="portfolio")
	private List<Options> allOptions;
	@OneToMany(mappedBy="portfolio")
	private List<StockOption> stockOptions;
	
	public Portfolio() {
		super();
	}
	
	public Portfolio(Date creationDate) {
		super();
this.creationDate = creationDate;}


	
	

	

	public Portfolio(Date creation_date, Float cash) {

		super();
		this.creationDate = creationDate;
		this.cash = cash;

	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
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
	
	public List<StockOption> getStockOptions() {
		return stockOptions;
	}

	public void setStockOptions(List<StockOption> stockOptions) {
		this.stockOptions = stockOptions;
	}

	@Override
	public String toString() {
		return "Portfolio [id=" + id + ", creation_date=" + creationDate + ", cash=" + cash + "]";
	}
	
	

}
