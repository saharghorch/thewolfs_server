package tn.esprit.thewolfs_server.services;

import javax.ejb.Local;

import tn.esprit.thewolfs_server.entity.User;

@Local
public interface UserServiceLocal {
	void CreateUser(User U ) ; 
	void RemoveUser (Integer id); 
	void UpdateUser (Integer id , User U); 
	void DisplayUser (User U); 

}
