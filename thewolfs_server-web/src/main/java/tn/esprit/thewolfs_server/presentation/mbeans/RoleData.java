package tn.esprit.thewolfs_server.presentation.mbeans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import tn.esprit.thewolfs_server.entity.Role;

@ManagedBean 
@ApplicationScoped
public class RoleData {
	public Role[] getRoles () {
		return Role.values(); 
		}

}
