package tn.esprit.thewolfs_server.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.thewolfs_server.entity.Account;

import tn.esprit.thewolfs_server.entity.Options;
import tn.esprit.thewolfs_server.entity.Portfolio;
import tn.esprit.thewolfs_server.entity.StockOption;

@Remote
public interface PortfolioServiceRemote {
	public int addPortfolio(Portfolio portfolio);
	public void updatePortfolio(Portfolio portfolio);
	public void removePortfolio(int idPortfolio);
	public Portfolio displayPortfolioById(Integer idPortfolio);
	public List<Portfolio> displayAllPortfolios();
	public Integer getIdTraderByPortfolioId(Integer idPortfolio);
	public List<Portfolio> findPortfolioByCash(Float cashPortfolio);
	public Portfolio findPortfolioById(int idPortfolio);
	public void assignPortfolioToTrader(Integer idTrader,Integer idPortfolio);
	public Portfolio getPortfolioById(Integer portfolioId);
	public List<Options> findAllOptionsByTrader(Integer traderId);
	public List<StockOption> findStockOptionsValid();
	

}
