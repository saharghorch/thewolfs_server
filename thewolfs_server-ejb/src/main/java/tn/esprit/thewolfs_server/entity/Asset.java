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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Asset implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	
	private java.sql.Date Option_Start_Date;
	
	private java.sql.Date  Options_Expiration_Date;
	private  int Shares_number;
	@OneToMany(mappedBy="asset")
	

	private List<Options> options;
	@ManyToOne
	private Stock stock;
	
	
	public Asset() {
		super();
	}
	
	public Asset(java.sql.Date option_Start_Date, java.sql.Date options_Expiration_Date, int shares_number
			) {
		super();
		
		Option_Start_Date = option_Start_Date;
		Options_Expiration_Date = options_Expiration_Date;
		Shares_number = shares_number;
		
	}
	
	

	public Asset(int shares_number) {
		super();
		Shares_number = shares_number;
	}

	public java.sql.Date  getOption_Start_Date() {
		return Option_Start_Date;
	}
	public void setOption_Start_Date(java.sql.Date  option_Start_Date) {
		Option_Start_Date = option_Start_Date;
	}
	public java.sql.Date  getOptions_Expiration_Date() {
		return Options_Expiration_Date;
	}
	public void setOptions_Expiration_Date(java.sql.Date  options_Expiration_Date) {
		Options_Expiration_Date = options_Expiration_Date;
	}
	public int getShares_number() {
		return Shares_number;
	}
	public void setShares_number(int shares_number) {
		Shares_number = shares_number;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
