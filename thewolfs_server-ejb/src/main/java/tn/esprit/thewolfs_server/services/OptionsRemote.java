package tn.esprit.thewolfs_server.services;
import javax.ejb.Remote;

import tn.esprit.thewolfs_server.entity.Asset;
import tn.esprit.thewolfs_server.entity.Options;
import tn.esprit.thewolfs_server.entity.Status;
import tn.esprit.thewolfs_server.entity.Trader;
import tn.esprit.thewolfs_server.entity.Type;

import java.util.Date;
import java.util.List;


@Remote
public interface OptionsRemote {
public int addOption(Options option);
public void deleteOption(int id);
public Options getOptionById(int id);
public void UpdateOptionStatus(int id,Status status);
public List<Options> findAll();
public List<Options> findOptionsValid(Status Valid);
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

}
