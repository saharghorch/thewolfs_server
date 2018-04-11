package tn.esprit.thewolfs_server.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.thewolfs_server.entity.StockOption;


@Remote
public interface StockOptionServiceRemote {
	public int addStockOption(StockOption stockOption);
	public List<StockOption> displayAllStockOptions();
}
