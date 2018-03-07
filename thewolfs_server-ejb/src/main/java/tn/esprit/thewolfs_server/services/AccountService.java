package tn.esprit.thewolfs_server.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.thewolfs_server.entity.Account;
import tn.esprit.thewolfs_server.entity.Trader;
@Stateless
public class AccountService implements AccountServiceRemote{
	@PersistenceContext(unitName="thewolfs_server-ejb")
	EntityManager em;
	@Override
	public int addAccount(Account account) {
		em.persist(account);
		return (account.getId());
	}
	@Override
	public void updateAccount(Account account) {
		em.merge(account);
		
	}
	@Override
	public void removeAccount(int idAccount) {
		Account account=em.find(Account.class, idAccount);
		em.remove(account);
		
	}
	@Override
	public Account displayAccountById(Integer idAccount) {
	TypedQuery<Account> query=em.createQuery("SELECT c FROM Account c WHERE c.id= :idAccount",Account.class);
		return query.setParameter("idAccount", idAccount).getSingleResult();
	}
	@Override
	public List<Account> displayAllAccounts() {
	TypedQuery<Account> query=em.createQuery("SELECT c FROM Account c",Account.class);
		return (query.getResultList());
	}
	@Override
	public void assignAccountToTrader(Integer idAccount, Integer idTrader) {
		Trader traderManagedEntity=em.find(Trader.class, idTrader);
		Account accountManagedEntity=em.find(Account.class, idAccount);
		traderManagedEntity.getAccounts().add(accountManagedEntity);
	}
	@Override
	public List<Account> findAccountByAmount(Float amountAccount) {
		TypedQuery<Account> query=em.createQuery("SELECT a FROM Account a WHERE a.amount =:amountAccount",Account.class);
		query.setParameter("amountAccount",amountAccount);
		return(query.getResultList());
		
	}
	
	
	

}
