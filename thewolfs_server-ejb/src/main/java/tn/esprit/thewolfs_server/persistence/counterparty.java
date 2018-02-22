package tn.esprit.thewolfs_server.persistence;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class counterparty implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
private String nom;

public int getId() {
	return id;
}
public String getNom() {
	return nom;
}
public void setId(int id) {
	this.id = id;
}
public void setNom(String nom) {
	this.nom = nom;
}


	
}
