package tn.esprit.thewolfs_server.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.thewolfs_server.entity.Asset;
import tn.esprit.thewolfs_server.entity.Watchlist;
@Stateless
public class WatchlistService implements WatchlistServiceRemote,WatchlistServiceLocal {
	
@PersistenceContext(unitName="thewolfs_server-ejb")
EntityManager em;
/*	public WatchlistService() {
		// TODO Auto-generated constructor stub
	}
*/
	@Override
	public void addWatchlist(Watchlist watchlist) {
		em.persist(watchlist);
		
	}
	@Override
	public void updateWatchlist(Watchlist watchlist) {
		em.merge(watchlist);
		
	}
	@Override
	public void deleteWatchlist(int Watchlist_id) {
		Watchlist watchlist=em.find(Watchlist.class,Watchlist_id);
		em.remove(watchlist);
		
	}
	@Override
	public Watchlist displayWatchlistById(Integer id) {
		TypedQuery<Watchlist> query=em.createQuery("SELECT c FROM Watchlist c WHERE c.id= :id",Watchlist.class);
		
		return query.setParameter("id", id).getSingleResult();
	}
	@Override
	public List<Watchlist> displayAllWatchlists() {
		TypedQuery<Watchlist> query=em.createQuery("SELECT c FROM Watchlist c",Watchlist.class);
		return (query.getResultList());
	}
	
	
    

}
