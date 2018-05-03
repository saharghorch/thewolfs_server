package tn.esprit.thewolfs_server.services;

import java.util.List;

import javax.ejb.Remote;
import tn.esprit.thewolfs_server.entity.Asset;


@Remote
public interface AssetServiceRemote {
	public void addAsset(Asset asset);
	public void updateAsset(Asset asset);
	public void deleteAsset(int Asset_id);
	public Asset displayAssetById(Integer id);
	public List<Asset> displayAllAssets();

}
