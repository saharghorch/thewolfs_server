package tn.esprit.thewolfs_server.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class StatusTrader implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String description;
	@Temporal(TemporalType.DATE)
	private Date publicationDate;
	private Integer likesNumber=0;
	private Integer dislikesNumber=0;
	private Integer viewsNumber=0;
	@ManyToOne
	private Trader trader;
	@OneToMany(mappedBy="statusTrader")
	private List<Comment> comments;
	
	
	public StatusTrader() {
		super();
	}


	public StatusTrader(String description) {
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


	public Integer getLikesNumber() {
		return likesNumber;
	}


	public void setLikesNumber(Integer likesNumber) {
		this.likesNumber = likesNumber;
	}


	public Integer getDislikesNumber() {
		return dislikesNumber;
	}


	public void setDislikesNumber(Integer dislikesNumber) {
		this.dislikesNumber = dislikesNumber;
	}


	public Integer getViewsNumber() {
		return viewsNumber;
	}


	public void setViewsNumber(Integer viewsNumber) {
		this.viewsNumber = viewsNumber;
	}


	public Trader getTrader() {
		return trader;
	}


	public void setTrader(Trader trader) {
		this.trader = trader;
	}
	
	public List<Comment> getComments() {
		return comments;
	}


	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}


	@Override
	public String toString() {
		return "StatusTrader [id=" + id + ", description=" + description + ", publicationDate=" + publicationDate
				+ ", likesNumber=" + likesNumber + ", dislikesNumber=" + dislikesNumber + ", viewsNumber=" + viewsNumber
				+ ", trader=" + trader + "]";
	}
	
	
	
	

}
