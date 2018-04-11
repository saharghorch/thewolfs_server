package tn.esprit.thewolfs_server.services;

import javax.ejb.Remote;

import tn.esprit.thewolfs_server.entity.Interest;
import tn.esprit.thewolfs_server.entity.TypeRate;

@Remote
public interface InterestServiceRemote {

		public int addInterest(Interest interest);
		public Double CalculSimpleInterestPrincipale (Double amount, Double rate, Integer period);
		public Double CalculCompoundInterestPrincipale (Double amount, Double rate, Integer period,TypeRate typeRate);
		public Double CalculSimpleInterestAmount (Double principale, Double rate, Integer period);
		public Double CalculCompoundInterestAmount(Double principale, Double rate, Integer period,TypeRate typeRate);
		

}
