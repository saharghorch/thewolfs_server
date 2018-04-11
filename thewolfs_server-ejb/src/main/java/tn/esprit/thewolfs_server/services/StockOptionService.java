package tn.esprit.thewolfs_server.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.thewolfs_server.entity.StockOption;

@Stateless
public class StockOptionService implements StockOptionServiceRemote{
	@PersistenceContext(unitName="thewolfs_server-ejb")
	EntityManager em;
	@Override
	public int addStockOption(StockOption stockOption) {
		em.persist(stockOption);
		return (stockOption.getId());
	}
	@Override
	public List<StockOption> displayAllStockOptions() {
		TypedQuery<StockOption> query = em.createQuery("SELECT s FROM StockOption s", StockOption.class);
		return (query.getResultList());
	}

}
