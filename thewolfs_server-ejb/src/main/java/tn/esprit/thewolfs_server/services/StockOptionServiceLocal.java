package tn.esprit.thewolfs_server.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.thewolfs_server.entity.StockOption;

@Local
public interface StockOptionServiceLocal {
	public int addStockOption(StockOption stockOption);
	public List<StockOption> displayAllStockOptions();
}
