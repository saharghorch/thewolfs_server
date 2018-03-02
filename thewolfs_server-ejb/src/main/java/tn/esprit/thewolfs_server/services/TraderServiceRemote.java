package tn.esprit.thewolfs_server.services;



import java.util.List;
import java.util.Set;

import javax.ejb.Remote;
import javax.persistence.EntityManager;

import tn.esprit.thewolfs_server.entity.Trader;

@Remote
public interface TraderServiceRemote {
	public int addTrader(Trader trader);
	public int updateTrader(Trader trader);
	public void deleteTraderById(int traderId);
	public List<Trader> dislayTrader();
}
