package tn.esprit.thewolfs_server.services;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.ejb.Stateless;

@Stateless
public class Pricing implements PricingRemote,PricingLocal {

	@Override
	public Double CallOptionPrice(Double s, Double x, Double sigma, Double r, Double t) {
		Double d1 = (Math.log(s / x) + (r + sigma * sigma / 2) * t) / (sigma * Math.sqrt(t));
		Double d2 = d1 - sigma * Math.sqrt(t);
		return s * Gaussian.cdf(d1) - x * Math.exp(-r * t) * Gaussian.cdf(d2);

	}

	@Override
	public Double PutOptionPrice(Double s, Double x, Double sigma, Double r, Double t) {
		Double d1 = (Math.log(s / x) + (r + sigma * sigma / 2) * t) / (sigma * Math.sqrt(t));
		Double d2 = d1 - sigma * Math.sqrt(t);
		return -s * Gaussian.cdf(-d1) + x * Math.exp(-r * t) * Gaussian.cdf(-d2);
	}

	/***************** Date Difference ****************/
	public long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
		long diffInMillies = date2.getTime() - date1.getTime();
		return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
	}

}
