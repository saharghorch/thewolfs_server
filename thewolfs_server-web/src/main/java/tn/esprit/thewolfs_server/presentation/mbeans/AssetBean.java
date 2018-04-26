package tn.esprit.thewolfs_server.presentation.mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.esprit.thewolfs_server.entity.Asset;
import tn.esprit.thewolfs_server.services.AssetServiceLocal;

@ManagedBean
@ViewScoped
public class AssetBean  implements Serializable {
	@EJB
	private AssetServiceLocal assetServiceLocal;
  public Asset asset ;
  public List listAsset; 
	public AssetBean()
	{
	  asset = new Asset();
	  listAsset= new ArrayList<>();
	}
 
@PostConstruct
public void intialize() {

listAsset= assetServiceLocal.displayAllAssets();
}

public void save() {
	
};

public void update() {};

public void delete() {}

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



}