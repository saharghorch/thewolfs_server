package tn.esprit.thewolfs_server.presentation.mbeans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import tn.esprit.thewolfs_server.entity.Gender; 

@ManagedBean
@ApplicationScoped
public class GenderData {
	
 public Gender[] getGender(){
	return Gender.values(); 
 }
}
