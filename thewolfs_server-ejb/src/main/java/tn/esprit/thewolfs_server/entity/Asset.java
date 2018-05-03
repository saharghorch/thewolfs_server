package tn.esprit.thewolfs_server.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Asset implements Serializable {



	@Override
	public String toString() {
		return "Asset [id=" + id + ", optionStartDate=" + optionStartDate + ", optionExpirationDate="
				+ optionExpirationDate + ", sharesNumber=" + sharesNumber + ", traderSharesNumber=" + traderSharesNumber
				+ ", name=" + name + ", totalValue=" + totalValue + ", sharesValue=" + sharesValue + 
				", stock=" + stock + "]";
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;	
	private Date optionStartDate;
	private Date  optionExpirationDate;
	private  int sharesNumber;
	private int traderSharesNumber;
	private String name;
	private Double totalValue;
	private Double sharesValue;

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


	


	public Date getOptionStartDate() {
		return optionStartDate;
	}

	public void setOptionStartDate(Date optionStartDate) {
		this.optionStartDate = optionStartDate;
	}

	public Date getOptionExpirationDate() {
		return optionExpirationDate;
	}

	public void setOptionExpirationDate(Date optionExpirationDate) {
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


	public Stock getStock() {
		return stock;
	}


	public void setStock(Stock stock) {
		this.stock = stock;
	}



}
