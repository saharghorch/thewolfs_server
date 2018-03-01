package tn.esprit.thewolfs_server.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.thewolfs_server.entity.Account;

@Remote
public interface AccountServiceRemote {
	public int addAccount(Account account);
	public void updateAccount(Account account);
	public void removeAccount(int idAccount);
	public Account displayAccountById(Integer idAccount);
	public List<Account> displayAllAccounts();
	

}