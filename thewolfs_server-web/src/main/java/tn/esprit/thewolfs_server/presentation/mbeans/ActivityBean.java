package tn.esprit.thewolfs_server.presentation.mbeans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import tn.esprit.thewolfs_server.entity.Activity;

@ManagedBean
@ApplicationScoped
public class ActivityBean {
	public Activity[] getActivities(){
		return Activity.values();
	}
}
