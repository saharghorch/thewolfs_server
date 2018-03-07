package tn.esprit.thewolfs_server.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.thewolfs_server.entity.Asset;
import tn.esprit.thewolfs_server.entity.Watchlist;

@Remote
public interface WatchlistServiceRemote {
	public void addWatchlist(Watchlist watchlist);
	public void updateWatchlist(Watchlist watchlist);
	public void deleteWatchlist(int Watchlist_id);
	public Watchlist displayWatchlistById(Integer id);
	public List<Watchlist> displayAllWatchlists();

}
