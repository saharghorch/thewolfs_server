
package tn.esprit.thewolfs_server.presentation.mbeans;

import java.io.Serializable;
import java.security.cert.PKIXRevocationChecker.Option;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import tn.esprit.thewolfs_server.entity.Account;
import tn.esprit.thewolfs_server.entity.Options;
import tn.esprit.thewolfs_server.entity.Status;
import tn.esprit.thewolfs_server.entity.Type;
import tn.esprit.thewolfs_server.services.OptionsLocal;

@ManagedBean
@ViewScoped
public class OptionsBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@EJB
	private OptionsLocal optionsLocal;
	private Options options;
	private List<Options> listOptions;
	private List<Options> listOptionss;
	private List<Options> mylistOptions;
	private List<Options> mylistOptionsEx;
	private List<Options> listOptionsAdmin;
	private Integer id;
	private Double premiumPrice;
	private Double strikePrice;
	private Double stockPrice;
	private Status status;
	private Type type;
	private Date date;
	private static int id_trader_co= 35;
    private boolean disable=true;
    private String result;

	public OptionsBean() {
		listOptions = new ArrayList<>();
		listOptionss = new ArrayList<>();
		mylistOptions = new ArrayList<>();
		mylistOptionsEx = new ArrayList<>();
		listOptionsAdmin = new ArrayList<>();
	   
		
		
	}

	@PostConstruct
	public void intialize() {
		listOptions = optionsLocal.findOptionsValidSold(Status.Valid);
		listOptionss = optionsLocal.findOptionsValid(Status.Valid, id_trader_co);
	    mylistOptions = optionsLocal.findOptionsByTrader(id_trader_co);
	    mylistOptionsEx = optionsLocal.findOptionsExerced(id_trader_co);
	    listOptionsAdmin = optionsLocal.findAll();

	}
	public void addOption() {
		Options newOption = new Options();
		newOption.setTrader(optionsLocal.findTraderById(id_trader_co));
		newOption.setPremium_price(premiumPrice);
		newOption.setStrike_price(strikePrice);
		newOption.setStatus(status);
		newOption.setType(type);
		newOption.setStock_price(stockPrice);
	    newOption.setExpiration_date(date);
	    newOption.setExerce(0);
	    newOption.setStatus(status.Valid);
		optionsLocal.addOption(newOption);
		reset();
	}

	public void reset() {
		premiumPrice = 0.0d;
		strikePrice=0.0d;
	}
	
	public void modifierOption(Options option) {
		id = option.getId();
	    status=option.getStatus();
	}

	public void updateOption() {
		optionsLocal.UpdateOptionStatus(id, status);
		reset();
	}

	public void deleteOption(Integer id) {
		optionsLocal.deleteOption(id);
		
	}
	public void chooseOption(Options option) {
		id = option.getId();  
	}
	public void buyOption(Options option)
	{
	optionsLocal.UpdateOptionCounterparty(option.getId(),optionsLocal.findTraderById(id_trader_co));
	float a;
	a = optionsLocal.FindAmountTrader(id_trader_co);
	float b;
	b = optionsLocal.FindAmountTrader(option.getTrader().getId());
	float am = (float) (a- option.getPremium_price());
	optionsLocal.UpdateAmount(optionsLocal.FindAccount(id_trader_co).getId(), am);
	float amm = (float) (b+ option.getPremium_price());
	optionsLocal.UpdateAmount(optionsLocal.FindAccount(option.getTrader().getId()).getId(), amm);
	
	}
	
	public List<Options> meAsTrader()
	{
		mylistOptions=optionsLocal.findOptionsByTrader(id_trader_co);
		 return mylistOptions;
	}
	public List<Options> meAsCounterparty()
	{
		mylistOptions=optionsLocal.findOptionsByCounterparty(id_trader_co);
		return  mylistOptions;
	}	
	public Float myAmount()
	{
		Float a;
		a = optionsLocal.FindAmountTrader(id_trader_co);
		return a;
	}
	
    public String TimeToExp(Date d)
    {
	String s;
	s = optionsLocal.TimeToExpiry(d);
	if (Integer.parseInt(s)>0)
	{
	return s;
	}
	else 
	{
		return "Expired";
	}
    }
    public String result(Options option)
    {
    	if (TimeToExp(option.getExpiration_date())== "Expired")
    	{
    	String r;
    	r=optionsLocal.Result(option.getType(), option.getPremium_price().floatValue(), option.getStrike_price().floatValue(), option.getStock_price().floatValue());
    	optionsLocal.UpdateOptionResult(option.getId(), r);
    	return r;
    	}
    	else
    	{
    		optionsLocal.UpdateOptionResult(option.getId(), "In progress");
    		return "In progress";
    	}
    }
    public void exerceOption(Options option)
    {
    	float f ;
    	f= optionsLocal.ExerceOption(option.getType(), option.getPremium_price().floatValue(), option.getStrike_price().floatValue(), option.getStock_price().floatValue());
    	float a;
    	a = optionsLocal.FindAmountTrader(id_trader_co);
    	float b;
    	b = optionsLocal.FindAmountTrader(option.getTrader().getId());
    	float am =a+f;
    	optionsLocal.UpdateAmount(optionsLocal.FindAccount(id_trader_co).getId(), am);
    	float amm = b-f;
    	optionsLocal.UpdateAmount(optionsLocal.FindAccount(option.getTrader().getId()).getId(), amm);
    	optionsLocal.UpdateEx(option.getId());
    }
    public String buyOrNot (Options option)
    {
    	String s;
    	if(option.getTrader().getId()== id_trader_co)
    	{
    		s="It's your option!";
    				return s;
    	}
    	else if (option.getPremium_price()> optionsLocal.FindAmountTrader(id_trader_co))
    	{
    		s = "you haven't enough money!";
    				return s;
    	}
    	else
    	{
    		s="you can buy it :)";
    				return s;
    	}
    }
    
    public void warn() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Watch out for PrimeFaces."));
    }
    
	public Options getOption() {
		return options;
	}

	public void setOption(Options options) {
		this.options = options;
	}

	public List<Options> getListOptions() {
		return optionsLocal.findOptionsValidSold(status.Valid);
	}

	public void setListOptions(List<Options> listOptions) {
		this.listOptions = listOptions;
	}

	public OptionsLocal getOptionsLocal() {
		return optionsLocal;
	}

	public void setOptionsLocal(OptionsLocal optionsLocal) {
		this.optionsLocal = optionsLocal;
	}

	public Options getOptions() {
		return options;
	}

	public void setOptions(Options options) {
		this.options = options;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getPremiumPrice() {
		return premiumPrice;
	}

	public void setPremiumPrice(Double premiumPrice) {
		this.premiumPrice = premiumPrice;
	}

	public Double getStrikePrice() {
		return strikePrice;
	}

	public void setStrikePrice(Double strikePrice) {
		this.strikePrice = strikePrice;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public List<Options> getMylistOptions() {
		return mylistOptions;
	}

	public void setMylistOptions(List<Options> mylistOptions) {
		this.mylistOptions = mylistOptions;
	}

	public static int getId_trader_co() {
		return id_trader_co;
	}

	public static void setId_trader_co(int id_trader_co) {
		OptionsBean.id_trader_co = id_trader_co;
	}

	public List<Options> getListOptionss() {
		return optionsLocal.findOptionsValid(Status.Valid, id_trader_co);
	}

	public void setListOptionss(List<Options> listOptionss) {
		this.listOptionss = listOptionss;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}



	public boolean isDisable() {
		return disable;
	}

	public void setDisable(boolean disable) {
		this.disable = disable;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Double getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(Double stockPrice) {
		this.stockPrice = stockPrice;
	}

	public List<Options> getMylistOptionsEx() {
		return optionsLocal.findOptionsExerced(id_trader_co);
	}

	public void setMylistOptionsEx(List<Options> mylistOptionsEx) {
		this.mylistOptionsEx = mylistOptionsEx;
	}

	public List<Options> getListOptionsAdmin() {
		return  optionsLocal.findAll();
	}

	public void setListOptionsAdmin(List<Options> listOptionsAdmin) {
		this.listOptionsAdmin = listOptionsAdmin;
	}
	

	
	

	

}
