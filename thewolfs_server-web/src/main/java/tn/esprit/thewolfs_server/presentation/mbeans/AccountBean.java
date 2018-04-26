package tn.esprit.thewolfs_server.presentation.mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.SelectEvent;

import tn.esprit.thewolfs_server.entity.Account;
import tn.esprit.thewolfs_server.entity.Activity;
import tn.esprit.thewolfs_server.entity.Currency;
import tn.esprit.thewolfs_server.services.AccountServiceLocal;

@ManagedBean
@ViewScoped
public class AccountBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@EJB
	private AccountServiceLocal accountServiceLocal;
	private Account account;
	private List<Account> listAccount;
	private Integer id;
	private Float amount;
	private Currency currency;
	private Activity isActive;

	public AccountBean() {
		listAccount = new ArrayList<>();
	}

	@PostConstruct
	public void intialize() {
		listAccount = accountServiceLocal.displayAllAccounts();
	}

	public void addAccount() {
		Account newAccount = new Account();
		newAccount.setAmount(amount);
		newAccount.setCurrency(currency);
		newAccount.setIsActive(isActive);
		accountServiceLocal.addAccount(newAccount);
		reset();
	}

	public void reset() {
		amount = 0.0f;
	}

	public void modifierAccount(Account account) {
		id = account.getId();
		amount = account.getAmount();
		currency = account.getCurrency();
		isActive = account.getIsActive();
	}

	public void updateAccount() {
		Account newAccount = new Account();
		newAccount.setId(id);
		newAccount.setAmount(amount);
		newAccount.setCurrency(currency);
		newAccount.setIsActive(isActive);
		accountServiceLocal.updateAccount(newAccount);
		reset();
	}

	public void deleteAccount(Integer id) {
		accountServiceLocal.removeAccount(id);
	}

	public void onRowSelect(SelectEvent event) {
		account = (Account) event.getObject();

	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<Account> getListAccount() {
		return accountServiceLocal.displayAllAccounts();
	}

	public void setListAccount(List<Account> listAccount) {
		this.listAccount = listAccount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

}
