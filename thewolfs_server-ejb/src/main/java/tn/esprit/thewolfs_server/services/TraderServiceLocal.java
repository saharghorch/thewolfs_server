package tn.esprit.thewolfs_server.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.thewolfs_server.entity.Trader;

@Local
public interface TraderServiceLocal {
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
	public Trader login(String email,String password);
	
}
