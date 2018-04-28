package tn.esprit.thewolfs_server.presentation.mbeans;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

//import additions.CNT;
import tn.esprit.thewolfs_server.entity.Gender;
import tn.esprit.thewolfs_server.entity.Role;
import tn.esprit.thewolfs_server.entity.User;
import tn.esprit.thewolfs_server.services.UserServiceRemote;

@ManagedBean
@ViewScoped
public class UserBean {

	@EJB
	UserServiceRemote userService;

	private String first_name;
	private String last_name;
	private Gender gender;
	private Date birth_date;
	private String email;
	private Long phone;
	private String password;
	private Role role;
	private List<User> users;
	private User selectedUser ;

	public User getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(User selectedUser) {
		this.selectedUser = selectedUser;
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

	public List<User> getUsers() {
		return userService.dispalyAllUsers();
	}
	
	@PostConstruct
	public void init () {
		
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public void addUser() {
		User u = new User(first_name, last_name, gender, birth_date, email, phone, password, role);
		userService.createUser(u);

	}

	public void removeUser() {
		userService.removeUser(selectedUser.getId());
	}
	
	public void uploadUpdateData () {
		this.first_name=selectedUser.getFirst_name(); 
	}
	
	public void updateUser () {
		System.out.println("hola");
	}
	
	public void bannUser() {
		userService.bannUser(selectedUser.getId());
	}

	public UserBean() {
		super();
	}
	
	public void unBannUser () {
		userService.unBannUser(selectedUser.getId());
	}
	
}
