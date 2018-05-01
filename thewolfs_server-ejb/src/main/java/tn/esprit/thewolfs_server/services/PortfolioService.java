package tn.esprit.thewolfs_server.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import tn.esprit.thewolfs_server.entity.Options;
import tn.esprit.thewolfs_server.entity.Portfolio;
import tn.esprit.thewolfs_server.entity.Status;
import tn.esprit.thewolfs_server.entity.StockOption;
import tn.esprit.thewolfs_server.entity.Trader;

@Stateless
public class PortfolioService implements PortfolioServiceRemote, PortfolioServiceLocal {
	@PersistenceContext(unitName = "thewolfs_server-ejb")
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
		Portfolio portfolio = em.find(Portfolio.class, idPortfolio);
		em.remove(portfolio);

	}

	@Override
	public Portfolio displayPortfolioById(Integer idPortfolio) {
		TypedQuery<Portfolio> query = em.createQuery("SELECT c FROM Portfolio c WHERE c.id= :idPortfolio",
				Portfolio.class);
		return query.setParameter("idPortfolio", idPortfolio).getSingleResult();
	}

	@Override
	public List<Portfolio> displayAllPortfolios() {
		TypedQuery<Portfolio> query = em.createQuery("SELECT c FROM Portfolio c", Portfolio.class);
		return (query.getResultList());
	}

	@Override
	public Integer getIdTraderByPortfolioId(Integer idPortfolio) {
		TypedQuery<Integer> query = em
				.createQuery("SELECT c.id from Trader c join c.Portfolio p where p.id=:idPortfolio", Integer.class);
		return (query.setParameter("idPortfolio", idPortfolio).getSingleResult());
	}

	@Override
	public List<Portfolio> findPortfolioByCash(Float cashPortfolio) {
		TypedQuery<Portfolio> query = em.createQuery("SELECT p FROM Portfolio p WHERE p.cash =:cashPortfolio",
				Portfolio.class);
		query.setParameter("cashPortfolio", cashPortfolio);
		return (query.getResultList());
	}

	@Override
	public Portfolio findPortfolioById(int idPortfolio) {
		return (em.find(Portfolio.class, idPortfolio));
	}

	@Override
	public void assignPortfolioToTrader(Integer idTrader, Integer idPortfolio) {
		Trader traderManagedEntity = em.find(Trader.class, idTrader);
		Portfolio portfolioManagedEntity = em.find(Portfolio.class, idPortfolio);
		traderManagedEntity.setPortfolio(portfolioManagedEntity);
	}

	@Override
	public Portfolio getPortfolioById(Integer portfolioId) {
		return em.find(Portfolio.class, portfolioId);
	}

	@Override
	public List<Options> findAllOptionsByTrader(Integer traderId) {
		TypedQuery<Options> query = em
				.createQuery("select DISTINCT o from Options o join o.trader t where t.id=:traderId", Options.class);
		query.setParameter("traderId", traderId);
		return query.getResultList();
	}

	@Override
	public List<StockOption> findStockOptionsValid() {
		TypedQuery<StockOption> query = em.createQuery("select s from StockOption s where s.status=:status",
				StockOption.class);
		Status status = Status.Valid;
		query.setParameter("status", status);
		return query.getResultList();
	}

}
