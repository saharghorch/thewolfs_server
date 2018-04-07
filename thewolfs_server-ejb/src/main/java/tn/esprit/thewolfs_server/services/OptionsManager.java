package tn.esprit.thewolfs_server.services;

import javax.ejb.Stateless;
import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.thewolfs_server.entity.Asset;
import tn.esprit.thewolfs_server.entity.Options;
import tn.esprit.thewolfs_server.entity.Portfolio;
import tn.esprit.thewolfs_server.entity.Status;
import tn.esprit.thewolfs_server.entity.Trader;

/*@Stateless
public class OptionsManager implements OptionsRemote {
@PersistenceContext (unitName="thewolfs_server-ejb")

	EntityManager em;
	public  int addOption(Options option) {
	em.persist(option);
		return option.getId();
	}
	@Override
	public void deleteOption(int id) {
		em.remove(em.find(Options.class,id));
	}
	@Override
	public Options getOptionById(int id) {
		
		return em.find(Options.class, id);
	}
	@Override
	public void UpdateOptionStatus(int id) {
		Options option = em.find(Options.class, id);
		option.setStatus(tn.esprit.thewolfs_server.entity.Status.Valid);
		
=======*/
import java.util.List;


@Stateless
public class OptionsManager implements OptionsRemote {
@PersistenceContext (unitName="thewolfs_server-ejb")

	EntityManager em;
	public  int addOption(Options option) {
	em.persist(option);
		return option.getId();
	}
	@Override
	public void deleteOption(int id) {
		em.remove(em.find(Options.class,id));
	}
	@Override
	public Options getOptionById(int id) {
		
		return em.find(Options.class, id);
	}
	
	@Override
	public void UpdateOptionStatus(int id,Status status) {
		Options option = em.find(Options.class, id);
		option.setStatus(status);
		
	}
	@Override
	public List<Options> findAll() {
		TypedQuery<Options> query=em.createQuery("SELECT o FROM Options o",Options.class);
		return (query.getResultList());
		/*String jpql = "select o from Options o";
		Query qry = em.createQuery(jpql, Options.class);
		return qry.getResultList();*/
	}
	@Override
	public List<Options> findOptionsValid(Status Valid) {
		TypedQuery<Options> query=em.createQuery("select o from Options o where o.status='"+ Valid +"'",Options.class);
		return query.getResultList();
	}
	@Override
	public List<Asset> findAssetType() {
		String jpql = "select o from Asset o ";
		TypedQuery qry = em.createQuery(jpql,Asset.class);
		return qry.getResultList();
	}
	@Override
	public Trader findTraderById(int id) {
		String jpql = "select o from Trader o where id = '"+id+"' ";
		TypedQuery qry = em.createQuery(jpql, Trader.class);
		return (Trader) (qry.getResultList()).get(0);
	}
	@Override
	public void UpdateOptionCounterparty(int id, Trader c) {
		
		Options option = em.find(Options.class, id);
		option.setCounterparty(c);
	}
	@Override
	public List<Options> findOptionsByTrader(int id) {
		String jpql = "select o from Options o where o.trader="+id;
		TypedQuery qry = em.createQuery(jpql, Options.class);
		return qry.getResultList();
	}
	@Override
	public List<Options> findOptionsByCounterparty(int id) {
		String jpql = "select o from Options o where o.counterparty="+id;
		TypedQuery qry = em.createQuery(jpql, Options.class);
		return qry.getResultList();
	}
	

}
