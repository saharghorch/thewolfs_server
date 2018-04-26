package tn.esprit.thewolfs_server.services;

import java.util.List;

import tn.esprit.thewolfs_server.entity.Watchlist;

public interface WatchlistServiceLocal {
	public void addWatchlist(Watchlist watchlist);
	public void updateWatchlist(Watchlist watchlist);
	public void deleteWatchlist(int Watchlist_id);
	public Watchlist displayWatchlistById(Integer id);
	public List<Watchlist> displayAllWatchlists();
}
