package tn.esprit.thewolfs_server.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.thewolfs_server.entity.Account;
import tn.esprit.thewolfs_server.entity.Portfolio;

@Remote
public interface PortfolioServiceRemote {
	public int addPortfolio(Portfolio portfolio);
	public void updatePortfolio(Portfolio portfolio);
	public void removePortfolio(int idPortfolio);
	public Portfolio displayPortfolioById(Integer idPortfolio);
	public List<Portfolio> displayAllPortfolios();

}
