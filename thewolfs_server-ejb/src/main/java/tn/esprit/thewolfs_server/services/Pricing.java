package tn.esprit.thewolfs_server.services;

import javax.ejb.Stateless;

@Stateless
public class Pricing implements PricingRemote {

	@Override
	public Double CallOptionPrice(Double s, Double x, Double sigma, Double r, Double t) {
		Double d1 = (Math.log(s/x) + (r + sigma * sigma/2) * t) / (sigma * Math.sqrt(t));
		Double d2 = d1 - sigma * Math.sqrt(t);
		return s * Gaussian.cdf(d1) - x * Math.exp(-r*t) * Gaussian.cdf(d2);
		
	}

	@Override
	public Double PutOptionPrice(Double s, Double x, Double sigma, Double r, Double t) {
		Double d1 = (Math.log(s/x) + (r + sigma * sigma/2) * t) / (sigma * Math.sqrt(t));
		Double d2 = d1 - sigma * Math.sqrt(t);
        return -s * Gaussian.cdf(-d1) + x * Math.exp(-r*t) * Gaussian.cdf(-d2);
	}

}
