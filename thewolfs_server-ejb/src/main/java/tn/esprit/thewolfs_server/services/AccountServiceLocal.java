package tn.esprit.thewolfs_server.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.thewolfs_server.entity.Account;

@Local
public interface AccountServiceLocal {
	public int addAccount(Account account);
	public void updateAccount(Account account);
	public void removeAccount(int idAccount);
	public Account displayAccountById(Integer idAccount);
	public List<Account> displayAllAccounts();

	public void assignAccountToTrader(Integer idAccount,Integer idTrader);
	public List<Account> findAccountByAmount(Float amountAccount);

	public long numberAccountEUR();
	public long numberAccountUSD();
	public long numberAccountSAR();
	public List<Account> findAllAccountByTrader(Integer traderId);
}
