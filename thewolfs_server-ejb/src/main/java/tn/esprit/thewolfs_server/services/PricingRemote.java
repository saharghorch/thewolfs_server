package tn.esprit.thewolfs_server.services;

import javax.ejb.Remote;

@Remote
public interface PricingRemote {
	public Double CallOptionPrice(Double s,Double x,Double sigma,Double r,Double t);
	public Double PutOptionPrice(Double s,Double x,Double sigma,Double r,Double t);



}
