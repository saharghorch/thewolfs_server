package tn.esprit.thewolfs_server.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.thewolfs_server.persistence.Todo;

@Local
public interface TodoServiceLocal {
	
	void create(Todo todo);
	List<Todo> findAll();

}
