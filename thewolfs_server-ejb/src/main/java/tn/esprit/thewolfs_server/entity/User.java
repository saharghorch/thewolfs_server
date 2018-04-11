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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class User implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String first_name;
	private String last_name;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	private Double solde;
	@Temporal(TemporalType.DATE)
    private Date birth_date;
	private String email;
	private Long phone;
	private String password;
	@Enumerated(EnumType.STRING)
	private Role role;
	@Enumerated(EnumType.STRING)
	private UserState state ; 
	//@OneToMany(mappedBy="user")
	//private List<Options> options;
	@Enumerated(EnumType.STRING)
	private UserAccountStatus accountstate; 
	private String userActivationToken ; 
	@ManyToOne
	private Trader trader;
	
	
	public String getUserActivationToken() {
		return userActivationToken;
	}
	public void setUserActivationToken(String userActivationToken) {
		this.userActivationToken = userActivationToken;
	}
	public UserAccountStatus getAccountstate() {
		return accountstate;
	}
	public void setAccountstate(UserAccountStatus accountstate) {
		this.accountstate = accountstate;
	}
	public UserState getState() {
		return state;
	}
	public void setState(UserState state) {
		this.state = state;
	}
	public User() {
		super();
	}
	public User( String first_name, String last_name, Gender gender, Date birth_date, String email,
			Long phone, String password, Role role ) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.gender = gender;
		this.birth_date = birth_date;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.role = role;
		this.state= UserState.NotBanned;
		this.accountstate = UserAccountStatus.NOTVALID ;
		this.userActivationToken = null ; 
		//this.options = options;
	}
	
	public User(String first_name, String last_name, Gender gender, Double solde, Date birth_date, String email,
			Long phone, String password, Role role, Trader trader) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.gender = gender;
		this.solde = solde;
		this.birth_date = birth_date;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.role = role;
		this.trader = trader;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Date getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
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
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
		
		
	}
	public Double getSolde() {
		return solde;
	}
	public void setSolde(Double solde) {
		this.solde = solde;
	}
	/*public List<Options> getOptions() {
		return options;
	}
	public void setOptions(List<Options> options) {
		this.options = options;
	}*/
	@Override
	public String toString() {
		return "User [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", gender=" + gender
				+ ", birth_date=" + birth_date + ", email=" + email + ", phone=" + phone + ", password=" + password
				+ ", role=" + role + ", state=" + state + ", accountstate=" + accountstate + ", userActivationToken="
				+ userActivationToken + "]";
	}

	
	

}
