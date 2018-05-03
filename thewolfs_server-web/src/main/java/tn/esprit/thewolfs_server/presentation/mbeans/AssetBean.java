package tn.esprit.thewolfs_server.presentation.mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import tn.esprit.thewolfs_server.entity.Account;
import tn.esprit.thewolfs_server.entity.Asset;
import tn.esprit.thewolfs_server.entity.Options;
import tn.esprit.thewolfs_server.entity.Trader;
import tn.esprit.thewolfs_server.services.AssetServiceLocal;
import tn.esprit.thewolfs_server.services.WatchlistServiceLocal;

@ManagedBean
@ViewScoped
public class AssetBean implements Serializable {
	@EJB
	private AssetServiceLocal assetServiceLocal;
	@EJB
	private WatchlistServiceLocal watchlistServiceLocal;

	@ManagedProperty(value = "#{variabeGlobale}")
	VariabeGlobale variabeGlobale;
	private Asset asset;
	private List listAsset;
	private Integer id;
	private Date optionStartDate;
	private Date optionExpirationDate;
	private int sharesNumber;
	private int traderShares;
	private String name;
	private Double totalValue;
	private Double sharesValue;
	private Trader trader;
	private Account account;
	private boolean showMessages;

	public AssetBean() {
		asset = new Asset();
		listAsset = new ArrayList<>();
		trader = new Trader();
		account = new Account();

	}

	@PostConstruct
	public void intialize() {

		listAsset = assetServiceLocal.displayAllAssets();
		optionExpirationDate = new Date();
		optionStartDate = new Date();
		showMessages=true;

	}

	public void save() {
		Asset newAsset = new Asset();
		newAsset.setName(name);
		newAsset.setSharesNumber(sharesNumber);
		newAsset.setTotalValue(totalValue);
		newAsset.setOptionExpirationDate(optionExpirationDate);
		newAsset.setOptionStartDate(optionStartDate);
		if(optionExpirationDate.before(optionStartDate)){
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Please enter a valid Date"));	
		}else{
		assetServiceLocal.addAsset(newAsset);
		reset();
		intialize();
		}

	};

	public void reset() {
		totalValue = 0.0d;
		name = "";
		sharesNumber = 0;

	};

	public void modifierAsset(Asset asset) {
		id = asset.getId();
		name = asset.getName();
		sharesNumber = asset.getSharesNumber();
		totalValue = asset.getTotalValue();
		optionExpirationDate = asset.getOptionExpirationDate();
		optionStartDate = asset.getOptionStartDate();

	};

	public void update() {

		asset.setId(id);
		asset.setName(name);
		asset.setSharesNumber(sharesNumber);
		asset.setTotalValue(totalValue);
		asset.setOptionExpirationDate(optionExpirationDate);
		asset.setOptionStartDate(optionStartDate);
		assetServiceLocal.updateAsset(asset);
		intialize();
	};

	public void delete(Integer id) {
		assetServiceLocal.deleteAsset(id);
		intialize();
	};

	public void onRowSelect(SelectEvent event) {
		asset = (Asset) event.getObject();

	}

	public void Calcul()

	{
		Double res = 0d;
		
		if(traderShares>asset.getSharesNumber()){
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","you cannot "));	
		}else{
		res = assetServiceLocal.Calcul(asset.getTotalValue(), asset.getSharesNumber(), traderShares);
		asset.setSharesValue(res);

		assetServiceLocal.updateAsset(asset);
		}
	}

	public void acheter()

	{
		trader = variabeGlobale.getTrader();
		account = watchlistServiceLocal.getAccountById(watchlistServiceLocal.getAccountbyTrader(trader.getId()));
		if(asset.getSharesValue()<=account.getAmount())
		{
			
			asset.setSharesNumber(asset.getSharesNumber()-asset.getTraderSharesNumber());
			account.setAmount((float) (account.getAmount()-asset.getSharesValue()));
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Info","Congratulations ! this asset is bought   , you still have : "+account.getAmount()));
			intialize();
		}else{
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","you cannot buy this asset , you don't have enough money"));		
		}
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

	public int getTraderShares() {
		return traderShares;
	}

	public void setTraderShares(int traderShares) {
		this.traderShares = traderShares;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AssetServiceLocal getAssetServiceLocal() {
		return assetServiceLocal;
	}

	public void setAssetServiceLocal(AssetServiceLocal assetServiceLocal) {
		this.assetServiceLocal = assetServiceLocal;
	}

	public VariabeGlobale getVariabeGlobale() {
		return variabeGlobale;
	}

	public void setVariabeGlobale(VariabeGlobale variabeGlobale) {
		this.variabeGlobale = variabeGlobale;
	}

	public Trader getTrader() {
		return trader;
	}

	public void setTrader(Trader trader) {
		this.trader = trader;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
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

	public Asset getAsset() {
		return asset;
	}

	public void setAsset(Asset asset) {
		this.asset = asset;
	}

	public List getListAsset() {
		return listAsset;
	}

	public void setListAsset(List listAsset) {
		this.listAsset = listAsset;
	}

	public boolean isShowMessages() {
		return showMessages;
	}

	public void setShowMessages(boolean showMessages) {
		this.showMessages = showMessages;
	}

}