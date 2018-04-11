package tn.esprit.thewolfs_server.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.thewolfs_server.entity.Asset;
import tn.esprit.thewolfs_server.entity.Options;
import tn.esprit.thewolfs_server.entity.Type;
import tn.esprit.thewolfs_server.entity.Watchlist;

@Remote
public interface WatchlistServiceRemote {
	public void addWatchlist(Watchlist watchlist);
	public void updateOptions(Options option);
	public void deleteWatchlist(int Watchlist_id);
	public Watchlist displayWatchlistById(Integer id);
	public List<Watchlist> displayAllWatchlists();

	public Double calcultimevalue(int Watchlist_id);
	public List<Options> findOptionsOnHold();
	public void calculprobabilite(int Option_id);
	public void evaluer(int Options_id);
	

}
