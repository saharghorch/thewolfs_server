package tn.esprit.thewolfs_server.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Stock implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int shares_number;
	private float total_value;
	@OneToMany(mappedBy="stock")
	private List<Asset> asset;
	
	public Stock() {

	}

	public Stock(int shares_number, float total_value) {
		super();
		this.shares_number = shares_number;
		this.total_value = total_value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getShares_number() {
		return shares_number;
	}

	public void setShares_number(int shares_number) {
		this.shares_number = shares_number;
	}

	public float getTotal_value() {
		return total_value;
	}

	public void setTotal_value(float total_value) {
		this.total_value = total_value;
	}

	public List<Asset> getAsset() {
		return asset;
	}

	public void setAsset(List<Asset> asset) {
		this.asset = asset;
	}
	
	
	

	
		
		
	

}
