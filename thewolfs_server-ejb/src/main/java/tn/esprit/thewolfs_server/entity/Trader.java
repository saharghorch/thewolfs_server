package tn.esprit.thewolfs_server.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Trader implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String first_name;
	private String last_name;
	private String email;
	private String password;
	@Enumerated(EnumType.STRING)
	private Level level;
	@OneToMany(mappedBy="trader")
	private List<Option> options_trader;
	@OneToMany(mappedBy="counterparty")
	private List<Option> options_counterparty;
	@OneToOne
	private Portfolio portfolio;
	@OneToOne
	private Watchlist watchlist;
	@OneToOne
	private Account account;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Level getLevel() {
		return level;
	}
	public void setLevel(Level level) {
		this.level = level;
	}
	public List<Option> getOptions_trader() {
		return options_trader;
	}
	public void setOptions_trader(List<Option> options_trader) {
		this.options_trader = options_trader;
	}
	public List<Option> getOptions_counterparty() {
		return options_counterparty;
	}
	public void setOptions_counterparty(List<Option> options_counterparty) {
		this.options_counterparty = options_counterparty;
	}
	public Portfolio getPortfolio() {
		return portfolio;
	}
	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}
	public Watchlist getWatchlist() {
		return watchlist;
	}
	public void setWatchlist(Watchlist watchlist) {
		this.watchlist = watchlist;
	}
	
	

}
