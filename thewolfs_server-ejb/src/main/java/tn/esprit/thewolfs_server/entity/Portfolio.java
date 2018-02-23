package tn.esprit.thewolfs_server.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Portfolio implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private  Integer id;
@OneToOne (mappedBy="portfolio")
private User user;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
 
}
