package tn.esprit.thewolfs_server.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Asset implements Serializable {



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;	
	private java.sql.Date optionStartDate;
	private java.sql.Date  optionExpirationDate;
	private  int sharesNumber;
	private int traderSharesNumber;
	private String name;
	private Double totalValue;
	private Double sharesValue;

	@OneToMany(mappedBy="asset")
	

	private List<Options> options;
	@ManyToOne
	private Stock stock;
	
	
	
	
	public Asset() {
		super();
	}

	public Asset(java.sql.Date optionStartDate, java.sql.Date optionExpirationDate, int sharesNumber) {
		super();
		this.optionStartDate = optionStartDate;
		this.optionExpirationDate = optionExpirationDate;
		this.sharesNumber = sharesNumber;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public java.sql.Date getOptionStartDate() {
		return optionStartDate;
	}


	public void setOptionStartDate(java.sql.Date optionStartDate) {
		this.optionStartDate = optionStartDate;
	}


	public java.sql.Date getOptionExpirationDate() {
		return optionExpirationDate;
	}


	public void setOptionExpirationDate(java.sql.Date optionExpirationDate) {
		this.optionExpirationDate = optionExpirationDate;
	}


	public int getSharesNumber() {
		return sharesNumber;
	}


	public void setSharesNumber(int sharesNumber) {
		this.sharesNumber = sharesNumber;
	}


	public int getTraderSharesNumber() {
		return traderSharesNumber;
	}


	public void setTraderSharesNumber(int traderSharesNumber) {
		this.traderSharesNumber = traderSharesNumber;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Double getTotalValue() {
		return totalValue;
	}


	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}


	public Double getSharesValue() {
		return sharesValue;
	}


	public void setSharesValue(Double sharesValue) {
		this.sharesValue = sharesValue;
	}


	public List<Options> getOptions() {
		return options;
	}


	public void setOptions(List<Options> options) {
		this.options = options;
	}


	public Stock getStock() {
		return stock;
	}


	public void setStock(Stock stock) {
		this.stock = stock;
	}



}
