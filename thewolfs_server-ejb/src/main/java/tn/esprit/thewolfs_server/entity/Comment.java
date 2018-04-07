package tn.esprit.thewolfs_server.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Comment implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String description;
	@Temporal(TemporalType.DATE)
	private Date publicationDate;
	@ManyToOne Trader trader;
	@ManyToOne StatusTrader statusTrader;
	
	public Comment() {
		super();
	}

	public Comment(String description) {
		super();
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public Trader getTrader() {
		return trader;
	}

	public void setTrader(Trader trader) {
		this.trader = trader;
	}
	

	public StatusTrader getStatusTrader() {
		return statusTrader;
	}

	public void setStatusTrader(StatusTrader statusTrader) {
		this.statusTrader = statusTrader;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", description=" + description + ", publicationDate=" + publicationDate
				+ ", trader=" + trader + "]";
	}
	
	
	

}
