package tn.esprit.thewolfs_server.presentation.mbeans;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;


import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.primefaces.event.SelectEvent;


import tn.esprit.thewolfs_server.entity.Account;
import tn.esprit.thewolfs_server.entity.Activity;
import tn.esprit.thewolfs_server.entity.Currency;
import tn.esprit.thewolfs_server.services.AccountServiceLocal;
import tn.esprit.thewolfs_server.services.TraderServiceLocal;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

@ManagedBean
@ViewScoped
public class AccountBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@EJB
	private AccountServiceLocal accountServiceLocal;
	@EJB
	private TraderServiceLocal traderServiceLocal;
	private Account account;
	private List<Account> listAccount;
	private List<Account> listAccounntByTrader;
	private List<Account> accountsTrader;
	private Integer idTrader=LoginTraderBean.idTrader;
	private Integer id;
	private Float amount;
	private Currency currency;
	private Activity isActive;
	// Conversion:essential URL structure is built using constants
		public static final String ACCESS_KEY = "160ed6a739be8daf50db668b975a78df";
		public static final String BASE_URL = "http://apilayer.net/api/";
		public static final String ENDPOINT = "live";

		// this object is used for executing requests to the (REST) API
		static CloseableHttpClient httpClient = HttpClients.createDefault();

	public AccountBean() {
		HttpServletRequest request= (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		//idTrader =Integer.parseInt(request.getParameter("id"));
		listAccount = new ArrayList<>();
		listAccounntByTrader = new ArrayList<>();
		accountsTrader = new ArrayList<>();

	
	}

	@PostConstruct
	public void intialize() {
		HttpServletRequest request= (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		//idTrader =Integer.parseInt(request.getParameter("id"));
		listAccount = accountServiceLocal.displayAllAccounts();
		accountsTrader = accountServiceLocal.findAllAccountByTrader(idTrader);
		listAccounntByTrader=accountServiceLocal.findActiveAccountByTrader(idTrader);
	

	}

	public void addAccount() {
		HttpServletRequest request= (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		//idTrader =Integer.parseInt(request.getParameter("id"));
		Account newAccount = new Account();
		newAccount.setAmount(amount);
		newAccount.setCurrency(currency);
		newAccount.setIsActive(isActive);

		// Affecter Trader
		
		newAccount.setTrader(traderServiceLocal.findTraderById(idTrader));
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
	public void validateAccount(){
		HttpServletRequest request= (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		idTrader =Integer.parseInt(request.getParameter("id"));
		Float newAmount=amount-500;
		Account newAccount=new Account(newAmount, currency, isActive);
		newAccount.setId(id);
		newAccount.setTrader(traderServiceLocal.findTraderById(idTrader));
		accountServiceLocal.updateAccount(newAccount);
	}
	
	

	public void updateAccount() {
		HttpServletRequest request= (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		//idTrader =Integer.parseInt(request.getParameter("id"));
		Account newAccount = new Account();
		newAccount.setId(id);
		newAccount.setAmount(amount);
		newAccount.setCurrency(currency);
		newAccount.setIsActive(isActive);
		// Affecter Trader
		newAccount.setTrader(traderServiceLocal.findTraderById(idTrader));
		accountServiceLocal.updateAccount(newAccount);
		reset();
	}

	public void deleteAccount(Integer id) {
		accountServiceLocal.removeAccount(id);
	}

	public void updateAmount(Account newAccount) throws IOException {
		HttpServletRequest request= (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		//idTrader =Integer.parseInt(request.getParameter("id"));
		Float newAmount=0.0f ;
		String message="";
		if(newAccount.getCurrency().equals(Currency.EUR)){
			 newAmount = (float) (newAccount.getAmount() - StockOptionBean.priceOptionStatic);
			 message=newAmount.toString()+" EUR";
		}
		if(newAccount.getCurrency().equals(Currency.USD)){
			// Conversion EUR/USD et refaire le même traitement précédent
						HttpGet get = new HttpGet(BASE_URL + ENDPOINT + "?access_key=" + ACCESS_KEY);
						CloseableHttpResponse response;

						response = httpClient.execute(get);
						HttpEntity entity = response.getEntity();
						JSONObject exchangeRates = new JSONObject(EntityUtils.toString(entity));
						Double usdeur = exchangeRates.getJSONObject("quotes").getDouble("USDEUR");
						response.close();
						Double conversion = 1 / usdeur;
						Float lastAmount = newAccount.getAmount();
						 newAmount = (float) (lastAmount - (StockOptionBean.priceOptionStatic * conversion));
						 message=newAmount.toString()+" USD";
						
		}
		newAccount.setId(newAccount.getId());
		newAccount.setCurrency(newAccount.getCurrency());
		newAccount.setIsActive(newAccount.getIsActive());
		newAccount.setTrader(newAccount.getTrader());
		newAccount.setAmount(newAmount);
		accountServiceLocal.updateAccount(newAccount);
		SendMail mail = new SendMail();
		mail.send(traderServiceLocal.findTraderById(idTrader).getEmail(),message);
	
	}

	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
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

	public Account getAccountById(Integer id) {
		return accountServiceLocal.displayAccountById(id);
	}

	public AccountServiceLocal getAccountServiceLocal() {
		return accountServiceLocal;
	}

	public void setAccountServiceLocal(AccountServiceLocal accountServiceLocal) {
		this.accountServiceLocal = accountServiceLocal;
	}

	public List<Account> getListAccounntByTrader() {
	
		return accountServiceLocal.findActiveAccountByTrader(idTrader);
	}

	public void setListAccounntByTrader(List<Account> listAccounntByTrader) {
		this.listAccounntByTrader = listAccounntByTrader;
	}



	public List<Account> getAccountsTrader() {
		return accountServiceLocal.findAllAccountByTrader(idTrader);
	}

	public void setAccountsTrader(List<Account> accountsTrader) {
		this.accountsTrader = accountsTrader;
	}

	public TraderServiceLocal getTraderServiceLocal() {
		return traderServiceLocal;
	}

	public void setTraderServiceLocal(TraderServiceLocal traderServiceLocal) {
		this.traderServiceLocal = traderServiceLocal;
	}

	public Integer getIdTrader() {
		/* HttpServletRequest request= (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		 return Integer.parseInt(request.getParameter("id"));*/
		return idTrader;
	}

	public void setIdTrader(Integer idTrader) {
		this.idTrader = idTrader;
	}
	
	

}
