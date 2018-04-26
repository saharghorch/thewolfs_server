package tn.esprit.thewolfs_server.services;
//import org.apache.commons.math3.distribution.NormalDistribution;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.thewolfs_server.entity.Account;
import tn.esprit.thewolfs_server.entity.Asset;
import tn.esprit.thewolfs_server.entity.Options;
import tn.esprit.thewolfs_server.entity.Portfolio;
import tn.esprit.thewolfs_server.entity.Status;
import tn.esprit.thewolfs_server.entity.Trader;
import tn.esprit.thewolfs_server.entity.Type;
import tn.esprit.thewolfs_server.entity.Watchlist;
@Stateless
public  class WatchlistService implements WatchlistServiceRemote,WatchlistServiceLocal {
	
@PersistenceContext(unitName="thewolfs_server-ejb")
EntityManager em;

	@Override
	public void addWatchlist(Watchlist watchlist) {
		em.persist(watchlist);
		
	}
	@Override
	public void updateOptions(Options options) {
		em.merge(options);
		
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
	
	

	


	@Override
	public List<Options> findOptionsOnHold() {
		TypedQuery<Options> query=em.createQuery("select o from Options o where o.status=:status",Options.class);
		Status status=Status.onHold;
		query.setParameter("status",status);
		return query.getResultList();
	} 


	public long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
		long diffInMillies = date2.getTime() - date1.getTime();
		return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
		}


	
	@Override
	public void calculprobabilite(int Option_id) {
	   
		Options options=em.find(Options.class,Option_id);
		 Double x=options.getStock_price();
		 Double y=options.getStrike_price();
		Double p =(double)0.0;      
		Double log =(double)0.0;
		Double entry =(double)0.0;
	Integer duree = options.getTime_to_expiry();
	
		Double sigma , mu ;
		sigma = (double)1.2;
		mu =(double)2.3;
		
	options.getType();
	if(options.getType() ==options.getType().Call)
	{
	log = Math.log((x/y));
	Double m= options.getVolatility();
	entry=log/(m*Math.sqrt(duree));
	p=1/(sigma*(Math.sqrt(2*Math.PI)))*(Math.exp((-(1/2)*((entry-mu)/sigma)*(entry-mu)/sigma)));
	
	options.setSuccessProbability(p);
	
	}

	else if (options.getType() ==options.getType().Put)
{  
		log = Math.log((x/y));
		entry=log/(options.getVolatility()*Math.sqrt(duree));
		p=1-1/(sigma*(Math.sqrt(2*Math.PI)))*(Math.exp((-(1/2)*((entry-mu)/sigma)*(entry-mu)/sigma)));

		options.setSuccessProbability(p);
		
	}

	
	}

	@Override
	public Double calcultimevalue(int Watchlist_id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void evaluer(int Option_id) {
		Options options=em.find(Options.class,Option_id);
		Double  strike= (double)options.getStrike_price();
		Double stock=(double)options.getStock_price();
		
		String res ;
		res="";
		options.getType();
		if((options.getType() ==options.getType().Call)&&(strike>stock))
		{  
			res="Out The Money";
			options.setEvaluation(res);
			}
		else if ((options.getType() ==options.getType().Call)&&(strike<stock))
		{  
			res="In The Money";
			}
		else if ((options.getType() ==options.getType().Put)&&(strike<stock))
				{  
			res="Out The Money";
			options.setEvaluation(res);
			}
		else if ((options.getType() ==options.getType().Put)&&(strike>stock))
		{  
			res="In The Money";
			options.setEvaluation(res);
			}
		else {  
			res="At The Money";
			options.setEvaluation(res);
			}
		
		
	}
	@Override
	public int findportfoliobyop(int Option_id) {
		String jpql="select o.portfolio from Options o where o.id="+Option_id;
		TypedQuery qry =(TypedQuery) em.createQuery(jpql);
		return (int) qry.getSingleResult();
	}
	@Override
	public Float findCash(int Portfolio_id) {
		String jpql="select o.cash from Portfoli o where o.id="+ Portfolio_id;
		TypedQuery qry =(TypedQuery) em.createQuery(jpql);
		return (Float) qry.getSingleResult(); 		}
	@Override
	public void AffecterOptionAPortfolio(int op_id, int p_id) {
Options optionManagedEntity = em.find(Options.class,op_id);
Portfolio portfolioManagedEntity = em.find(Portfolio.class, p_id);
List <Options>  op= portfolioManagedEntity.getAllOptions();
op.add(optionManagedEntity);
	}
	@Override
	public List<Portfolio> findPortfolioById(int p_id) {


		TypedQuery<Portfolio> query=em.createQuery("SELECT p FROM Portfolio p WHERE p.id =:p_id",Portfolio.class);
		query.setParameter("p_id",p_id);
		return(query.getResultList());
	}
	@Override
	public void Updateopport(int id_op, Integer id_port) {
Options op=em.find(Options.class, id_op);
Portfolio port =em.find(Portfolio.class, id_port);
op.setPortfolio(port);

	}
	@Override
	public Options getOptionById(int id) {
		return em.find(Options.class, id);
	}
	@Override
	public Integer getIdPortByTrader(Integer idTrader)
	{
		TypedQuery<Integer> query=em.createQuery("SELECT c.id from Trader c where c.id=:Traderid",Integer.class);
		Integer idPortfolio=query.setParameter("idTrader", idTrader).getSingleResult();
		return idPortfolio;
	}
	
	
	
	@Override
	public Integer getAccountbyTrader(Integer Traderid) {
		TypedQuery<Integer> query=em.createQuery("SELECT c.id from Account c where c.id=:Traderid",Integer.class);
Integer  idAccount=query.setParameter("Traderid", Traderid).getSingleResult();
return  idAccount;
	}
	@Override
	public Account getAccountById(Integer id_account) {
	Account acc=em.find(Account.class,id_account);
		return acc;
	}

 @Override
	public Integer getPortfoliobyTrader(Integer Traderid) {
TypedQuery<Integer> query=em.createQuery("SELECT c.id from Trader c where c.id=:Traderid",Integer.class);
Integer  idportfolio=query.setParameter("Traderid", Traderid).getSingleResult();
return  idportfolio;

	
	}

}
	
	



