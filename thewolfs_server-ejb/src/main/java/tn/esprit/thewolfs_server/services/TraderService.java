package tn.esprit.thewolfs_server.services;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import tn.esprit.thewolfs_server.entity.Level;
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
	TypedQuery<Trader> query=em.createQuery("SELECT c FROM Trader c",Trader.class);
	return(query.getResultList());
	}


	@Override
	public List<Trader> findTraderByName(String firstname) {
		TypedQuery<Trader> query=em.createQuery("SELECT e FROM"
				+ " Trader e WHERE e.first_name =:param",Trader.class);
		query.setParameter("param", firstname);
		return(query.getResultList());
	}

	@Override
	public Trader Traderexiste(Trader trader) {
		try{
		TypedQuery<Trader> query=em.createQuery("SELECT e FROM Trader e WHERE e.email =:param",Trader.class);
		return(query.setParameter("param", trader.getEmail()).getSingleResult());
		}catch (EntityNotFoundException ex) {
	    } catch (NoResultException ex) {
	    }
	    return null;
	}

	@Override
	public long calculerLevel1() {
		javax.persistence.Query query = em.createQuery("SELECT COUNT(t) FROM Trader t WHERE t.level =:param");
		query.setParameter("param", Level.firstLevel); 
		long nombre=(long)query.getSingleResult();
		return nombre;
		
	}

	@Override
	public long calculerLevel2() {
		javax.persistence.Query query = em.createQuery("SELECT COUNT(t) FROM Trader t WHERE t.level =:param");
		query.setParameter("param", Level.secondLevel); 
		long nombre=(long)query.getSingleResult();
		return nombre;
		
	}

	@Override
	public long calculerLevel3() {
		javax.persistence.Query query = em.createQuery("SELECT COUNT(t) FROM Trader t WHERE t.level =:param");
		query.setParameter("param", Level.thirdLevel); 
		long nombre=(long)query.getSingleResult();
		return nombre;
		
	}

	@Override
	public List<Trader> loginQuery(String email, String password) {
		TypedQuery q = em.createQuery("Select x from Trader AS x where x.email = :mail and x.password = :pswd" , Trader.class);
		q.setParameter("mail", email);  
		q.setParameter("pswd", password) ; 
		List <Trader> result =  q.getResultList();
	
		return result ;
	}

	



	

	
	
	



}
