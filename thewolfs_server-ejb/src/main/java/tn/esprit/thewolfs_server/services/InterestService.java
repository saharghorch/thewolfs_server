package tn.esprit.thewolfs_server.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.thewolfs_server.entity.Interest;
import tn.esprit.thewolfs_server.entity.Trader;
import tn.esprit.thewolfs_server.entity.TypeRate;

@Stateless
public class InterestService  implements InterestServiceRemote{

	
	@PersistenceContext(unitName="thewolfs_server-ejb")
	EntityManager em;
	
	public int addInterest(Interest interest) {
		em.persist(interest);
		return interest.getId();
	}
	@Override
	public Double CalculSimpleInterestPrincipale(Double amount, Double rate, Integer period) {
		Double P = amount/(1+rate*period);
		return P;
	}

	@Override
	public Double CalculCompoundInterestPrincipale(Double amount, Double rate, Integer period,TypeRate typeRate) {
		Double P=0d;
		 
		 if (typeRate==TypeRate.annually){
			 P= amount/ Math.pow((1+rate), period);
		 }else if (typeRate==TypeRate.semiAnnually) {
			 P= amount/Math.pow((1+(rate/2)), (period*2)); 
		 }else if (typeRate==TypeRate.quarterly) {
			 P= amount/Math.pow((1+(rate/4)), (period*4)); 
		 }else if (typeRate==TypeRate.monthly) {
			 P= amount/ Math.pow((1+(rate/12)), (period*12)); 
		 }else if (typeRate==TypeRate.daily) {
			 P= amount/ Math.pow((1+(rate/365)), (period*365)); 
		 }else if (typeRate==TypeRate.continuously) {
			 P= amount/Math.pow(2.7183,rate*period);
		 }else System.out.println("impossible");
		 
		 return P;
	}

	@Override
	public Double CalculSimpleInterestAmount(Double principale, Double rate, Integer period) {
		Double A = principale*(1+rate*period);
		return A;
	}

	@Override
	public Double CalculCompoundInterestAmount(Double principale, Double rate, Integer period,TypeRate typeRate) {
		Double A=0d;
		 
		 if (typeRate==TypeRate.annually){
		 A= principale* Math.pow((1+rate), period);
		 }else if (typeRate==TypeRate.semiAnnually) {
			 A= principale* Math.pow((1+(rate/2)), (period*2)); 
		 }else if (typeRate==TypeRate.quarterly) {
			 A= principale* Math.pow((1+(rate/4)), (period*4)); 
		 }else if (typeRate==TypeRate.monthly) {
			 A= principale* Math.pow((1+(rate/12)), (period*12)); 
		 }else if (typeRate==TypeRate.daily) {
			 A= principale* Math.pow((1+(rate/365)), (period*365)); 
		 }else if (typeRate==TypeRate.continuously) {
			 A= principale*Math.pow(2.7183,rate*period);
		 }else System.out.println("impossible");
		 
		 return A;
	}

}
