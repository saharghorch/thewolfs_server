package tn.esprit.thewolfs_server.services;


import java.util.List;

import javax.ejb.Remote;

import tn.esprit.thewolfs_server.entity.StatusTrader;
@Remote
public interface StatusTraderServiceRemote {
	public int addStatusTrader(StatusTrader statusTrader);
	public void updateStatusTrader(StatusTrader statusTrader);
	public void removeStatusTrader(Integer idStatusTrader);
	public List<StatusTrader> displayAllStatus();
	public StatusTrader findStatusTraderById(Integer idStatusTrader);
}
