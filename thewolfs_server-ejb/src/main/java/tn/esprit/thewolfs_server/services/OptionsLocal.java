package tn.esprit.thewolfs_server.services;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import tn.esprit.thewolfs_server.entity.Account;
import tn.esprit.thewolfs_server.entity.Asset;
import tn.esprit.thewolfs_server.entity.Options;
import tn.esprit.thewolfs_server.entity.Status;
import tn.esprit.thewolfs_server.entity.Trader;
import tn.esprit.thewolfs_server.entity.Type;

@Local
public interface OptionsLocal {
	public int addOption(Options option);
	public void deleteOption(int id);
	public Options getOptionById(int id);
	public void UpdateOptionStatus(int id,Status status);
	public void UpdateOptionResult(int id,String r);
	public List<Options> findAll();
	public List<Options> findOptionsValid(Status Valid, int id);
	public List<Options> findOptionsValidSold(Status Valid);
	public List<Options> findOptionsByType(Type type);
	public List<Asset> findAssetType();
	public Trader findTraderById(int id);
	public List<Options> findOptionsByTrader(int id);
	public List<Options> findOptionsByCounterparty(int id);
	void UpdateOptionCounterparty(int id, Trader c);
	public String TimeToExpiry (Date d);
	public Float FindAmountTrader (int id);
	public void UpdateAmount(int trader_id, float am);
	public List<Options> displayAllOptions();
	public Account FindAccount(int trader_id);
	public String Result (Type type, float p, float k, float s);
	public String ResultTrader (Type type, float p, float k, float s);
	public Float ExerceOption (Type type, float p, float k, float s);
	public Double SumPremium(int trader_id);
	public void UpdateEx(int id);
	public List<Options> findOptionsExerced (int id);
}
