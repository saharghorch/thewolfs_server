package tn.esprit.thewolfs_server.services;

import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.thewolfs_server.entity.Trader;

@Stateless
public class TraderService implements TraderServiceRemote {

	@PersistenceContext(unitName="thewolfs_server-ejb")
	EntityManager em;
	
	@Override
	public int addTrader(Trader trader) {
		em.persist(trader);
		return trader.getId();
	}

	@Override
	public int updateTrader(Trader trader) {
		em.merge(trader);
		return trader.getId();
	}

	@Override
	public void deleteTraderById(int traderId) {
	Trader trader=em.find(Trader.class, traderId);
	em.remove(trader);
	}

	@Override
	public List<Trader> dislayTrader() {
	TypedQuery<Trader> query = em.createQuery("SELECT c FROM trader as c",Trader.class);
	return  query.getResultList();
	}

}