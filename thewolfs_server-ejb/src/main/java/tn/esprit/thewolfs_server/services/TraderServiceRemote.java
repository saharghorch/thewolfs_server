
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
	public List<Trader> findTraderByName(String firstname);
	public Trader findTraderById (Integer idTrader);
	public Trader Traderexiste(Trader trader);
	public long calculerLevel1();
	public long calculerLevel2();
	public long calculerLevel3();
	public List <Trader> loginQuery(String email,String password);
	
}

