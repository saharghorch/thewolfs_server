package tn.esprit.thewolfs_server.services;
//import org.apache.commons.math3.distribution.NormalDistribution;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.thewolfs_server.entity.Asset;
import tn.esprit.thewolfs_server.entity.Options;
import tn.esprit.thewolfs_server.entity.Status;
import tn.esprit.thewolfs_server.entity.Type;
import tn.esprit.thewolfs_server.entity.Watchlist;
@Stateless
public class WatchlistService implements WatchlistServiceRemote {
	
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
	System.out.println("p is :"+p);
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
	
	}
	
	

	
	
	
	/*
	
    

}
*/