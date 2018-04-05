
package tn.esprit.thewolfs_server.services;
import java.util.List;
import javax.ejb.Remote;


import tn.esprit.thewolfs_server.entity.Trader;

@Remote
public interface TraderServiceRemote {
	public int addTrader(Trader trader);
	public int updateTrader(Trader trader);
	public void deleteTraderById(int traderId);
	public List<Trader> dislayTrader();
	public List<Trader> findTraderByName(String firstname);
	public Trader Traderexiste(Trader trader);
	public Trader findTraderById(Integer idTrader);
	
}

