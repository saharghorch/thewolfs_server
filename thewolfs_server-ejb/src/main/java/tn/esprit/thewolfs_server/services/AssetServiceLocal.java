package tn.esprit.thewolfs_server.services;

import java.util.List;

import javax.ejb.Local;


import tn.esprit.thewolfs_server.entity.Account;
import tn.esprit.thewolfs_server.entity.Asset;


@Local
public interface AssetServiceLocal {
	public void addAsset(Asset asset);
	public void updateAsset(Asset asset);
	public void deleteAsset(int Asset_id);
	public Asset displayAssetById(Integer id);
	public List<Asset> displayAllAssets();
	public Integer getAccountbyTrader(Integer Traderid);
	public Account getAccountById(Integer id_account);
   public  Double Calcul (Double TotalValue, int SharesNumber, int TraderSharesNumber );

}
