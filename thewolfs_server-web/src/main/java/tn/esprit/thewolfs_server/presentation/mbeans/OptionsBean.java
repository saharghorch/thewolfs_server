
package tn.esprit.thewolfs_server.presentation.mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

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
	private Integer id;
	private Double premiumPrice;
	private Double strikePrice;
	private Status status;
	private Type type;

	public OptionsBean() {
		listOptions = new ArrayList<>();
	}

	@PostConstruct
	public void intialize() {
		listOptions = optionsLocal.displayAllOptions();

	}
	public void addOption() {
		Options newOption = new Options();
		newOption.setPremium_price(premiumPrice);
		newOption.setStrike_price(strikePrice);
		newOption.setStatus(status);
		newOption.setType(type);
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

	

	public Options getOption() {
		return options;
	}

	public void setOption(Options options) {
		this.options = options;
	}

	public List<Options> getListOptions() {
		return optionsLocal.displayAllOptions();
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
	

}
