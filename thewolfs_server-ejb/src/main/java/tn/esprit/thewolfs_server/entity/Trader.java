package tn.esprit.thewolfs_server.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Trader implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String first_name;
	private String last_name;
	private String email;
	private String password;
	@Enumerated(EnumType.STRING)
	private Level level;

	@OneToMany(mappedBy = "trader")
	private List<Options> options_trader;
	@OneToMany(mappedBy="counterparty")
    private List<Options> options_counterparty;
	@OneToOne
	private Portfolio portfolio;
	@OneToOne(cascade = CascadeType.PERSIST)
	private Watchlist watchlist;
	@OneToMany(mappedBy="trader")
	private List<StatusTrader> allStatus;
	@OneToMany(mappedBy="trader")
	private List<Comment> comments;
	@OneToMany(mappedBy="trader",cascade={CascadeType.PERSIST,
	CascadeType.REMOVE},fetch=FetchType.EAGER)
	private List<Account> accounts;
	private Float solde;
	@OneToMany(mappedBy = "trader")
	private List<StockOption> stockOptionsTrader;
	@OneToMany(mappedBy="counterparty")
    private List<StockOption> stockOptionsCounterparty;

	public Trader() {
		super();
	}


	    public Trader(String first_name, String last_name, String email, String password, Level level, Float solde) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
		this.level = level;
		this.solde = solde;
	}


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
	
	public List<Options> getOptions_trader() {
		return options_trader;
	}

	public void setOptions_trader(List<Options> options_trader) {
		this.options_trader = options_trader;
	}

	public List<Options> getOptions_counterparty() {
		return options_counterparty;
	}

	public void setOptions_counterparty(List<Options> options_counterparty) {
		this.options_counterparty = options_counterparty;
	}

	public List<StatusTrader> getAllStatus() {
		return allStatus;
	}

	public void setAllStatus(List<StatusTrader> allStatus) {
		this.allStatus = allStatus;
	}
	
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	
	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	public Float getSolde() {
		return solde;
	}

	public void setSolde(Float solde) {
		this.solde = solde;
	}

	@Override
	public String toString() {
		return "Trader [first_name=" + first_name + ", last_name=" + last_name + ", email=" + email + ", password="
				+ password + ", level=" + level + "]";
	}

}
