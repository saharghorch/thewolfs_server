package tn.esprit.thewolfs_server.services;

import java.util.List;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.thewolfs_server.entity.Account;
import tn.esprit.thewolfs_server.entity.Asset;
import tn.esprit.thewolfs_server.entity.Options;
import tn.esprit.thewolfs_server.entity.Status;
import tn.esprit.thewolfs_server.entity.Trader;

import tn.esprit.thewolfs_server.entity.Type;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class OptionsManager implements OptionsRemote,OptionsLocal {
	@PersistenceContext(unitName = "thewolfs_server-ejb")

	EntityManager em;

	public int addOption(Options option) {
		em.persist(option);
		return option.getId();
	}

	@Override
	public void deleteOption(int id) {
		em.remove(em.find(Options.class, id));
	}

	@Override
	public Options getOptionById(int id) {

		return em.find(Options.class, id);
	}

	@Override
	public void UpdateOptionStatus(int id, Status status) {
		Options option = em.find(Options.class, id);
		option.setStatus(status);

	}

	@Override
	public List<Options> findAll() {
		String jpql = "select o from Options o";
		Query qry = em.createQuery(jpql, Options.class);
		return qry.getResultList();
	}

	@Override
	public List<Options> findOptionsValid(Status Valid, int id) {
		String jpql = "select o from Options o where o.status='" + Valid + "'and o.counterparty IS NULL and o.trader <>"+id;
		Query qry = em.createQuery(jpql, Options.class);
		return qry.getResultList();
	}

	@Override
	public List<Asset> findAssetType() {
		String jpql = "select o from Asset o ";
		Query qry = em.createQuery(jpql, Asset.class);
		return qry.getResultList();
	}

	@Override
	public Trader findTraderById(int id) {
		String jpql = "select o from Trader o where id = '" + id + "' ";
		Query qry = em.createQuery(jpql, Trader.class);
		return (Trader) (qry.getResultList()).get(0);
	}

	@Override
	public void UpdateOptionCounterparty(int id, Trader c) {

		Options option = em.find(Options.class, id);
		option.setCounterparty(c);
	}

	@Override
	public List<Options> findOptionsByTrader(int id) {
		String jpql = "select o from Options o where o.trader=" + id;
		Query qry = em.createQuery(jpql, Options.class);
		return qry.getResultList();
	}

	@Override
	public List<Options> findOptionsByCounterparty(int id) {
		String jpql = "select o from Options o where o.exerce=0 and o.counterparty=" + id;
		Query qry = em.createQuery(jpql, Options.class);
		return qry.getResultList();
	}

	@Override
	public String TimeToExpiry(Date d) {
		long CONST_DURATION_OF_DAY = 1000l * 60 * 60 * 24;
		Date date1 = new Date();
		long numberOfDay;
		long diff = (d.getTime() - date1.getTime());
		numberOfDay = diff / CONST_DURATION_OF_DAY;
		String s = Long.toString(numberOfDay);
		return s;

	}

	@Override
	public Float FindAmountTrader(int id) {
		String jpql = "select o.amount from Account o where o.trader=" + id;
		TypedQuery qry = (TypedQuery) em.createQuery(jpql);
		return (float) qry.getSingleResult();
	}

	@Override
	public void UpdateAmount(int trader_id, float am) {
		Account account = em.find(Account.class, trader_id);
		account.setAmount(am);

	}

	@Override
	public List<Options> findOptionsValidSold(Status Valid) {
		TypedQuery<Options> query = em.createQuery(
				"select o from Options o where o.status='" + Valid + "' and o.counterparty IS NOT NULL", Options.class);
		return query.getResultList();
	}

	@Override
	public List<Options> findOptionsByType(Type type) {
		TypedQuery<Options> query = em.createQuery("select o from Options o where o.type='" + type + "'",
				Options.class);
		return query.getResultList();
	}

	@Override
	public List<Options> displayAllOptions(){
		TypedQuery<Options> query=em.createQuery("SELECT o FROM Options o",Options.class);
		return (query.getResultList());
	}
	@Override
	public String Result(Type type, float p, float k, float s) {
		if (type==Type.Call)
		{
			if (s>k+p)
			{
				return "Won";
			}
			else 
			{
				return "Lost";
			}
		}
		else
		{
			if(s<k-p)	
			{
				return "Won";
			}
			else
			{
				return "Lost";
			}
		}
		
		
	}
	@Override
	public Account FindAccount(int trader_id) { 
		String jpql = "select o from Account o where o.trader= '"+trader_id+"' ";
		TypedQuery qry = em.createQuery(jpql, Account.class);
		return (Account) (qry.getResultList()).get(0);
	}
	@Override
	public Double SumPremium(int trader_id) {
		String jpql = "select SUM(o.premium_price) from Options o where o.trader="+trader_id+"and o.counterparty IS NOT NULL";
		TypedQuery qry = (TypedQuery) em.createQuery(jpql);
		return (Double) qry.getSingleResult();
		
	}
	@Override
	public Float ExerceOption(Type type, float p, float k, float s) {
		Float e;
		if (type==Type.Call)
		{
		 e = s-k-p;
			return e;
		}
		else 
		{
			e = k-s-p;
			return e;
		}
	}
	@Override
	public void UpdateEx(int id) {
		Options option = em.find(Options.class,id);
		option.setExerce(1);
		
	}
	@Override
	public String ResultTrader(Type type, float p, float k, float s) {
		if (type==Type.Call)
		{
			if (s>k +p)
			{
				return "Lost";
			}
			else 
			{
				return "Won";
			}
		}
		else
		{
			if(s<k-p)	
			{
				return "Lost";
			}
			else
			{
				return "Won";
			}
		}
	}

	@Override
	public void UpdateOptionResult(int id, String r) {
		Options option = em.find(Options.class, id);
		option.setResult(r);

		
	}

	@Override
	public List<Options> findOptionsExerced(int id) {
		String jpql = "select o from Options o where o.exerce=1 and o.counterparty=" + id;
		Query qry = em.createQuery(jpql, Options.class);
		return qry.getResultList();
	}

}
