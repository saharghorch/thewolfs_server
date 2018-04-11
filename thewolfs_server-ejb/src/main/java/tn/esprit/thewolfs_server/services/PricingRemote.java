package tn.esprit.thewolfs_server.services;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.ejb.Remote;

@Remote
public interface PricingRemote {
	public Double CallOptionPrice(Double s,Double x,Double sigma,Double r,Double t);
	public Double PutOptionPrice(Double s,Double x,Double sigma,Double r,Double t);
	public long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) ;
	


}
