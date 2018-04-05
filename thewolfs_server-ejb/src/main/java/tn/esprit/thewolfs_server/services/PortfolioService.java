package tn.esprit.thewolfs_server.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.thewolfs_server.entity.Account;

import tn.esprit.thewolfs_server.entity.Options;
import tn.esprit.thewolfs_server.entity.Portfolio;

@Stateless
public class PortfolioService implements PortfolioServiceRemote{
	@PersistenceContext(unitName="thewolfs_server-ejb")
	EntityManager em;
	@Override
	public int addPortfolio(Portfolio portfolio) {
		em.persist(portfolio);
		return (portfolio.getId());
	}
	@Override
	public void updatePortfolio(Portfolio portfolio) {
		em.merge(portfolio);
		
	}
	@Override
	public void removePortfolio(int idPortfolio) {
		Portfolio portfolio=em.find(Portfolio.class,idPortfolio);
		em.remove(portfolio);
		
	}
	@Override
	public Portfolio displayPortfolioById(Integer idPortfolio) {
		TypedQuery<Portfolio> query=em.createQuery("SELECT c FROM Portfolio c WHERE c.id= :idPortfolio",Portfolio.class);
		return query.setParameter("idPortfolio", idPortfolio).getSingleResult();
	}
	@Override
	public List<Portfolio> displayAllPortfolios() {
		TypedQuery<Portfolio> query=em.createQuery("SELECT c FROM Portfolio c",Portfolio.class);
		return (query.getResultList());
	}
	@Override
	public Integer getIdTraderByPortfolioId(Integer idPortfolio) {
		TypedQuery<Integer> query=em.createQuery("SELECT c.id from Trader c join c.Portfolio p where p.id=:idPortfolio",Integer.class);
		Integer idTrader=query.setParameter("idPortfolio", idPortfolio).getSingleResult();
	    return idTrader;
	}
	@Override
	public List<Portfolio> findPortfolioByCash(Float cashPortfolio) {
		TypedQuery<Portfolio> query=em.createQuery("SELECT p FROM Portfolio p WHERE p.cash =:cashPortfolio",Portfolio.class);
		query.setParameter("cashPortfolio",cashPortfolio);
		return(query.getResultList());
	}

	

}
