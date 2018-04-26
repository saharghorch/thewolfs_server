package tn.esprit.thewolfs_server.services;

import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.thewolfs_server.entity.Account;
import tn.esprit.thewolfs_server.entity.StatusTrader;

@Stateless
public class StatusTraderService implements StatusTraderServiceRemote {
	@PersistenceContext(unitName="thewolfs_server-ejb")
	EntityManager em;
    @Override
	public int addStatusTrader(StatusTrader statusTrader) {
    	em.persist(statusTrader);
		return (statusTrader.getId());
	}

	@Override
	public void updateStatusTrader(StatusTrader statusTrader) {
		em.merge(statusTrader);
	}

	@Override
	public void removeStatusTrader(Integer idStatusTrader) {
		StatusTrader statusTrader=em.find(StatusTrader.class, idStatusTrader);
		em.remove(statusTrader);
		
	}

	@Override
	public List<StatusTrader> displayAllStatus() {
		TypedQuery<StatusTrader> query=em.createQuery("SELECT s FROM StatusTrader s",StatusTrader.class);
		return (query.getResultList());
	}

	@Override
	public StatusTrader findStatusTraderById(Integer idStatusTrader) {
		
		return (em.find(StatusTrader.class, idStatusTrader));
	}

}
