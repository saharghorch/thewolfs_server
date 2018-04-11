package tn.esprit.thewolfs_server.services;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;


import javax.mail.MessagingException;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.thewolfs_server.entity.Role;
import tn.esprit.thewolfs_server.entity.User;
import tn.esprit.thewolfs_server.entity.UserAccountStatus;
import tn.esprit.thewolfs_server.entity.UserState;

@Stateless
public class UserService implements UserServiceRemote {

	@PersistenceContext(unitName="thewolfs_server-ejb")
	EntityManager entityManager ;
	
	@Override
	public void createUser(User u ) {
		String token = generateRandomToken() ; 
		u.setUserActivationToken(token);
		List <User> user = findUserByEmail(u.getEmail()); 
		if (user.size()==0) {
			u.setPassword(md5Hash(token));	
			sendMail(u.getEmail(), token );
			entityManager.persist(u);
		}	
				 
	}

	@Override
	public void updateUser(User u) {
		String ps = u.getPassword(); 
		u.setPassword(md5Hash(ps));
		entityManager.merge(u); 	
	}

	@Override
	public void displayUser(User u) {
		
		
	}



	@Override
	public void removeUser(Integer id) {
			User u = entityManager.find(User.class, id) ;  
			entityManager.remove(u);	
	}

	@Override
	public List<User> dispalyAllUsers() {
		
			TypedQuery q = entityManager.createQuery("Select x from User AS x" , User.class); 
			List <User> result = q.getResultList() ; 
	return result ; 
	}

	@Override
	public void bannUser(Integer id) {
		User us =entityManager.find(User.class,id ); 
		us.setState(UserState.Banned);
		entityManager.merge(us);
		
	}

	@Override
	public void unBannUser(Integer id) {
		User us =entityManager.find(User.class,id ); 
		us.setState(UserState.NotBanned);
		entityManager.merge(us);
		
	}

	@Override
	public String md5Hash(String password) {
		String hashedpassword = null ; 
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes(),0,password.length());
			hashedpassword = new BigInteger(1,md.digest()).toString(); 		
		}
		 catch (NoSuchAlgorithmException e ){
			 e.printStackTrace();
		 }		
		return hashedpassword;
	}

	@Override
	public void sendMail (String mail,String contenu) {
		  Properties props = new Properties();
		    
		  	props.put("mail.smtp.starttls.enable", true);	  
		    props.put("mail.smtp.host", "smtp.gmail.com");
	        props.put("mail.smtp.user", "thewolfspi@gmail.com");
	        props.put("mail.smtp.password", "APImailpi");
	        props.put("mail.smtp.port", 587);
	        props.put("mail.smtp.auth", true);
	        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		    Session session = Session.getInstance(props, null);

		    try {
		        MimeMessage msg = new MimeMessage(session);
		        msg.setFrom("thewolfspi@gmail.com");
		        msg.setRecipients(Message.RecipientType.TO,mail);
		        msg.setSubject("Ideca2.0 Activation");
		        msg.setSentDate(new Date());
		        msg.setText("Your Account Activation and default password is : "+ contenu);
		        Transport.send(msg, "thewolfspi@gmail.com", "APImailpi");
		    } catch (MessagingException mex) {
		        System.out.println("send failed, exception: " + mex);
		    }

	}
	
	@Override
	public String generateRandomToken() {
		Random random = new Random() ; 
		String chars ="abcdefghijkmnopqrstuvwxyzABCDEFGHJKLMNOPQRSTUVWXYZ234567890" ; 
		StringBuilder token = new StringBuilder(4); 
		for (int i=0 ; i<4 ; i++ ){
		   token.append(chars.charAt(random.nextInt(chars.length())));
	   }
	   
	    return (token.toString());
	}

	@Override
	public List <User> findUserByEmail(String email) {
		TypedQuery q = entityManager.createQuery("Select x from User AS x where x.email = :mail " , User.class); 
		q.setParameter("mail", email);
		List <User> result =  q.getResultList();
		return result ; 		
	}

	@Override
	public boolean validateUserAccount(Integer id, String showedtoken) {
		User u = entityManager.find(User.class,id); 
		if (u.getUserActivationToken().equals(showedtoken)){
			u.setAccountstate(UserAccountStatus.VALID);
			return true;
		}
		return false;
	}

	@Override
	public List<User> dispalyAllAdmins() {
		TypedQuery q = entityManager.createQuery("Select x from User AS x where x.role = :role " , User.class); 
		q.setParameter("role", Role.Administrator);
		List <User> result =  q.getResultList();
		return result ; 
		
	}

	@Override
	public List<User> dispalyAllBackOfficeAdmins() {
		TypedQuery q = entityManager.createQuery("Select x from User AS x where x.role = :role " , User.class); 
		q.setParameter("role", Role.BackOfficeUser);
		List <User> result =  q.getResultList();
		return result ;
	}

	@Override
	public List<User> dispalyAllValidAccounts() {
		TypedQuery q = entityManager.createQuery("Select x from User AS x where x.accountstate = :accounts " , User.class); 
		q.setParameter("accounts", UserAccountStatus.VALID);
		List <User> result =  q.getResultList();
		return result ;
	}

	@Override
	public List<User> dispalyAllNonValidAccounts() {
		TypedQuery q = entityManager.createQuery("Select x from User AS x where x.accountstate = :accounts " , User.class); 
		q.setParameter("accounts", UserAccountStatus.NOTVALID);
		List <User> result =  q.getResultList();
		return result ;
	}

	@Override
	public List<User> dispalyAllBannedAccounts() {
		TypedQuery q = entityManager.createQuery("Select x from User AS x where x.state = :st " , User.class); 
		q.setParameter("st", UserState.Banned);
		List <User> result =  q.getResultList();
		return result ;
	}

	@Override
	public List<User> dispalyAllNotBannedAccounts() {
		TypedQuery q = entityManager.createQuery("Select x from User AS x where x.state = :st " , User.class); 
		q.setParameter("st", UserState.NotBanned);
		List <User> result =  q.getResultList();
		return result ;
	}

	@Override
	public List <User> loginQuery(String email, String username, String password) {
		TypedQuery q = entityManager.createQuery("Select x from User AS x where x.email = :mail and x.password = :pswd" , User.class);
		q.setParameter("mail", email);  
		q.setParameter("pswd", md5Hash(password)) ; 
		List <User> result =  q.getResultList();
	
		return result ;
	}

	@Override
	public boolean changePassword(String mail, String newpassword, String showedtoken) {
		List <User> u= findUserByEmail(mail); 
		if (u.isEmpty()){
			return false ; 
		}
		User us = u.get(0); 
		if (us.getUserActivationToken().equals(showedtoken)){
			us.setPassword(newpassword);
			updateUser(us);
			return true;
		}
		
		return false;
	}

	@Override
	public boolean sendRecover(String mail) {
		List <User> u= findUserByEmail(mail); 
		if (u.isEmpty()){
			return false ; 
		}
		User us = u.get(0); 
		String token = generateRandomToken(); 
		us.setUserActivationToken(token);
		sendMailPassword(mail,token);
		return true ; 
	}

	@Override
	public void sendMailPassword(String mail, String contenu) {
		  Properties props = new Properties();
		    
		  	props.put("mail.smtp.starttls.enable", true);	  
		    props.put("mail.smtp.host", "smtp.gmail.com");
	        props.put("mail.smtp.user", "thewolfspi@gmail.com");
	        props.put("mail.smtp.password", "APImailpi");
	        props.put("mail.smtp.port", 587);
	        props.put("mail.smtp.auth", true);
	        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		    Session session = Session.getInstance(props, null);

		    try {
		        MimeMessage msg = new MimeMessage(session);
		        msg.setFrom("thewolfspi@gmail.com");
		        msg.setRecipients(Message.RecipientType.TO,mail);
		        msg.setSubject("Ideca2.0 password recovery");
		        msg.setSentDate(new Date());
		        msg.setText("your key to reset your password is : "+ contenu);
		        Transport.send(msg, "thewolfspi@gmail.com", "APImailpi");
		    } catch (MessagingException mex) {
		        System.out.println("send failed, exception: " + mex);
		    }
		
	}



}
