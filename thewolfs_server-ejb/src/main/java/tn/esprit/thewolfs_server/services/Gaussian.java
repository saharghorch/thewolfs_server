package tn.esprit.thewolfs_server.services;

public abstract class Gaussian {
	 public static Double pdf(Double x) {
	        return Math.exp(-x*x / 2) / Math.sqrt(2 * Math.PI);
	    }
	  public static Double pdf(Double x, Double mu, Double sigma) {
	        return pdf((x - mu) / sigma) / sigma;
	    }
	
	  public static Double cdf(Double z) {
	        if (z < -8.0) return 0.0;
	        if (z >  8.0) return 1.0;
	        Double sum = 0.0, term = z;
	        for (int i = 3; sum + term != sum; i += 2) {
	            sum  = sum + term;
	            term = term * z * z / i;
	        }
	        return 0.5 + sum * pdf(z);
	    }
	   public static Double cdf(Double z, Double mu, Double sigma) {
	        return cdf((z - mu) / sigma);
	    } 
	 

}
