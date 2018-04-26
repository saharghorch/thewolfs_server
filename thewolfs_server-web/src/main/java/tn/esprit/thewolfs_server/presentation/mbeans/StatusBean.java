package tn.esprit.thewolfs_server.presentation.mbeans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import tn.esprit.thewolfs_server.entity.Status;

@ManagedBean
@ApplicationScoped
public class StatusBean {
	public Status[] getStatus(){
		return Status.values();
	}

}
