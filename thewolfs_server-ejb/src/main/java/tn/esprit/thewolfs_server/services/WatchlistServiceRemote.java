package tn.esprit.thewolfs_server.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.thewolfs_server.entity.Account;
import tn.esprit.thewolfs_server.entity.Asset;
import tn.esprit.thewolfs_server.entity.Options;
import tn.esprit.thewolfs_server.entity.Portfolio;
import tn.esprit.thewolfs_server.entity.Type;
import tn.esprit.thewolfs_server.entity.Watchlist;

@Remote
public interface WatchlistServiceRemote {
	public void addWatchlist(Watchlist watchlist);
	public void updateOptions(Options option);
	public void deleteWatchlist(int Watchlist_id);
	public Watchlist displayWatchlistById(Integer id);
	public List<Watchlist> displayAllWatchlists();
	public Options getOptionById(int id);
	public Account getAccountById(Integer id_account);
	public Integer getIdPortByTrader(Integer idTrader);
	public Integer getAccountbyTrader(Integer Traderid);
	public Double calcultimevalue(int Watchlist_id);
	public List<Options> findOptionsOnHold();
	public void calculprobabilite(int Option_id);
	public void evaluer(int Options_id);
	public int findportfoliobyop(int Option_id);
	public  Float findCash(int Portfolio_id);
	public Integer getPortfoliobyTrader(Integer Traderid);
	public void AffecterOptionAPortfolio(int op_id,int p_id);
	public List<Portfolio> findPortfolioById(int  p_id);
public void Updateopport (int id_op,Integer id_port);
	//public Float FindAmount(int Trader_id);
	
	
	

}
