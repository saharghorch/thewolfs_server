package tn.esprit.thewolfs_server.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class User implements Serializable{
	
@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer id ;
private String firstname;
private String lastname;
private String email;
private Long phone;
private String password;
private String gender;
@Temporal(TemporalType.TIMESTAMP)
private Date birthdate;
@Enumerated(EnumType.STRING)
private Role role;
@OneToMany(mappedBy="user")
private List <Options> options;
@OneToMany(mappedBy="user")
private List<Trade> trades;
@OneToOne
private Portfolio portfolio;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Long getPhone() {
	return phone;
}
public void setPhone(Long phone) {
	this.phone = phone;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public Date getBirthdate() {
	return birthdate;
}
public void setBirthdate(Date birthdate) {
	this.birthdate = birthdate;
}
public Role getRole() {
	return role;
}
public void setRole(Role role) {
	this.role = role;
}
public List<Options> getOptions() {
	return options;
}
public void setOptions(List<Options> options) {
	this.options = options;
}
public List<Trade> getTrades() {
	return trades;
}
public void setTrades(List<Trade> trades) {
	this.trades = trades;
	
}
public Portfolio getPortfolio() {
	return portfolio;
}
public void setPortfolio(Portfolio portfolio) {
	this.portfolio = portfolio;
}

}
