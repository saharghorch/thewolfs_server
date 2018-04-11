package tn.esprit.thewolfs_server.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.thewolfs_server.entity.User;

@Remote
public interface UserServiceRemote {
	List <User> dispalyAllUsers () ; 
	void createUser(User u ) ; 
	void removeUser (Integer id); 
	void updateUser (User u); 
	void displayUser (User u); 
	void bannUser ( Integer id ) ; 
	void unBannUser (Integer id ); 
	String md5Hash (String password ); 
	void sendMail (String mail,String contenu); 
	String generateRandomToken(); 
	List <User>  findUserByEmail ( String email ) ;
	boolean validateUserAccount(Integer id , String showedtoken) ; 
	List <User> dispalyAllAdmins () ;
	List <User> dispalyAllBackOfficeAdmins () ;
	List <User> dispalyAllValidAccounts () ;
	List <User> dispalyAllNonValidAccounts () ;
	List <User> dispalyAllBannedAccounts () ;
	List <User> dispalyAllNotBannedAccounts () ;
	List <User> loginQuery(String email, String username , String password) ; 
	boolean changePassword (String mail , String newpassword , String showedtoken ); 
	void sendMailPassword (String mail , String contenu);
	boolean sendRecover (String mail); 
}
